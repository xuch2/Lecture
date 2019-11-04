package day16;

/* 문제 7-1. 상속 없이 교수 클래스를 작성해보시오.
   이름, 나이, 전공, 박사학위 여부 */
class Professor {
    private String name;
    private String major;
    private int age;
    private Boolean ph;

    public Professor(String n, String m, int a, Boolean p) {
        name = n;
        major = m;
        age = a;
        ph = p;
    }
    public String toString() {
        String tmp;

        if(ph) {
            tmp = "박사 학위 보유";
        } else {
            tmp = "박사 학위 미보유";
        }
        return "이름 = " + name +
                ", 전공 = " + major +
                ", 나이 = " + age +
                ", 박사학위 여부 = " + tmp;
    }
}

public class ProfessorTest {
    public static void main(String[] args) {
        Professor p = new Professor("이진성",
                "전기전자", 51, true);
        System.out.println(p);
    }
}
