import java.util.Random;

public class Main{
    static Random rand = new Random();

    public static int boxSize = 3;
    public static int rowSize = 9;
    public static int colSize = 9;
    public static int[][] field = new int[9][9];


    public static void main(String[] args) {
        if(fillBoard(field)){
            printBoard(field);
        } else {
            println("Что-то пошло не так...");
        }
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


    public static boolean fillBoard(int[][] board){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < colSize; col++){
                if(board[row][col] == 0){
                    int[] numbers = getRandomNumbers();

                    for(int num : numbers){
                        if(isValid(field, row, col, num)){
                            board[row][col] = num;
                            if(fillBoard(board)){
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
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


    public static void printBoard(int[][] board){
        for(int row = 0; row < rowSize; row++){
            if(row % 3 == 0 && row != 0){
                println("—————————╋—————————╋—————————");
            }
            for(int col = 0; col < colSize; col++){
                if(col % 3 == 0 && col != 0){
                    print("│");
                }
                printf(" %d ", board[row][col]);
            }
            println("");
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