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
        // Random class 를 객체화 시킨 rand 객체(instance)
        rand = new Random();

        // Loop 를 돌면서 각각의 이중 배열에 난수 설정
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

    void addBetMat(Matrix src) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                res[i][j] = A[i][j] + src.A[i][j];
            }
        }
    }

    // 출력
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
        System.out.println();

        Matrix B = new Matrix();
        B.initArr();
        B.printArr();
        System.out.println();

        A.addBetMat(B);
        A.printArr();
        //

        Matrix multiMat[];
        multiMat = new Matrix[7];

        for(int i = 0; i < 7; i++) {
            multiMat[i] = new Matrix();
        }
    }
}
