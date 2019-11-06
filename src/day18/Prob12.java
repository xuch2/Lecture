package day18;

/* 랜덤 숫자를 만들고
   랜덤한 쉬프트 연산을 해보세요 ~

   이 문제를 풀지 못했다면 다음을 학습해주세요 ~

   0. 클래스 작성법
   1. 비트 연산자 shift (>>, <<) 복습
   2. Boolean 타입 복습
      (true, false 를 저장할 수 있음)
   3. '%' 연산자(mod 연산자) 활용법
   4. 제어문 중 if 문 활용법 */
public class Prob12 {
    public static void main(String[] args) {
        RandNum rn = new RandNum();
        rn.initNumber();
        System.out.println(rn);
        System.out.println("random shift = " +
                rn.randShift());
    }
}
