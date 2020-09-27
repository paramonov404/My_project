
public class Matrix {
    int size;
    int[][] matrix;
    int[][] sumMatrix;

    Matrix(int size) {
        this.size = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -10 + ((int) (Math.random() * 20));
            }
        }
    }

    public void matrixOutput(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
                if (j == size-1){
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public void sum() {
        sumMatrix = new int[size][size];
        sumMatrix[0][0] = matrix[0][0];

        for (int j = 1; j < size; j++) {
            sumMatrix[0][j] = sumMatrix[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < size; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                sumMatrix[i][j] = Math.max(sumMatrix[i - 1][j], sumMatrix[i][j - 1]) + matrix[i][j];
            }
        }
    }

    public void matrixSumOutput(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(sumMatrix[i][j]);
                System.out.print(" ");
                if (j == size-1){
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public void Result() {
        System.out.println(sumMatrix[size-1][size-1]);
    }
}