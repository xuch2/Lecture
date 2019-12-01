package day18;

/* 랜덤 숫자 2 개를 작성하고
   이들간의 and, or, xor, not 을 계산하시오.

   이 문제를 풀지 못했을 경우 아래를 공부하세요 ~

   0. 클래스 작성법
   1. 기존에 작성한 클래스를 활용하는 방법
   2. and, or, xor, not 등의 비트 연산자 학습 */
public class Prob11 {
    public static void main(String[] args) {
        RandNum rn1 = new RandNum();
        rn1.initNumber();

        RandNum rn2 = new RandNum();
        rn2.initNumber();

        System.out.println(rn1);
        System.out.println(rn2);

        System.out.println("and = " + rn1.calcAnd(rn2));
        System.out.println("or = " + rn1.calcOr(rn2));
        System.out.println("xor = " + rn1.calcXor(rn2));

        System.out.println("not rn1 = " + rn1.calcNot());
        System.out.println("not rn2 = " + rn2.calcNot());
    }
}
