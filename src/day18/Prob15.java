package day18;

import importTest.Matrix;

/* 2 by 2 행렬의 뺄셈을 작성하세요 ~ */
public class Prob15 {
    public static void main(String[] args) {
        Matrix matA = new Matrix(2, 2);
        Matrix matB = new Matrix(2, 2);

        matA.setRandMat();
        matB.setRandMat();

        matA.watchMat();
        matB.watchMat();

        //Matrix matRes = new Matrix(2, 2);
        Matrix matRes;
        matRes = matA.subMat(matB);
        matRes.watchMat();
    }
}
