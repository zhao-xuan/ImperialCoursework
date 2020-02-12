public class Practice98e3 {
    public static void main(String[] args) {
        int temp = Integer.parseInt(args[0]);
        System.out.print(temp + " ");
        while (temp != 1) {
            temp = next(temp);
            System.out.print(temp + " ");
        }
    }

    public static int next(int num) {
        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = 3 * num + 1;
        }

        return num;
    }

}