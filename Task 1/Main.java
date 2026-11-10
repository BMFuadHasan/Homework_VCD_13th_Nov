import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static String formatNumber(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] radii = new double[n];

        for (int i = 0; i < n; i++) {
            radii[i] = input.nextDouble();
        }

        double largestRadius = radii[0];
        int count = 0;
        for (double radius : radii) {
            if (radius > largestRadius) {
                largestRadius = radius;
                count = 1;
            } else if (radius == largestRadius) {
                count++;
            }
        }

        System.out.println(formatNumber(largestRadius) + " - " + count);
    }
}
