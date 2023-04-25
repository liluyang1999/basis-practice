package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Set<OpenOption> set = new HashSet<>();
        set.add(StandardOpenOption.READ);
        set.add(StandardOpenOption.WRITE);
        set.add(StandardOpenOption.CREATE);

        try (FileChannel channel = FileChannel.open(Paths.get("D://HelloWorld.txt"), set)) {
            StringBuffer text = new StringBuffer();
            int count;
            while ((count = channel.read(buffer)) > 0) {
                System.out.println(count);
                buffer.flip();
                while (buffer.position() < buffer.limit()) {
                    text.append((char)buffer.get());
                }
                buffer.clear();
            }
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder text = new StringBuilder("joker...");
        FileChannel channel = FileChannel.open(Paths.get("D://HelloWorld.txt"), set);
        for (int i = 0; i < text.length(); i++) {
            buffer.put((byte)text.charAt(i));
            if (buffer.position() == buffer.limit() || i == text.length() - 1) {
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }
        }
        channel.force(true);
        channel.close();
    }

}
