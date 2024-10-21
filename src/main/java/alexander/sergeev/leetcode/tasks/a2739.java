package alexander.sergeev.leetcode.tasks;

// 2739. Total Distance Traveled
public class a2739 {

    /*
    A truck has two fuel tanks. You are given two integers, mainTank representing the fuel
    present in the main tank in liters and additionalTank representing the fuel present in the additional tank in liters.
    The truck has a mileage of 10 km per liter. Whenever 5 liters of fuel get used up in the main tank,
    if the additional tank has at least 1 liters of fuel, 1 liters of fuel will be transferred from the
    additional tank to the main tank.
    Return the maximum distance which can be traveled.
    Note: Injection from the additional tank is not continuous. It happens suddenly and immediately for every 5 liters consumed.
     */

    public static void main(String[] args) {
        int a = 9;
        int b = 1;
        System.out.println(distanceTraveled(a, b));
    }

    // BEATS 100%
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        while (mainTank >= 5 && additionalTank > 0) {
            distance += 50;
            mainTank -= 4;
            additionalTank--;
        }
        while (mainTank > 0) {
            distance += 10;
            mainTank--;
        }
        return distance;
    }

    // BEATS 100%
    public static int distanceTraveled1(int mainTank, int additionalTank) {
        int distance = 0;
        int count = 0;
        while (mainTank > 0) {
            distance += 10;
            mainTank--;
            count++;
            if (count == 5 && additionalTank > 0) {
                count = 0;
                additionalTank--;
                mainTank++;
            }
        }
        return distance;
    }
}