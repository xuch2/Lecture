package day14;

class Student {
    String name;
    String major;
    String minor;
    int age;

    /*
    public Student() {
        this("아무개", "삽질", "맨땅헤딩", 23);
    }
     */

    /* 생성자는 리턴 타입이 없다.
       즉 void 도 적지 않는다.
       그리고 특징이라면 class 이름과
       생성자의 이름은 동일하다.

       이 녀석은 new 를 하는 시점에 동작하게 된다.

       *** 생성자는 오버로딩이 가능하다!
       로딩은 메모리에 올린다는 의미다.
       오버는 뭔가 위에 덮어 쓴다.
       즉 같은 이름의 매서드를 여러 개 만들 수 있다는 의미!

       조건: 인자의 개수나 인자의 타입이 달라야 한다.
     */
    public Student() {
        System.out.println("생성자 시작");
        name = "아무개";
        major = "삽질";
        minor = "맨땅헤딩";
        age = 23;
    }

    /* 인자 4 개 짜리 생성자 */
    public Student(String n, String ma, String mi, int a) {
        System.out.println("인자 4 개 짜리 생성자");
        name = n;
        major = ma;
        minor = mi;
        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "name = " + name +
                ", major = " + major +
                ", minor = " + minor +
                ", age = " + age + "\n";
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
        System.out.println("생성자 시작 전");
        Student stu = new Student();
        System.out.println("생성자 시작 후");
        System.out.println(stu);

        System.out.println("생성자 시작 전");
        Student stu2 = new Student("홍길동",
                "의적",
                "강탈",
                27);
        System.out.println("생성자 시작 후");

        System.out.println(stu2);

        Magician mag = new Magician();
    }
}
