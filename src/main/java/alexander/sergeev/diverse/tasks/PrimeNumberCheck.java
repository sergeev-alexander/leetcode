package alexander.sergeev.diverse.tasks;

import java.math.BigInteger;

public class PrimeNumberCheck {

    public static void main(String[] args) {

        int num = 70;

        System.out.println(isPrime1(num));
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 3; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime1(int num) {
        if (num < 2) return false;
        return new BigInteger(String.valueOf(num)).isProbablePrime((int) Math.log(num));
    }
}
