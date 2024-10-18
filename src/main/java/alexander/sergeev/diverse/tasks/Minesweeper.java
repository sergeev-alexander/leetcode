package alexander.sergeev.diverse.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {

        /*
                3 2 - field size (height, width)
                3   - mines count
                1 1 - mines coordinates (from 1)
                2 2 - mines coordinates (from 1)
                3 2 - mines coordinates (from 1)
         */

        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("size", sc.nextLine().trim());
        map.put("minesCount", sc.nextLine().trim());
        if (!map.get("minesCount").equals("0")) {
            for (int i = 1; i <= Integer.parseInt(map.get("minesCount")); i++) {
                map.put(String.valueOf(i), sc.nextLine().trim());
            }
        }
        int minesCount = Integer.parseInt(map.get("minesCount"));
        int[][] arr = new int[Integer.parseInt(map.get("size").split(" ")[0]) + 2]
                [Integer.parseInt(map.get("size").split(" ")[1]) + 2];
        for (int i = 1; i <= minesCount; i++) {
            int row = Integer.parseInt(map.get(String.valueOf(i)).split(" ")[0]);
            int column = Integer.parseInt(map.get(String.valueOf(i)).split(" ")[1]);
            arr[row][column] = 9;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= 9) {
                    arr[i - 1][j - 1]++;
                    arr[i - 1][j]++;
                    arr[i - 1][j + 1]++;
                    arr[i][j - 1]++;
                    arr[i][j + 1]++;
                    arr[i + 1][j - 1]++;
                    arr[i + 1][j]++;
                    arr[i + 1][j + 1]++;
                }
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] >= 9 ? "m" : arr[i][j]);
                System.out.print(j == arr[i].length - 2 ? "" : " ");
            }
            System.out.println();
        }
    }
}

