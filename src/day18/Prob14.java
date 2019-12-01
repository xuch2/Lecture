package day18;

/* 랜덤한 숫자를 2 개 입력받고
   대소 비교를 하세요 ~

   0. 클래스 작성법
   1. if, else if, else 사용법 */
public class Prob14 {
    public static void main(String[] args) {
        RandNum rn1 = new RandNum();
        rn1.initNumber();

        RandNum rn2 = new RandNum();
        rn2.initNumber();

        System.out.println(rn1);
        System.out.println(rn2);

        rn1.compareNum(rn2);
    }
}
