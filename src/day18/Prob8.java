package day18;

/* 문제 8. 정수형 변수 2 개,
   4 byte 형 소수점 변수 1 개,
   8 byte 형 소수점 변수 1 개를 만들고 출력하시오.

   만약 이 문제를 풀지 못했다면 다음 부분을 더 공부하세요 ~

   0. 클래스 작성법
   1. 변수 선언 방법
   2. 생성자 작성법
   3. toString 을 활용한 출력 */
class Numbers {
    private int one, two;
    private float fOne;
    private double dOne;

    public Numbers() {
        this(0, 0, 0, 0);
    }
    public Numbers(int one, int two, float f, double d) {
        this.one = one;
        this.two = two;
        fOne = f;
        dOne = d;
    }
    public void setOne(int one) {
        this.one = one;
    }
    public void setTwo(int two) {
        this.two = two;
    }
    public void setfOne(float fOne) {
        this.fOne = fOne;
    }
    public void setdOne(double dOne) {
        this.dOne = dOne;
    }
    public String toString() {
        return "one = " + one +
                ", two = " + two +
                ", fOne = " + fOne +
                ", dOne = " + dOne;
    }
}

public class Prob8 {
    public static void main(String[] args) {
        Numbers n = new Numbers(3,7,3.3f,7.7);
        System.out.println(n);
    }
}
