import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static String formatNumber(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] residents = new int[n];

        for (int i = 0; i < n; i++) {
            residents[i] = input.nextInt();
        }

        int total = 0;
        int leftTotal = 0;
        int rightTotal = 0;
        int leftHouses = 0;
        int rightHouses = 0;

        for (int i = 0; i < n; i++) {
            total += residents[i];
            if ((i + 1) % 2 == 1) {
                leftTotal += residents[i];
                leftHouses++;
            } else {
                rightTotal += residents[i];
                rightHouses++;
            }
        }

        System.out.println("Total residents: " + total);
        System.out.println("Residents on the left: " + leftTotal);
        System.out.println("Residents on the right: " + rightTotal);
        System.out.println("Average per house on the left: "
                + (leftHouses == 0 ? "N/A" : formatNumber((double) leftTotal / leftHouses)));
        System.out.println("Average per house on the right: "
                + (rightHouses == 0 ? "N/A" : formatNumber((double) rightTotal / rightHouses)));
    }
}
