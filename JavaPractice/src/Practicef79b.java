public class Practicef79b {
    public static void main(String[] args) {
        for (long i = 0; i < Integer.parseInt(args[0]); i++) {
            String palin = Long.toString(i * i * i);
            if (isPalin(palin)) {
                System.out.println(i + " cubed is " + palin);
            }
        }
    }

    public static Boolean isPalin(String num) {
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}