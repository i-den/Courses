import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, ArrayList<Double>> studentGrades = new TreeMap<>();

        int studentCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentCnt; i++) {
            String[] studentTokens = scanner.nextLine().split("\\s+");
            studentGrades.putIfAbsent(studentTokens[0], new ArrayList<>());
            studentGrades.get(studentTokens[0]).add(Double.parseDouble(studentTokens[1]));
        }

        for (String studentName : studentGrades.keySet()) {
            ArrayList<Double> allStudentGrades = studentGrades.get(studentName);

            System.out.print(studentName + " -> ");
            double avgGrade = 0D;
            for (Double studentGrade : allStudentGrades) {
                avgGrade += studentGrade;
                System.out.printf("%.2f ", studentGrade);
            }
            System.out.printf("(avg: %.2f)\n", avgGrade / allStudentGrades.size());
        }
    }
}