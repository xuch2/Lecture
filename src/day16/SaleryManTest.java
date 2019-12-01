package day16;

/* 상속을 활용하여 회사원 클래스를 작성해보시오. */
class SaleryMan extends Student {
    int salary;

    public SaleryMan(String n, int a,
                     String major, int salary) {
        super(n, a, major);
        this.salary = salary;
    }
    public String toString() {
        return "이름 = " + name +
                ", 전공 = " + major +
                ", 나이 = " + age +
                ", 연봉 = " + salary;
    }
}

public class SaleryManTest {
    public static void main(String[] args) {
        SaleryMan s = new SaleryMan("장형석",
                53,"물리학",90000000);
        System.out.println(s);
    }
}
