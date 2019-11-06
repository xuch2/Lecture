package day18;

import importTest.Matrix;

/* 2 by 2 행렬의 뺄셈을 작성하세요 ~

   이 문제를 풀지 못했다면 다음을 공부하세요 ~

   0. 클래스 작성법
   ### 추가로 import 하여 외부 클래스 사용하는 방법
   1. 이중 배열 활용법
   2. 랜덤 클래스 활용법
   3. 클래스 객체를 인자로 넘기는 방법
   4. ### 효율적인 매서드 작성법 */
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
