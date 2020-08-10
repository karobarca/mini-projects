import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Witaj w grze. Podaj rozmiar planszy");

        int boardDimension = scanner.nextInt();
        char currentSymbol = 'X';
//        PRÓBNA TABLICA
//        char[][] board = {{'O','X','X'},
//                         {'O','X', ' '},
//                         {' ', 'O', 'O'}};
        char[][] board = new char[boardDimension][boardDimension];
        boolean continueGame = true;
        int moveCounter = 0;
        while(continueGame & moveCounter <= boardDimension*boardDimension) {
            printBoard(board);
            boolean correctMove = makeMove(board, currentSymbol);
            if(correctMove) { //jesli ruch jest poprawny, sprawdzamy wygraną, zmieniamy gracza
                moveCounter++;
                boolean verseWin = checkVerse(board, currentSymbol);
                boolean columnWin = checkColumn(board, currentSymbol);
                boolean slantWinOne = checkSlantOne(board, currentSymbol);
                boolean slantWinTwo = checkSlantTwo(board, currentSymbol);
                if(verseWin || columnWin || slantWinOne || slantWinTwo){
                    printBoard(board);
                    System.out.println("GRATULACJE " + currentSymbol);
                    continueGame = false;
                }
                currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
            }
        }

    }

    public static boolean checkVerse(char[][] board, char currentSymbol) {
        for (int verse = 0; verse < board.length; verse++){
            boolean win = true;
            for (int column = 0; column < board.length; column++){
                if(board[verse][column] != currentSymbol){
                    win = false;
                    break; // przerywa wewnętrzną pętle
                }

            }
            if (win) {return true;}
        }
        return false;
    }

    public static boolean checkColumn(char [][] board, char currentSymbol){
        for(int column = 0; column < board.length; column++){
            boolean win = true;
            for (int verse = 0; verse < board.length; verse++){
                if(board[verse][column] != currentSymbol){
                    win = false;
                    break;
                }
            }
            if(win){return true;}
        }
        return false;
    }

    public static boolean checkSlantOne(char[][] board, char currentSymbol){
        for(int i = 0; i < board.length; i++){
            if(board[i][i] != currentSymbol){
                return false;
            }
        }
        return true;
    }

    public static boolean checkSlantTwo(char[][] board, char currentSymbol){
        for(int i = 0; i < board.length; i++){
            if(board[i][board.length - i - 1] != currentSymbol){
                return false;
            }
        }
        return true;

    }

    public static boolean makeMove(char [][] board, char currentSymbol){
        System.out.println(currentSymbol + " twój ruch");
        System.out.println("Podaj numer wiersza");
        int verse = scanner.nextInt();
        System.out.println("Podaj numer kolumny");
        int column = scanner.nextInt();
        boolean correctMove = board[verse][column] == 0; //do sprawdzenia czy jest pusty
        if(!correctMove) {
            System.out.println("Ruch niepoprawny, to miejsce jest już zajęte!");
            return false;
        }
        board[verse][column] = currentSymbol;
        return true;
    }
    public static void printBoard(char[][] board){
        int boardDimension = board.length;
        //nagłówki kolumn
        System.out.print("\t");
        // Drukowanie nagłówków kolumn
        for (int i = 0; i < boardDimension; i++) {
            System.out.print(i+ "\t");
        }
        System.out.println();
        for (int verse = 0; verse < board.length; verse++){
            System.out.print(verse + ":\t");
            for (int column = 0; column < board[verse].length; column++){
                System.out.print(board[verse][column] + "\t");

            }
            System.out.println();
        }
    }
}
