import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerAmt = scanner.nextInt();
        List<Player> playerList = new ArrayList<Player>();

        for (int i = 0; i < playerAmt; i++) {
            String currName = scanner.next();
            int iniScore = scanner.nextInt();

            playerList.add(new Player(currName, iniScore));
        }

        playerList.sort(Comparator.comparing(Player::getScore).reversed());

        Player winner = playerList.get(0);

        System.out.printf("The winner is %s - %d points", winner.getName(), winner.getScore());
    }
}

class Player {

    private String name;

    private long score;

    public Player(String name, int scoreIni) {
        this.setName(name);
        this.setScore(scoreIni);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public long getScore() {
        return score;
    }

    private void setScore(long score) {
        char[] nameChars = this.getName()
                .toCharArray();

        for (char currNameChar : nameChars) {
            int charAsciNum = (int) currNameChar;

            if (charAsciNum %2 == 0) {
                score += charAsciNum;
            } else {
                score -= charAsciNum;
            }
        }

        this.score = score;
    }
}