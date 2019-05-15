import animals.Chicken;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            Chicken c = new Chicken(name, age);
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}