import java.io.*;

public class Practice67dd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            charCount += line.chars().filter(i -> Character.isLetterOrDigit(i)).count();
            wordCount += line.split("\\s+").length;
            lineCount++;
        }

        System.out.println(String.format("Lines: %d\nWords: %d\nCharacters: %d", lineCount, wordCount, charCount));
    }
}