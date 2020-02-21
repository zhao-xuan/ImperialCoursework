import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Practice014e {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        List<Integer> numList = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        Random generator = new Random();
        int x;
        while (numSet.size() < n) {
            x = generator.nextInt(n);
            numList.add(x);
            numSet.add(x);
        }

        for (Integer integer : numList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.print("I had to generate " + numList.size() + " random numbers between 0 and " + n
                + " to have produced all such numbers at least once.");
    }
}