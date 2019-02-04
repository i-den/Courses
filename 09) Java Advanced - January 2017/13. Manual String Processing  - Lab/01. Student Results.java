import java.util.Arrays;
import java.util.Scanner;

public class StudentResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rawStudentTkns = scanner.nextLine()
                .split(" - ");

        String studentName = rawStudentTkns[0].trim();

        Double[] studentScoreTkns = Arrays.stream(rawStudentTkns[1].split(", "))
                .map(Double::valueOf)
                .toArray(Double[]::new);

        Student currStudent = new Student(
                studentName,
                studentScoreTkns[0],
                studentScoreTkns[1],
                studentScoreTkns[2]
        );
        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");
        System.out.println(currStudent.getInfo());
    }
}

class Student {

    private String name;

    private Double jAdvScore;

    private Double jOOPScore;

    private Double advOOPScore;

    Student(String name, Double jAdvScore, Double jOOPScore, Double advOOPScore) {
        this.setName(name);
        this.setjAdvScore(jAdvScore);
        this.setjOOPScore(jOOPScore);
        this.setAdvOOPScore(advOOPScore);
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    Double getjAdvScore() {
        return jAdvScore;
    }

    private void setjAdvScore(Double jAdvScore) {
        this.jAdvScore = jAdvScore;
    }

    Double getjOOPScore() {
        return jOOPScore;
    }

    private void setjOOPScore(Double jOOPScore) {
        this.jOOPScore = jOOPScore;
    }

    Double getAdvOOPScore() {
        return advOOPScore;
    }

    private void setAdvOOPScore(Double advOOPScore) {
        this.advOOPScore = advOOPScore;
    }

    Double getAvgScore() {
        return ((this.jAdvScore + this.jOOPScore + this.advOOPScore) / 3);
    }

    String getInfo() {
        return String.format(
                "%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                this.getName(),
                this.getjAdvScore(),
                this.getjOOPScore(),
                this.getAdvOOPScore(),
                this.getAvgScore()
        );
    }
}