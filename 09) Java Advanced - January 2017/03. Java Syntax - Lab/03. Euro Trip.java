import java.math.BigDecimal;
import java.util.Scanner;

public class A_Read_Input {

    public static void main(String[] args) {

        final BigDecimal bgnToDM = new BigDecimal("4210500000000");
        final double oneKgWurstToBGN = 1.2;

        Scanner userInput = new Scanner(System.in);
        double wurstQuantity = userInput.nextDouble();

        System.out.printf("%.2f marks", bgnToDM.multiply(new BigDecimal(oneKgWurstToBGN * wurstQuantity)));
    }
}