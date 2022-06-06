import java.util.*;

public class BruteforceSolution {

    private int[][] data;

    public NumMatrix(int[][] matrix) {
        data = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i < row2; i++) {
            for (int j = col1; j < col2; j++) {
                sum += data[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new BruteforceSolution().sumRegion(1, 1, 4, 4);
    }
}
