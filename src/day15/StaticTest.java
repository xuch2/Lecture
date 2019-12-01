package day15;

class StaticCnt {
    // static 으로 선언한 변수는 data 영역에 배치된다.
    // *** 즉, 전역 변수화가 됩니다.
    static int cnt = 0;

    public StaticCnt() {
        cnt++;
        System.out.println("cnt = " + cnt);
    }
}

public class StaticTest {
    public static void test() {
        System.out.println("test");
    }
    /* 함수가 전역 변수화 ???
       함수는 text 영역인데 ?
       함수에 static 이 붙는 것은 변수와는 동작이 다르다.
       메모리 할당 전에 이미 로드가 완료되어있음
     */
    public static void main(String[] args) {
        StaticCnt sc1 = new StaticCnt();
        StaticCnt sc2 = new StaticCnt();
        StaticCnt sc3 = new StaticCnt();

        test();
    }
}
