import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java47 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent = reader.readLine();
        String[] names = inputContent.split(" ");
        LikeTool likeTool = new LikeTool();
        for (String index : names) {
            likeTool.like(index);
        }
        likeTool.getLikeUsers();
    }

    static class LikeTool {
        public static Set<String> users;
        static {
            users = new HashSet<>();
        }
        public void like (String name) {
            if (users.contains(name)) {
                users.remove(name);
            } else {
                users.add(name);
            }
        }
        public void getLikeUsers() {
            System.out.println(Arrays.toString(users.toArray()));
        }
    }

}
