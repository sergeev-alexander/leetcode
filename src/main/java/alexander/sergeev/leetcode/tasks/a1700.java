package alexander.sergeev.leetcode.tasks;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

// 1700. Number of Students Unable to Eat Lunch
public class a1700 {

    /*
    The school cafeteria offers circular and square sandwiches at lunch break,
    referred to by numbers 0 and 1 respectively. All students stand in a queue.
    Each student either prefers square or circular sandwiches.
    The number of sandwiches in the cafeteria is equal to the number of students.
    The sandwiches are placed in a stack. At each step:
    If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
    Otherwise, they will leave it and go to the queue's end.
    This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
    Return the number of students that are unable to eat.
     */
    public static void main(String[] args) {

        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};

        System.out.println(countStudents(students, sandwiches)); // 3
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int zeroStudent = 0;
        int oneStudent = 0;
        for (int s : students) {
            if (s == 0) zeroStudent++;
            else oneStudent++;
        }
        for (int s : sandwiches) {
            if (s == 0) {
                if (zeroStudent > 0) {
                    zeroStudent--;
                } else break;
            } else {
                if (oneStudent > 0) {
                    oneStudent--;
                } else break;
            }
        }
        return zeroStudent + oneStudent;
    }

    public static int countStudents_SLOW(int[] students, int[] sandwiches) {
        Queue<Integer> stud = new LinkedList<>();
        Queue<Integer> sand = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            stud.offer(students[i]);
            sand.offer(sandwiches[i]);
        }
        int failedCount = 0;
        while (!stud.isEmpty() && failedCount < stud.size()) {
            if (Objects.equals(stud.peek(), sand.peek())) {
                stud.poll();
                sand.poll();
                failedCount = 0;
            } else {
                stud.offer(stud.poll());
                failedCount++;
            }
        }
        return stud.size();
    }
}
