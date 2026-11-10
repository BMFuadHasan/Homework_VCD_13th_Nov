import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String formatNumber(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
    }

    private static String formatStudentNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return "None";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) {
                result.append(' ');
            }
            result.append(numbers.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int subjects = input.nextInt();
        int students = input.nextInt();
        int[][] grades = new int[students][subjects];

        for (int student = 0; student < students; student++) {
            for (int subject = 0; subject < subjects; subject++) {
                grades[student][subject] = input.nextInt();
            }
        }

        double[] averages = new double[students];
        int groupTotal = 0;
        int highestTotal = Integer.MIN_VALUE;
        List<Integer> highestPerformers = new ArrayList<>();
        List<Integer> studentsBelowFive = new ArrayList<>();

        for (int student = 0; student < students; student++) {
            int studentTotal = 0;
            boolean hasGradeBelowFive = false;
            for (int grade : grades[student]) {
                studentTotal += grade;
                if (grade < 5) {
                    hasGradeBelowFive = true;
                }
            }

            groupTotal += studentTotal;
            averages[student] = (double) studentTotal / subjects;

            if (studentTotal > highestTotal) {
                highestTotal = studentTotal;
                highestPerformers.clear();
                highestPerformers.add(student + 1);
            } else if (studentTotal == highestTotal) {
                highestPerformers.add(student + 1);
            }

            if (hasGradeBelowFive) {
                studentsBelowFive.add(student + 1);
            }
        }

        System.out.println("Student averages:");
        for (double average : averages) {
            System.out.println(formatNumber(average));
        }

        System.out.println();
        System.out.println("Group average:");
        System.out.println(formatNumber((double) groupTotal / (subjects * students)));
        System.out.println();
        System.out.println("Highest-performing student:");
        System.out.println(formatStudentNumbers(highestPerformers));
        System.out.println();
        System.out.println("Students with at least one grade below 5:");
        System.out.println(formatStudentNumbers(studentsBelowFive));
    }
}
