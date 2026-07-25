import java.util.ArrayList;
import java.util.Scanner;

public class Lah {
    public static int showMenu(Scanner scan) throws InterruptedException {

        int choice;

        while (true) {
            System.out.println("\n== Calculator Menu ==");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. View History");
        System.out.println("6. Exit");
        Thread.sleep(500);

        System.out.print("\nEnter the number of the function you will use: ");

        if (!scan.hasNextInt()) {
            System.out.println("\nInvalid input: Enter a number from the menu");
            scan.next();
            Thread.sleep(500);
            continue;
        }

        choice = scan.nextInt();

        if (choice >= 1 && choice <= 6) {
                return choice;
            }

            System.out.println("\nPlease choose a number from 1 to 6");
            Thread.sleep(500);
        }
    }

    public static double[] inputNum(Scanner scan) {
        double[] numbers = new double[2];

        System.out.print("Enter your first number: ");
        numbers[0] = scan.nextDouble();

        System.out.print("Enter your second number: ");
        numbers[1] = scan.nextDouble();

        return numbers;                    
    }

    public static void showHistory(ArrayList<String> history) {
        if (history.isEmpty()) {
            System.out.println("\nNo calculations yet");
        } else {
            System.out.println("\n=== HISTORY ===");
            for(String calculations : history) {
                System.out.println(calculations);
            }
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        double[] numbers;
        double num1;
        double num2;
        int chosen = 0;
        double result;

        ArrayList<String> history = new ArrayList<>();

        do {
            chosen = showMenu(scan);
            
            switch (chosen) {
                case 1:
                    numbers = inputNum(scan);
                    num1 = numbers[0];
                    num2 = numbers[1];

                    result = add(num1, num2);

                    System.out.printf("\nAnswer: %.1f",result);
                    history.add(num1 + " + " + num2 + " = " + result);
                    break;

                case 2:
                    numbers = inputNum(scan);
                    num1 = numbers[0];
                    num2 = numbers[1];

                    result = subtract(num1, num2);

                    System.out.printf("\nAnswer: %.1f",result);
                    history.add(num1 + " - " + num2 + " = " + result);
                    break;

                case 3:
                    numbers = inputNum(scan);
                    num1 = numbers[0];
                    num2 = numbers[1];

                    result = multiply(num1, num2);

                    System.out.printf("\nAnswer: %.1f",result);
                    history.add(num1 + " * " + num2 + " = " + result);
                    break;

                case 4:
                    numbers = inputNum(scan);
                    num1 = numbers[0];
                    num2 = numbers[1];

                    if (num2 != 0) {
                        result = divide(num1, num2);
                        System.out.printf("\nAnswer: %.1f",result);
                        history.add(num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("\nerror: number cannot be divided by 0");
                    }

                    break;

                case 5:
                    showHistory(history);
                    break;

                case 6:
                    System.out.println("\nExiting...");
                    break;

                default:
                    System.out.println("\nInvalid Operation!");
                    break;
            }
        } while (chosen != 6);

        scan.close();
    }
}
