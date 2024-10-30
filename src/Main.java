import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] field = new int[9][9];

        for (int i = 0; i < 9; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int newElement;
                do {
                    newElement = rand.nextInt(9);
                } while (used[newElement]);
                field[i][j] = newElement + 1;
                used[newElement] = true;
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}