import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileChannelTest {
    public static void main(String[] args) throws Exception {
        Path directory = Files.createTempDirectory(Path.of(System.getProperty("test.tmpdir")), "nio-");
        Path file = directory.resolve("中文 path.txt");
        Path invalid = directory.resolve("invalid.txt");
        Path tooLarge = directory.resolve("large.txt");
        try {
            String text = "a".repeat(1023) + "汉😀" + "x".repeat(4096) + "\n";
            nio.FileChannelTest.writeNewUtf8(file, text);
            if (!text.equals(nio.FileChannelTest.readUtf8(file))) throw new AssertionError("UTF-8 boundary");
            if (!java.util.Arrays.equals(Files.readAllBytes(file), text.getBytes(StandardCharsets.UTF_8))) throw new AssertionError("byte content");
            rejects(java.nio.file.FileAlreadyExistsException.class, () -> nio.FileChannelTest.writeNewUtf8(file, "new"));
            if (!Files.readString(file).equals(text)) throw new AssertionError("existing file modified");
            rejects(java.nio.file.NoSuchFileException.class, () -> nio.FileChannelTest.readUtf8(invalid));
            if (Files.exists(invalid)) throw new AssertionError("read created missing file");
            rejects(java.nio.charset.CharacterCodingException.class, () -> nio.FileChannelTest.writeNewUtf8(invalid, "\uD800"));
            if (Files.exists(invalid)) throw new AssertionError("malformed input created file");
            Files.write(invalid, new byte[] {(byte) 0xc3, 0x28});
            rejects(java.nio.charset.CharacterCodingException.class, () -> nio.FileChannelTest.readUtf8(invalid));
            Files.writeString(tooLarge, "x".repeat(1_000_001));
            rejects(java.io.IOException.class, () -> nio.FileChannelTest.readUtf8(tooLarge));
            rejects(IllegalArgumentException.class, () -> nio.FileChannelTest.writeNewUtf8(directory.resolve("absent"), "x".repeat(1_000_001)));
            // On Windows deletion also checks that owned channels were closed after failure.
        } finally {
            Files.deleteIfExists(file); Files.deleteIfExists(invalid); Files.deleteIfExists(tooLarge); Files.delete(directory);
        }
        System.out.println("FileChannelTest: UTF-8, limits, failure paths and resource cleanup passed");
    }
    @FunctionalInterface private interface Task { void run() throws Exception; }
    private static void rejects(Class<? extends Exception> type, Task task) throws Exception {
        try { task.run(); } catch (Exception error) { if (type.isInstance(error)) return; throw error; }
        throw new AssertionError("Expected " + type.getSimpleName());
    }
}
