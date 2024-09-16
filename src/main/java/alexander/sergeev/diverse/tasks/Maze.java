package alexander.sergeev.diverse.tasks;

import java.lang.*;
import java.util.*;

class Maze {

    static int ROW;
    static int COLUMN;

    // Stores the moves of the directions of adjacent cells
    static int[] rowDirections = {-1, 0, 0, 1};
    static int[] columnDirections = {0, -1, 1, 0};

    static Point start;
    static Point finish;

    // Keeps track of whether finish is reached or not
    static boolean isFinishReached = false;

    // Driver Code
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 0, 0, 0}};

        ROW = maze.length;
        COLUMN = maze[0].length;

        start = new Point(0, 0);
        finish = new Point(3, 3);

        explore(maze, start, finish);
    }

    // Stores the coordinates of the matrix cell
    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point(" + x + ", " + y + ")";
        }
    }

    // Stores coordinates of a cell and its distance
    static class Node {

        Point point;
        int distance;

        Node(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node(" + point + ", distance : " + distance + ")";
        }
    }

    // Check if the given cell is valid or not
    static boolean isValid(int row, int column) {
        return (row >= 0) && (column >= 0) && (row < ROW) && (column < COLUMN);
    }

    // Function to find the shortest path from the source to destination in the given  matrix
    static void explore(int[][] matrix, Point start, Point finish) {

        // Stores the distances for each cell from the start cell
        int[][] distances = new int[ROW][COLUMN];
        // Fill the distances arrays with -1
        for (int[] dd : distances)
            Arrays.fill(dd, -1);

        // Distance of source cell is 0
        distances[start.x][start.y] = 0;

        // Initialize a visited array
        boolean[][] visited = new boolean[ROW][COLUMN];

        // Mark source cell as visited
        visited[start.x][start.y] = true;

        // Create a queue for BFS
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // Distance of source cell is 0
        Node s = new Node(start, 0);

        // Enqueue source cell
        queue.addLast(s);

        // Iterate until queue is not empty
        while (!queue.isEmpty()) {

            // Deque front of the queue
            Node current = queue.removeFirst();
            Point point = current.point;

            // If the finish cell is reached, then find the path
            if (point.x == finish.x && point.y == finish.y) {
                restorePath(distances, current);
            }

            // Explore all adjacent directions
            for (int i = 0; i < 4; i++) {
                int row = point.x + rowDirections[i];
                int column = point.y + columnDirections[i];

                // If the current cell is valid cell and can be traversed
                if (isValid(row, column) && (matrix[row][column] == 0) && !visited[row][column]) {

                    // Mark the adjacent cells as visited
                    visited[row][column] = true;

                    // Enqueue the adjacent cells
                    Node adjacentCell = new Node(new Point(row, column), current.distance + 1);
                    queue.addLast(adjacentCell);

                    // Update the distances of the adjacent cells
                    distances[row][column] = current.distance + 1;
                }
            }
        }

        // If the destination is not reachable
        if (!isFinishReached) {
            System.out.println(-1);
        }
    }

    private static void restorePath(int[][] distances, Node current) {
        int x = current.point.x;
        int y = current.point.y;
        int distance = current.distance;
        Point point = current.point;

        // Assign the distances of destination to the distances matrix
        distances[point.x][point.y] = distance;

        // Stores the smallest path
        String path = "";

        // Iterate until start is reached
        while (x != start.x || y != start.y) {

            // Append D
            if (x > 0 && distances[x - 1][y] == distance - 1) {
                path += 'D';
                x--;
            }

            // Append U
            if (x < ROW - 1 && distances[x + 1][y] == distance - 1) {
                path += 'U';
                x++;
            }

            // Append R
            if (y > 0 && distances[x][y - 1] == distance - 1) {
                path += 'R';
                y--;
            }

            // Append L
            if (y < COLUMN - 1 && distances[x][y + 1] == distance - 1) {
                path += 'L';
                y++;
            }
            distance--;
        }

        // Print reverse the backtracked path
        for (int i = path.length() - 1; i >= 0; --i)
            System.out.print(path.charAt(i));

        isFinishReached = true;
    }
}
