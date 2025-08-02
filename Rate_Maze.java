package Java_with_dsa.BackTracking;

public class Rate_Maze {

   public static int n = 4;

    public static boolean isSafe(int maze[][], int row, int col, int[][] visited){
        return row>=0 && row<n && col>=0 && col<n && maze[row][col] == 1 && visited[row][col] == 0;
    }
    public static int rateMaze(int[][] maze, int row, int col, int [][] visited){
        // base case
        if (row==n-1 && col==n-1){
            visited[row][col] = 1;
            printSolution(visited);
            visited[row][col]=0;
            return 1;
        }
        // recursion
        if (!isSafe(maze,row,col,visited)){
            return 0;
        }

        visited[row][col] = 1;
        int totalWays = 0;
        totalWays +=rateMaze(maze,row,col+1,visited);
        totalWays +=rateMaze(maze,row,col-1,visited);
        totalWays +=rateMaze(maze,row+1,col,visited);
        totalWays +=rateMaze(maze,row-1,col,visited);
        visited[row][col] = 0; // backtrack
        return totalWays;
    }
    public static void printSolution(int maze[][]){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maze[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        int[][] visited = new int[n][n];
        System.out.println("Total number of ways: "+ rateMaze(maze,0,0,visited));
    }
}


// output
// 1 0 0 0 
// 1 1 0 0 
// 0 1 0 0 
// 0 1 1 1 