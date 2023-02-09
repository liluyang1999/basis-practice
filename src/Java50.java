import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.*;

public class Java50 {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 30; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        executor.shutdown();


        Set<String> set1 = new HashSet<>();
        set1.add(null);
        System.out.println(set1);
        set1.add("joker1");
        set1.add("joker2");
        set1.add(null);
        System.out.println(set1);
    }


}
