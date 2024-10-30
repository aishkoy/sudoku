import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] field = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                int num = (i + j) % 9;
                field[i][j] = num + 1;
            }
        }// TODO нужно думать о том, чтобы и в колону числа не повторялись

    }

    public static int[][] findEmptyCell(int[][] field){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(field[i][j] == 0) return field;
            }
        }
        return null;
    }
}