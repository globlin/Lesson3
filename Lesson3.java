import java.util.Scanner;
import java.util.Random;

public class Lesson3 {
    public static void main(String[] args) {
        guessTask1();
//        guessTask2();
    }

    public static void guessTask1() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        char answer;

        guessGame();

        do {
            System.out.println("Повторить игру еще раз? y/n");
            if (!sc.hasNext("[y,n]")) {
                System.out.println("Не тот символ. Введите y/n:");
                sc.next();
            }
            answer = sc.next().charAt(0);

            if (answer == 'n') {
                exit = true;
            } else if (answer == 'y') {
                guessGame();
            }
        } while (!exit);
    }

    private static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generate = random.nextInt(6);

        boolean win = false;
        int currentNumber;

        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите число от 0 до 5: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Не то число. Введите число от 0 до 5:");
                scanner.next();
            }

            currentNumber = scanner.nextInt();

            if (currentNumber == generate) {
                win = true;
                break;
            } else if (currentNumber > generate) {
                System.out.printf("%d > загаданное\n\n", currentNumber);
            } else {
                System.out.printf("%d < загаданное\n\n", currentNumber);
            }
        }

        if (win) System.out.println("Победа");
        else System.out.printf("GAME OVER. Ответ: %d\n", generate);
    }
}
