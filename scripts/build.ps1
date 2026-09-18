param([switch]$Test)
$ErrorActionPreference = 'Stop'
Set-StrictMode -Version Latest
$projectRoot = [IO.Path]::GetFullPath((Join-Path $PSScriptRoot '..'))
$buildRoot = Join-Path $projectRoot 'build'
if ((Test-Path -LiteralPath $buildRoot) -and ((Get-Item -LiteralPath $buildRoot).Attributes -band [IO.FileAttributes]::ReparsePoint)) { throw 'build must not be a link.' }
foreach ($commandName in @('javac','java','jar')) { $null = Get-Command $commandName -ErrorAction Stop }
$stage = Join-Path $buildRoot ('.compile-' + [Guid]::NewGuid().ToString('N'))
$classes = Join-Path $stage 'classes'
$testClasses = Join-Path $stage 'tests'
$null = New-Item -ItemType Directory -Path $classes,$testClasses -Force
try {
    $sources = @(Get-ChildItem -LiteralPath (Join-Path $projectRoot 'src') -Filter '*.java' -Recurse | Sort-Object FullName | ForEach-Object FullName)
    & javac '-J-Duser.language=en' '-J-Duser.country=US' --release 19 -encoding UTF-8 -Xlint:all -Werror -d $classes @sources
    if ($LASTEXITCODE -ne 0) { throw 'Java compilation failed.' }
    $stageJar = Join-Path $stage 'basis-practice.jar'
    & jar --create --file $stageJar --date=2023-06-24T00:00:00Z -C $classes .
    if ($LASTEXITCODE -ne 0) { throw 'JAR packaging failed.' }
    if ($Test) {
        $testRoot = Join-Path $projectRoot 'tests'
        $tests = @(Get-ChildItem -LiteralPath $testRoot -Filter '*.java' -Recurse | Sort-Object FullName | ForEach-Object FullName)
        & javac '-J-Duser.language=en' '-J-Duser.country=US' --release 19 -encoding UTF-8 -Xlint:all -Werror -cp $stageJar -d $testClasses @tests
        if ($LASTEXITCODE -ne 0) { throw 'Test compilation failed.' }
        foreach ($testFile in (Get-ChildItem -LiteralPath $testRoot -Filter '*Test.java' -Recurse | Sort-Object FullName)) {
            $testName = [IO.Path]::GetRelativePath($testRoot, $testFile.FullName).Replace('\','.').Replace('/','.').Replace('.java','')
            & java "-Dtest.tmpdir=$stage" '-Duser.language=en' '-Duser.country=US' '-Dstdout.encoding=UTF-8' '-Dstderr.encoding=UTF-8' -ea -cp "$stageJar;$testClasses" $testName
            if ($LASTEXITCODE -ne 0) { throw ('Test failed: ' + $testName) }
        }
    }
    [IO.File]::Move($stageJar, (Join-Path $buildRoot 'basis-practice.jar'), $true)
    Write-Output 'BUILD_OK build/basis-practice.jar (offline, Java release 19)'
} finally {
    $resolvedStage = [IO.Path]::GetFullPath($stage)
    if (-not $resolvedStage.StartsWith($buildRoot + [IO.Path]::DirectorySeparatorChar, [StringComparison]::OrdinalIgnoreCase)) { throw 'Unsafe temporary directory.' }
    if (Test-Path -LiteralPath $resolvedStage) { Remove-Item -LiteralPath $resolvedStage -Recurse -Force }
}
