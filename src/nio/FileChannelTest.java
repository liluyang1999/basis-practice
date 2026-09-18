package nio;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/** Explicit UTF-8 I/O. Existing files are never overwritten by the write example. */
public class FileChannelTest {
    private static final int MAX_CHARS = 1_000_000;

    public static String readUtf8(Path path) throws IOException {
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
             Reader reader = Channels.newReader(channel, StandardCharsets.UTF_8.newDecoder()
                     .onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT), 1024)) {
            return readText(reader);
        }
    }

    private static String readText(Reader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        char[] buffer = new char[1024];
        int count;
        while ((count = reader.read(buffer)) != -1) {
            if (result.length() > MAX_CHARS - count) throw new IOException("example read limit exceeded");
            result.append(buffer, 0, count);
        }
        return result.toString();
    }

    public static void writeNewUtf8(Path path, String text) throws IOException {
        if (text.length() > MAX_CHARS) throw new IllegalArgumentException("example write limit exceeded");
        // Validate before creating a file; malformed UTF-16 input cannot leave an empty output.
        StandardCharsets.UTF_8.newEncoder().encode(java.nio.CharBuffer.wrap(text));
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
             Writer writer = Channels.newWriter(channel, StandardCharsets.UTF_8.newEncoder(), 1024)) {
            writer.write(text);
            writer.flush();
            channel.force(true);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 2 && args[0].equals("read")) {
            System.out.print(readUtf8(Path.of(args[1])));
        } else if (args.length == 2 && args[0].equals("write")) {
            try (Reader reader = new java.io.InputStreamReader(System.in, StandardCharsets.UTF_8.newDecoder()
                    .onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT))) {
                writeNewUtf8(Path.of(args[1]), readText(reader));
            }
        } else if (args.length == 3 && args[0].equals("write")) {
            writeNewUtf8(Path.of(args[1]), args[2]);
        } else {
            throw new IllegalArgumentException("Usage: read <path> | write <new-path> [text]; omitted text reads UTF-8 stdin");
        }
    }
}
