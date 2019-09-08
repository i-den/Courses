import java.util.*;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<Double>> studentGrades = new TreeMap<>();

        int studentCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentCnt; i++) {
            String studentName = scanner.nextLine();
            studentGrades.putIfAbsent(studentName, new ArrayList<>());

            Collections.addAll(
                    studentGrades.get(studentName),
                    Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::valueOf).toArray(Double[]::new)
            );
        }

        for (String studentName : studentGrades.keySet()) {
            double gradeSum = 0D;
            List<Double> grades = studentGrades.get(studentName);
            for (Double grade : grades) {
                gradeSum += grade;
            }
            System.out.printf(
                    "%s is graduated with %s%s",
                    studentName,
                    Double.valueOf(gradeSum / grades.size()).toString(),
                    System.lineSeparator()
            );
        }
    }
}