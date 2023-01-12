import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Java38 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent = bufferedReader.readLine();
        Set<Character> set = new HashSet<>();
        for (char index : inputContent.toCharArray()) {
            set.add(index);
        }
        StringBuilder builder = new StringBuilder();
        for (char index : set) {
            builder.append(index);
        }
        System.out.println(builder);
    }

}
