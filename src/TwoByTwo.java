import java.util.Random;

class Matrix {
    int A[][];
    int B[][];
    int res[][];
    Random rand;

    void initArr() {
        A = new int[2][2];
        B = new int[2][2];
        res = new int[2][2];
        rand = new Random();

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                A[i][j] = rand.nextInt(5) + 1;
                B[i][j] = rand.nextInt(5) + 1;
            }
        }
    }

    void addMatrix() {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                res[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    void printArr() {
        System.out.println("res = ");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.printf("%d ", res[i][j]);
            }
            System.out.println();
        }

        System.out.println("A = ");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.printf("%d ", A[i][j]);
            }
            System.out.println();
        }

        System.out.println("B = ");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.printf("%d ", B[i][j]);
            }
            System.out.println();
        }
    }
}

public class TwoByTwo {
    public static void main(String[] args) {
        Matrix A = new Matrix();
        A.initArr();
        A.addMatrix();
        A.printArr();

        Matrix B = new Matrix();
        B.initArr();

        Matrix multiMat[];
        multiMat = new Matrix[7];

        for(int i = 0; i < 7; i++) {
            multiMat[i] = new Matrix();
        }
    }
}
