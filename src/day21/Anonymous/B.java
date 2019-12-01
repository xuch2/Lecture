package day21.Anonymous;

public class B {
    private int dst;

    public B() {
        System.out.println("B called = " + dst);
    }

    public void callInteface(Go l) {
        System.out.println("callInterface Called");
    }
    public interface Go {
        void go();
    }
}
