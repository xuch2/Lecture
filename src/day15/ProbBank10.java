package day15;

/* 3x^2 + 7x 를 1 ~ 2 까지 정적분하시오 */
class Integral {
    int secondTerm;
    int firstTerm;
    float delta;
    float start;
    float end;
    float curX;
    float allSum;

    public Integral(float start, float end) {
        secondTerm = 3;
        firstTerm = 7;
        delta = 0.0001f;

        this.start = start;
        this.end = end;
        curX = start;
        allSum = 0;
    }

    /* sum lim h->0 { f(x + h) - f(x) } / h
       f(x) = 3x^2 + 7x
       f(x+h) = 3(x+h)^2 + 7(x+h) */
    public void calcIntegral() {
        float tmp;
        for( ; curX < end; curX += delta) {
            tmp = curX + delta;
            allSum += delta *
                    (secondTerm * (float)Math.pow(tmp, 2.0) +
                    firstTerm * tmp);
        }
    }

    public String toString() {
        return "3x^2 + 7x 를 1 ~ 2 까지 정적분한 결과 = " +
                allSum;
    }
}

public class ProbBank10 {
    public static void main(String[] args) {
        Integral i = new Integral(1, 2);
        i.calcIntegral();

        System.out.println(i);
    }
}
