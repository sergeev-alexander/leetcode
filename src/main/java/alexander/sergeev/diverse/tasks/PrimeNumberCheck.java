package alexander.sergeev.diverse.tasks;

import java.math.BigInteger;

public class PrimeNumberCheck {

    public static void main(String[] args) {

        int num = 70;

        System.out.println(isPrime(num));
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2 || num == 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(num); i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }

    public static boolean isPrime1(int num) {
        if (num < 2) return false;
        return new BigInteger(String.valueOf(num)).isProbablePrime((int) Math.log(num));
    }

    public static boolean isPrime_SLOWER(int num) {
        if (num < 2) return false;
        for (int i = 3; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
