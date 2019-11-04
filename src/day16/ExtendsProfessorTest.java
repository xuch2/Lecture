package day16;

/* 상속을 활용하여 교수 클래스를 작성해보시오. */
class Professor2 extends Student {
    Boolean ph;

    public Professor2(String n, int a,
                      String major, Boolean ph) {
        super(n, a, major);
        this.ph = ph;
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

public class ExtendsProfessorTest {
    public static void main(String[] args) {
        Professor2 p = new Professor2("마승찬",
                47, "컴퓨터 과학", true);
        System.out.println(p);
    }
}
