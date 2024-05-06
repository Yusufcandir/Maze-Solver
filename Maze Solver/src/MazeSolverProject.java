
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class MazeSolverProject {

    static ArrayList<Position> visited = new ArrayList<>();

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position position = (Position) obj;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int grid = 5;
        int[][] maze = getMaze(grid);
        Stack<int[]> path = new Stack<>();

        maze[1][1] = 2;
        MazeUtility.plotMaze(maze);
        int currentX = 1;
        int currentY = 1;
        int[] currentLocation = {currentX, currentY};

        path.push(currentLocation);

        while (!path.isEmpty() && (currentX != 2 * grid - 1 || currentY != 2 * grid - 1)) {
            if (canMoveDown(maze, currentX, currentY) && !isVisited(new Position(currentX + 1, currentY))) {
                maze[currentX][currentY] = 0;
                maze[currentX + 1][currentY] = 2;
                visited.add(new Position(currentX, currentY));
                currentX++;

            } else if (canMoveUp(maze, currentX, currentY) && !isVisited(new Position(currentX - 1, currentY))) {
                maze[currentX][currentY] = 0;
                maze[currentX - 1][currentY] = 2;
                visited.add(new Position(currentX, currentY));
                currentX--;

            } else if (canMoveRight(maze, currentX, currentY) && !isVisited(new Position(currentX, currentY + 1))) {
                maze[currentX][currentY] = 0;
                maze[currentX][currentY + 1] = 2;
                visited.add(new Position(currentX, currentY));
                currentY++;

            } else if (canMoveLeft(maze, currentX, currentY) && !isVisited(new Position(currentX, currentY - 1))) {
                maze[currentX][currentY] = 0;
                maze[currentX][currentY - 1] = 2;
                visited.add(new Position(currentX, currentY));
                currentY--;
            } else {
                // Backtrack
                path.pop();
                while (!path.isEmpty() && howManyUnvisitedWay(maze, currentX, currentY) == 0) {
                    visited.add(new Position(currentX, currentY));
                    maze[currentX][currentY] = 0; // Mark the current position as 0

                    int[] previousPosition = path.pop();
                    currentX = previousPosition[0];
                    currentY = previousPosition[1];

                    maze[currentX][currentY] = 2; // Mark the previous position as the current location
                    MazeUtility.plotMaze(maze);
                }
            }
            int[] nextPosition = new int[]{currentX, currentY};
            path.push(nextPosition);
            MazeUtility.plotMaze(maze);


        }
    }

    public static boolean isVisited(Position position) {
        return visited.contains(position);
    }


    public static int howManyUnvisitedWay(int[][] maze, int currentX, int currentY) {
        int count = 0;
        if (canMoveDown(maze, currentX, currentY) && !isVisited(new Position(currentX + 1, currentY))) {
            count++;
        }
        if (canMoveUp(maze, currentX, currentY) && !isVisited(new Position(currentX - 1, currentY))) {
            count++;
        }
        if (canMoveLeft(maze, currentX, currentY) && !isVisited(new Position(currentX, currentY - 1))) {
            count++;
        }
        if (canMoveRight(maze, currentX, currentY) && !isVisited(new Position(currentX, currentY + 1))) {
            count++;
        }
        return count;
    }

    public static boolean canMoveUp(int[][] maze, int currentX, int currentY) {
        return currentX - 1 >= 0 && maze[currentX - 1][currentY] == 0;
    }

    public static boolean canMoveDown(int[][] maze, int currentX, int currentY) {
        return currentX + 1 < maze.length && maze[currentX + 1][currentY] == 0;
    }

    public static boolean canMoveLeft(int[][] maze, int currentX, int currentY) {
        return currentY - 1 >= 0 && maze[currentX][currentY - 1] == 0;
    }

    public static boolean canMoveRight(int[][] maze, int currentX, int currentY) {
        return currentY + 1 < maze[0].length && maze[currentX][currentY + 1] == 0;
    }

    public static int[][] getMaze(int grid) {
        MazeGenerator maze = new MazeGenerator(grid);
        String str = maze.toString();

        return MazeUtility.Convert2D(str);
    }
}
