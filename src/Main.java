import java.util.Random;
import java.util.Scanner;

public class Main{
    static Random rand = new Random();

    public static int boxSize = 3;
    public static int rowSize = 9;
    public static int colSize = 9;
    public static int[][] field = new int[9][9];


    public static void main(String[] args) {
        int[][] originBoard = getOriginBoard(field);
        int[][] gameBoard = initGameBoard(originBoard);
        printBoard(gameBoard);
        for(int i = 0; i < 40; i++){
            getUserInput(gameBoard, originBoard);
            printBoard(gameBoard);
        }
        printBoard(gameBoard);
    }


    public static int[] getRandomNumbers(){
        int[] numbers = new int[rowSize];

        for(int i = 0; i < rowSize; i++){
            numbers[i] = i + 1;
        }

        for(int i = 0; i < rowSize; i++){
            int j = rand.nextInt(rowSize);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }


    public static int[][] getOriginBoard(int[][] board){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < colSize; col++){
                if(board[row][col] == 0){
                    int[] numbers = getRandomNumbers();

                    for(int num : numbers){
                        if(isValid(field, row, col, num)){
                            board[row][col] = num;
                            int[][] result = getOriginBoard(board);
                            if(result != null){
                                return result;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return null;
                }
            }
        }
        return board;
    }

    public static boolean isValid(int[][] board, int row, int col, int num){
        for(int i = 0; i < colSize; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        for(int i = 0; i < rowSize; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        int startRow = (row / boxSize) * boxSize;
        int startCol = (col / boxSize) * boxSize;

        for(int i = 0; i < boxSize; i++) {
            for(int j = 0; j < boxSize; j++) {
                if(board[startRow + i][startCol + j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] initGameBoard(int[][] originBoard){
        int[][] newBoard = new int[originBoard.length][originBoard[0].length];
        for(int i = 0; i < originBoard.length; i++){
            for(int j = 0; j < originBoard[0].length; j++){
                newBoard[i][j] = originBoard[i][j];
            }
        }

        int clearedCells = 40;
        while(clearedCells > 0){
            int randCol = rand.nextInt(colSize);
            int randRow = rand.nextInt(rowSize);
            if(newBoard[randRow][randCol] != 0){
                newBoard[randRow][randCol] = 0;
                clearedCells--;
            }
        }

        return newBoard;
    }

    public static void printBoard(int[][] board){
        String boardLetters = "     1  2  3     4  5  6     7  8  9";
        String topBorder = "  ┌———————————————————————————————————┐";
        String midBorder = "  │———————————┼———————————┼———————————│";
        String botBorder = "  └———————————————————————————————————┘";
        String lineSeparator = " │ ";

        println(boardLetters);
        println(topBorder);

        for(int row = 0; row < rowSize; row++){

            if(row % 3 == 0 && row != 0){
                println(midBorder);
            }

            print((char)('A' + row) + lineSeparator);

            for(int col = 0; col < colSize; col++){
                if(col % 3 == 0 && col != 0){
                    print(lineSeparator);
                }

                String cell = (board[row][col] == 0) ? "[ ]" : String.format(" %d ", board[row][col]);

                if (col == 0) {
                    print(cell);
                } else if (col == colSize - 1) {
                    print(cell);
                } else {
                    print(cell);
                }
            }
            println(lineSeparator + (char)('A' + row));
        }
        println(botBorder);
        println(boardLetters);
    }

    public static void getUserInput(int[][] gameBoard, int[][] originBoard){
        Scanner sc = new Scanner(System.in);
        int number;
        while(true) {
            print("\nВведите координаты ячейки (например A1, D5): ");
            String usersCoordinates = sc.nextLine().strip().toUpperCase();

            if (usersCoordinates.length() != 2 || usersCoordinates.isBlank()) {
                println("Неверный ввод повторите попытку...");
                continue;
            }

            if (!usersCoordinates.matches("^[A-I][1-9]$")){
                println("Введите координаты латиницей и цифрой! (A-I) (1-9)");
                continue;
            }

            int row = usersCoordinates.charAt(0) - 'A';
            int col = usersCoordinates.charAt(1) - '1';

            if(gameBoard[row][col] != 0){
                println("Данная клетка уже содержит цифру!");
                continue;
            }

            while(true) {
                print("Введите цифру для этой ячейки:");
                String usersInput = sc.nextLine().strip().toUpperCase();

                if (usersInput.length() != 1 || usersInput.isBlank()) {
                    println("Неверный ввод... Повторите попытку.");
                    continue;
                }
                if (!usersInput.matches("^[1-9]$")) {
                    println("Введите цифры только от 1 до 9!");
                    continue;
                }

                number = Integer.parseInt(usersInput);
                gameBoard[row][col] = number;

                if(gameBoard[row][col] != originBoard[row][col]){
                    println("К сожалению, это неверная цифра...");
                    gameBoard[row][col] = 0;
                    break;
                }
                println("Число успешно добавлено!");
                break;
            }
            break;
        }
    }

    public static void printf(String str, Object... args){
        System.out.printf(str, args);
    }

    public static void println(String str){
        System.out.println(str);
    }

    public static void print(String str){
        System.out.print(str);
    }
}