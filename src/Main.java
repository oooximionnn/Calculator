import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner input = new Scanner(System.in);
        System.out.println(Calc.calc(input.nextLine()));
    }
}