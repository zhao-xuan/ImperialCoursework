import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice4c70 {
    public static void main(String[] args) {
        Random generator = new Random();
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            int x = generator.nextInt(48) + 1;
            while (numList.contains(x)) {
                x = generator.nextInt(48) + 1;
            }
            numList.add(x);
            if (i != 7)
                System.out.println("Number " + i + ": " + x);
            else
                System.out.println("Bonus Number" + ": " + x);
        }
    }
}