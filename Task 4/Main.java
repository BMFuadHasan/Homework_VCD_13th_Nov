import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                matrix[row][column] = input.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
            matrix[i][n - 1 - i] = 0;
        }

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (column > 0) {
                    System.out.print(" ");
                }
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }
}
