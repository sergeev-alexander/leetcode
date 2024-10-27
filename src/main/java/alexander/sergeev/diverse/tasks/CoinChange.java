package alexander.sergeev.diverse.tasks;

import java.util.LinkedList;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {
        int num = 78;
        int[] denomination = {1,5,10,25,50};
        System.out.println(getChange(denomination, num));
    }

    public static List<Integer> getChange(int[] denomination, int n) {
        List<Integer> list = new LinkedList<>();
        while (n > 0) {
            for (int i = denomination.length - 1; i >= 0; i--) {
                if (n - denomination[i] >= 0) {
                    n -= denomination[i];
                    list.add(denomination[i]);
                    break;
                }
            }
        }
        return list;
    }
}
}
