package grammar.nowcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Java37 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String content = bufferedReader.readLine();
        int score = Integer.parseInt(content);
        try {
            if (0 <= score && score <= 100) {
                System.out.println(score);
            } else {
                throw new ScoreException("分数不合法");
            }
        } catch (ScoreException e) {
            System.out.println(e.getMessage());
        }
    }

    static class ScoreException extends Exception {

        public ScoreException(String msg) {
            super(msg);
        }

    }

}
