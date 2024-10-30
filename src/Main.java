import java.util.Random;

public class Main{
    public static int boxSize = 3;
    public static int rowSize = 9;
    public static int colSize = 9;
    public static int[][] field = new int[9][9];

    public static void main(String[] args) {
        Random rand = new Random();

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++) {
                int num = (i + j) % 9;
                field[i][j] = num + 1;
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // TODO нужно перемешать матрицу
        // TODO метод Фишера-Йетса

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                int randRow = rand.nextInt(rowSize);
                int randCol = rand.nextInt(colSize);

                int temp = field[i][j];
                field[i][j] = field[randRow][randCol];
                field[randRow][randCol] = temp;
            }
        }

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }
}