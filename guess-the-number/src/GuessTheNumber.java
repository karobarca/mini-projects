import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int runAgain = 1;
        do {
            int count = 0;
            int randomNumber = random.nextInt(10) + 1;
            int playerGuess;
            do {
                System.out.println("Zgadnij jaką liczbę wylosowałem, od 1 do 10.");
                playerGuess = scanner.nextInt();
                if (playerGuess > randomNumber) {
                    System.out.println("Wylosowana liczba jest mniejsza, spróbuj ponownie.");
                } else if (playerGuess < randomNumber) {
                    System.out.println("Wylosowana liczba jest większa, spróbuj ponownie.");
                }
                count++;
            } while (playerGuess != randomNumber);

            switch (count) {
                case 1:
                    System.out.println("Brawo zgadłeś za pierwszym razem!!!");
                    break;
                case 2:
                    System.out.println("Nieźle, zgadłeś za drugim razem!");
                    break;
                case 3:
                    System.out.println("Udało się, do 3x sztuka!");
                    break;
                default:
                    System.out.println("Dobrze, że dziś. W końcu zgadłeś, za " + count + " razem.");
            }
            System.out.println("Jeśli chcesz zagrać ponownie, wpisz 1");
            System.out.println("Jeśli chcesz zamknąć program, wpisz 2");
            runAgain = scanner.nextInt();
        }while (runAgain == 1);
    }
}
