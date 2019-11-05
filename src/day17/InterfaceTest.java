package day17;

interface Comparable {
    int compareTo(Object other);
}

/* interface 로 만든 것은 반드시 implements 로 받는다.
   abstract 와 차이점이라면
   abstract 는 변수와 매서드 모두 사용하며
   interface 는 매서드만 사용한다는 것이다. */
class StrcmpTest implements Comparable {
    private double area = 0;

    public StrcmpTest(double a) {
        area = a;
    }

    /* Override 란 Abstract Class 와 마찬가지로
       interface 또한 매서드를
       상속 혹은 구현부에서 처리해야 한다.
       그렇기에 상속 혹은 구현을 받아온 것을
       여기에 반드시 작성해줘야 한다.
       이러한 모든 것에는 Override 가 붙는다.
       (C++ 에선 virtual 과 같은 기능이며
       C 에서는 함수 포인터라고 보면 된다)

       지금 여기서 만든 compareTo 는
       C 에서의 strcmp 와 유사한것을 만들었다 생각하면 된다.

       Object 는 최상위 객체이므로
       어떠한 데이터 타입도 받을 수 있다.
       (String), (int), (double) 등등
       어떠한 것으로든 변화를 시킬 수 있다.
     */
    @Override
    public int compareTo(Object other) {
        StrcmpTest st = (StrcmpTest)other;

        if(area < st.area) {
            return -1;
        } else if(area > st.area) {
            return 1;
        } else {
            return 0;
        }
    }

    // C 로 치면 void * 라고 보면 된다.
    public void test(Object obj) {
        System.out.println(obj);
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        StrcmpTest st1 = new StrcmpTest(77.3);
        StrcmpTest st2 = new StrcmpTest(33.7);
        StrcmpTest st3 = new StrcmpTest(33.7);

        if(st1.compareTo(st2) != 0) {
            System.out.println("두 숫자는 같지 않다.");
        }
        if(st1.compareTo(st3) != 0) {
            System.out.println("두 숫자는 같지 않다.");
        }
        if(st2.compareTo(st3) != 0) {
            System.out.println("두 숫자는 같지 않다.");
        } else {
            System.out.println("두 숫자는 같다.");
        }

        st1.test("이게 가능한가 ? ");
    }
}
