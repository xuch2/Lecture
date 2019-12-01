package day18;

import java.util.Scanner;

/* 정수형 변수 2 개,
   4 byte 형 소수점 변수 1 개,
   8 byte 형 소수점 변수 1 개를 만들고 출력하시오.

   이 문제를 풀지 못했다면 다음을 공부해주세요 ~

   0. 클래스 작성법
   1. Scanner 사용법
   2. 상속(extends) 사용법 */
class Scan extends Numbers {
    private Scanner in;

    public Scan() {
        super();
        in = new Scanner(System.in);
    }
    public void keyboardIn() {
        System.out.println("첫 번째 정수를 입력하세요 ~");
        setOne(in.nextInt());
        System.out.println("두 번째 정수를 입력하세요 ~");
        setTwo(in.nextInt());
        System.out.println("float 형 값을 입력하세요 ~");
        setfOne(in.nextFloat());
        System.out.println("double 형 값을 입력하세요 ~");
        setdOne(in.nextDouble());
    }

}

public class Prob9 {
    public static void main(String[] args) {
        Scan s = new Scan();
        s.keyboardIn();
        System.out.println(s);
    }
}
