import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practicef7c3 {
    public static void main(String[] args) throws IOException {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        String[] words = line.split("\\s+");

        for (String word : words) {
            boolean isFirstCharCapital = Character.isUpperCase(word.charAt(0));
            char lastChar = word.charAt(word.length() - 1);
            String tailSymbol = Character.isLetterOrDigit(lastChar) ? "" : Character.toString(lastChar);
            String normalizedWord = word.toLowerCase().substring(0, word.length() - tailSymbol.length());
            char firstChar = normalizedWord.charAt(0);

            if (vowels.contains(firstChar)) {
                normalizedWord += "way";
            } else {
                normalizedWord = normalizedWord.substring(1) + firstChar + "ay";
            }

            normalizedWord += tailSymbol;
            if (isFirstCharCapital) {
                normalizedWord = Character.toUpperCase(normalizedWord.charAt(0)) + normalizedWord.substring(1);
            }
            sb.append(normalizedWord + " ");
        }

        System.out.println(sb.toString());
    }
}