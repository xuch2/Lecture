package day15;

import java.math.BigInteger;
import java.util.Scanner;

/* 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
   1 ~ 57 번째까지의 수중 홀수들의 합과 짝수들의 합을 구한다.
   홀수들의 합 - 짝수들의 합의 결과를 산출하시오.
 */
class MyFibSeries {
    private BigInteger series[];
    private Boolean notOk;
    private Scanner in;
    BigInteger oddSum, evenSum;
    BigInteger diff;
    int num;

    public MyFibSeries() {
        in = new Scanner(System.in);

        series = new BigInteger[57];

        series[0] = BigInteger.valueOf(1);
        series[1] = BigInteger.valueOf(1);

        notOk = true;

        oddSum = BigInteger.valueOf(0);
        evenSum = BigInteger.valueOf(0);
    }

    public void setSpecificTerm() {
        while(notOk) {
            System.out.print("몇 번째 항 까지 작업할까 ? ");
            num = in.nextInt();

            if(num < 2) {
                System.out.println("다시 입력해주세요 ~");
            } else {
                notOk = false;
            }
        }

        for(int i = 2; i < num; i++) {
            series[i] = series[i - 2].add(series[i - 1]);
        }
    }

    public void calcEachSum() {
        for(int i = 0; i < num; i++) {
            if(series[i].mod(BigInteger.valueOf(2)).compareTo(
                    BigInteger.valueOf(1)) == 0) {
                oddSum = oddSum.add(series[i]);
            } else {
                evenSum = evenSum.add(series[i]);
            }
        }
    }

    public void calcDiff() {
        diff = oddSum.subtract(evenSum);
    }

    public String toString() {
        return "홀수의 합 = " + oddSum +
                "\n짝수의 합 = " + evenSum +
                "\n홀수의 합 - 짝수의 합 = " + diff +
                "\n마지막 숫자 = " + series[num - 1];
    }
}

public class ProbBank6 {
    public static void main(String[] args) {
        MyFibSeries mfs = new MyFibSeries();
        mfs.setSpecificTerm();
        mfs.calcEachSum();
        mfs.calcDiff();

        System.out.println(mfs);
    }
}
