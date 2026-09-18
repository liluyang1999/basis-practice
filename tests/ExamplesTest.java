import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** Exercises the actual packaged classes, including command-line file I/O. */
public final class ExamplesTest {
    private static int count;
    public static void main(String[] args) throws Exception {
        for (String name : List.of("BubbleSort", "SelectionSort", "InsertionSort", "ShellSort", "MergeSort",
                "QuickSort", "HeapSort", "CountingSort", "BucketSort", "RadixSort")) {
            Result result = run("sort." + name, "64", "42");
            require(result.code == 0 && result.output.contains("count=64, seed=42"));
        }
        require(run("sort.QuickSort", "-1").code != 0);
        require(run("sort.QuickSort", "0").code == 0);
        for (String name : List.of("others.ExchangeSort", "others.InsertSort", "others.MergeSort", "others.ShellSort",
                "others.HeapSort", "others.PairingHeap", "pattern.creational_pattern.Prototype",
                "pattern.creational_pattern.Builder", "pattern.creational_pattern.FactoryMethod",
                "pattern.creational_pattern.AbstractFactory", "pattern.behavioral_pattern.Command",
                "pattern.behavioral_pattern.ChainOfResponsibility", "pattern.behavioral_pattern.RecordTest",
                "pattern.structural_pattern.Bridge", "pattern.structural_pattern.Composite")) {
            Result result = run(name); require(result.code == 0 && !result.output.isBlank());
        }
        Result facade = run("pattern.structural_pattern.Facade");
        require(facade.code == 0 && facade.output.strip().equals("Square::draw()\nRectangle::draw()\nCircle::draw()"));
        Path file = Path.of(System.getProperty("test.tmpdir"), "cli file 中文.txt");
        try {
            require(runWithInput("中文😀", "nio.FileChannelTest", "write", file.toString()).code == 0);
            Result read = run("nio.FileChannelTest", "read", file.toString());
            require(read.code == 0 && read.output.equals("中文😀"));
            require(run("nio.FileChannelTest", "write", file.toString(), "overwrite").code != 0);
            require(Files.readString(file).equals("中文😀"));
            require(run("nio.FileChannelTest").code != 0);
        } finally { Files.deleteIfExists(file); }
        System.out.println("ExamplesTest: " + count + " packaged CLI checks passed");
    }
    private record Result(int code, String output) { }
    private static Result run(String name, String... args) throws Exception {
        return runWithInput("", name, args);
    }
    private static Result runWithInput(String input, String name, String... args) throws Exception {
        var command = new java.util.ArrayList<>(List.of(Path.of(System.getProperty("java.home"), "bin", "java").toString(),
                "-Dstdout.encoding=UTF-8", "-Dstderr.encoding=UTF-8", "-Duser.language=en", "-Duser.country=US", "-cp",
                System.getProperty("java.class.path"), name));
        command.addAll(List.of(args));
        Process child = new ProcessBuilder(command).redirectErrorStream(true).start();
        try {
            child.getOutputStream().write(input.getBytes(StandardCharsets.UTF_8));
            child.getOutputStream().close();
            if (!child.waitFor(5, TimeUnit.SECONDS)) throw new AssertionError("Example timeout: " + name);
            return new Result(child.exitValue(), new String(child.getInputStream().readAllBytes(), StandardCharsets.UTF_8).replace("\r\n", "\n"));
        } finally {
            if (child.isAlive()) child.destroyForcibly().waitFor();
            child.getInputStream().close(); child.getErrorStream().close();
        }
    }
    private static void require(boolean condition) { count++; if (!condition) throw new AssertionError("CLI check " + count); }
}
