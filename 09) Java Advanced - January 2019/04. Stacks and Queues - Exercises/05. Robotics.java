import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {

    private static final String STR_TO_END_INPUT = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RobotManager robotManager = new RobotManager();

        robotManager.assembleRobotsFromInput(scanner.nextLine());
        robotManager.setInputTime(scanner.nextLine());

        String currDetail;
        while (!STR_TO_END_INPUT.equals((currDetail = scanner.nextLine()))) {
            robotManager.getDetailsToProcess().addLast(currDetail);
        }

        robotManager.processAllDetails();
    }
}

class RobotManager {
    private ArrayDeque<Robot> robots;
    private ArrayDeque<String> detailsToProcess;
    private TimeManager timeManager;

    RobotManager() {
        this.robots = new ArrayDeque<>();
        this.detailsToProcess = new ArrayDeque<>();
        this.timeManager = new TimeManager();
    }

    void setInputTime(String inputTime) {
        this.timeManager.getTimeFromInput(inputTime);
    }

    void processAllDetails() {
        while (!this.detailsToProcess.isEmpty()) {
            this.timeManager.increaseTimeByOneSecond();
            Robot currFreeRobot = this.findFirstFreeRobot();
            if (currFreeRobot == null) {
                this.passOneSecondForEachRobot();
                this.detailsToProcess.addLast(this.detailsToProcess.removeFirst());
                continue;
            }
            currFreeRobot.setProcessingDetail(this.detailsToProcess.removeFirst());
            System.out.printf(
                    "%s - %s [%02d:%02d:%02d]%s",
                    currFreeRobot.getName(),
                    currFreeRobot.getProcessingDetail(),
                    this.timeManager.getHours(),
                    this.timeManager.getMinutes(),
                    this.timeManager.getSeconds(),
                    System.lineSeparator()
            );
            this.passOneSecondForEachRobot();
        }
    }

    void assembleRobotsFromInput(String robotsInput) {
        String[] robotsAsTokens = robotsInput.split(";");
        for (String robotAsToken : robotsAsTokens) {
            String[] robotNameAndProcessTime = robotAsToken.split("-");
            this.robots.addLast(
                    new Robot(
                            robotNameAndProcessTime[0],
                            Integer.parseInt(robotNameAndProcessTime[1])
                    ));
        }
    }

    private Robot findFirstFreeRobot() {
        for (Robot robot : this.robots) {
            if (robot.isFreeForProcessing()) {
                return robot;
            }
        }
        return null;
    }

    private void passOneSecondForEachRobot() {
        for (Robot robot : this.robots) {
            robot.processOneSecond();
        }
    }

    ArrayDeque<String> getDetailsToProcess() {
        return this.detailsToProcess;
    }
}

class Robot {
    private String name;
    private int processTime;
    private int processingTimeLeft;
    private String processingDetail;

    Robot(String name, int processTime) {
        this.setName(name);
        this.setProcessTime(processTime);
    }

    void processOneSecond() {
        this.processingTimeLeft--;
    }

    boolean isFreeForProcessing() {
        return this.processingTimeLeft <= 0;
    }

    void setProcessingDetail(String processingDetail) {
        this.processingDetail = processingDetail;
        this.processingTimeLeft = this.processTime;
    }

    String getProcessingDetail() {
        return this.processingDetail;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getProcessTime() {
        return processTime;
    }

    private void setProcessTime(int processTime) {
        this.processTime = processTime;
        this.processingTimeLeft = 0;
    }
}

class TimeManager {
    private long totalSeconds;

    void getTimeFromInput(String time) {
        String[] timeTokens = time.split(":");
        int hours = Integer.parseInt(timeTokens[0]);
        int minutes = Integer.parseInt(timeTokens[1]);
        int seconds = Integer.parseInt(timeTokens[2]);

        this.totalSeconds += hours * 60 * 60;
        this.totalSeconds += minutes * 60 ;
        this.totalSeconds += seconds;
    }

    void increaseTimeByOneSecond() {
        this.totalSeconds++;
    }

    long getSeconds() {
        return totalSeconds % 60;
    }

    long getMinutes() {
        return (totalSeconds / 60) % 60;
    }

    long getHours() {
        return totalSeconds / (60 * 60);
    }
}