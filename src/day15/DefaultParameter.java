package day15;

class Vector {
    private float x, y, z;

    /* this 는 자기 자신
       그러므로 객체 자신을 나타냄
       여기서 this == Vector
     */
    public Vector() {
        this(0, 0, 0);
    }
    public Vector(float x) {
        this(x, 0, 0);
    }
    public Vector(float x, float y) {
        this(x, y, 0);
    }
    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    // 클래스 객체를 인자로 받음
    public float dotProduct(Vector src) {
        return x * src.x + y * src.y + z * src.z;
    }
    public String toString() {
        return "x = " + x + ", y = " + y + ", z = " + z;
    }
}

public class DefaultParameter {
    public static void main(String[] args) {
        // (0, 0, 0) 을 원함
        Vector v1 = new Vector();
        // (x, 0, 0), (0, y, 0), (0, 0, z)
        // (x, y, 0), (0, y, z), (x, 0, z)
        // (x, y, z)
        /* 게임에 관심이 있으신 분들은
           1. 추가적으로 Unity(쉬움), Unreal(중상) 를 공부하세요 ~
           2. OpenGL ES(C++) 를 공부하세요 ~
           3. Android NDK(JNI 활용) 을 공부하세요 ~
           4. 수학, 물리 공부(일반물리)
         */
        Vector v2 = new Vector(3);
        Vector v3 = new Vector(3, 3);
        Vector v4 = new Vector(3, 3, 3);
        Vector v5 = new Vector(-3, 3, 0);

        System.out.println("inner = " + v4.dotProduct(v5));

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
