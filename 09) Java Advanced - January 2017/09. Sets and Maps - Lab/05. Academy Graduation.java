import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Double> students = new TreeMap<>();

        int studentsCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentsCnt; i++) {
            String currStudentName = scanner.nextLine();
            String[] currScores = scanner.nextLine().split("\\s+");

            double avgScore = 0;
            for (String currScore : currScores) {
                avgScore += Double.parseDouble(currScore);
            }

            avgScore /= currScores.length;

            students.put(currStudentName, avgScore);
        }

        for (String currStudent : students.keySet()) {
            System.out.println(currStudent + " is graduated with " + students.get(currStudent));
        }
    }
}