package day21.Anonymous;

class A {
    private int num;

    public A() {
        num = 3;
        System.out.println("A called");
    }
    public int getNum() {
        return num;
    }
    public interface Test {
        public void test();
    }
}

public class AnonyTest {
    public static void main(String[] args) {
        A a = new A();

        new A.Test() {
            public void test() {
                System.out.println("Test");
            }
        };

        B b = new B();
        b.callInteface(new B.Go() {
            public void go() {
                System.out.println("interface go");
            }
        });
    }
}
