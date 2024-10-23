package alexander.sergeev.leetcode.tasks;

// 2651. Calculate Delayed Arrival Time
public class a2651 {

    /*'
    You are given a positive integer arrivalTime denoting the arrival time of a train in hours,
    and another positive integer delayedTime denoting the amount of delay in hours.
    Return the time when the train will arrive at the station.
    Note that the time in this problem is in 24-hours format.
     */

    public static void main(String[] args) {
        int a = 15;
        int b = 5;
        System.out.println(findDelayedArrivalTime(a,b));
    }

    // BEATS 100%
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}