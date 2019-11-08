class A {
    int a;

    public A() {
        a = 3;
    }
    public String toString() {
        return "a = " + a;
    }
}

public class AnomTest {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);

        System.out.println(new A());
    }
}
