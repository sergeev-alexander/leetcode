package alexander.sergeev.maze;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Maze {

    public static void main(String[] args) {

        String maze = ".W.\n" +
                ".W.\n" +
                "...";

        System.out.println(pathFinder(maze));

    }

    public static int pathFinder(String maze) {
        List<String> list = Arrays.stream(maze.split("\\n"))
                .toList();
        int[][] mazeArr = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            int[] arr = new int[list.get(i).length()];
            for (int j = 0; j < list.get(i).length(); j++) {
                arr[j] = list.get(i).charAt(j) == '.' ? 0 : 1;
            }
            mazeArr[i] = arr;
        }

        final int[] columnDirections = {0, -1, 1, 0};
        final int[] rowDirections = {-1, 0, 0, 1};

        final int ROW = mazeArr.length;
        final int COLUMN = mazeArr[0].length;

        final Point start = new Point(0, 0);
        final Point finish = new Point(ROW - 1, COLUMN - 1);

        int[][] distances = new int[ROW][COLUMN];

        for (int[] dd : distances)
            Arrays.fill(dd, -1);

        distances[start.x][start.y] = 0;

        boolean[][] visited = new boolean[ROW][COLUMN];

        visited[start.x][start.y] = true;

        ArrayDeque<Node> queue = new ArrayDeque<>();

        Node startNode = new Node(start, 0);

        queue.addLast(startNode);

        while (!queue.isEmpty()) {

            Node current = queue.removeFirst();
            Point point = current.point;

            if (point.x == finish.x && point.y == finish.y) {
                return distances[point.x][point.y];
            }

            for (int i = 0; i < 4; i++) {
                int row = point.x + rowDirections[i];
                int column = point.y + columnDirections[i];

                if (isValid(row, ROW, column, COLUMN) && (mazeArr[row][column] == 0) && !visited[row][column]) {
                    visited[row][column] = true;
                    Node adjacentCell = new Node(new Point(row, column), current.distance + 1);
                    queue.addLast(adjacentCell);
                    distances[row][column] = current.distance + 1;
                }
            }
        }
        return -1;
    }


    private static boolean isValid(int row, int ROW, int column, int COLUMN) {
        return (row >= 0) && (column >= 0) && (row < ROW) && (column < COLUMN);
    }

    static class Point {

        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {

        final Point point;
        final int distance;

        Node(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}