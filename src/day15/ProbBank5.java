package day15;

import java.util.Scanner;

/* 1, 3, 4, 7, 11, 18, 29, 47, 76
   23 번째 숫자가 무엇인지 프로그래밍 하시오.
 */
class MySeries {
    private int series[];
    Boolean notOk;
    Scanner in;
    int num;

    public MySeries() {
        System.out.println("MySeries Constructor");
        in = new Scanner(System.in);

        series = new int[23];

        series[0] = 1;
        series[1] = 3;

        notOk = true;
    }

    public int findSpecificTerm() {
        System.out.println("findSpecificTerm Method");
        while(notOk) {
            System.out.print("찾을 항을 입력하세요 : ");
            num = in.nextInt();

            if (num < 2) {
                System.out.println("다시 입력해주세요 ~");
                notOk = true;
            } else {
                notOk = false;
            }
        }

        for(int i = 2; i < num; i++) {
            series[i] = series[i - 2] + series[i - 1];
        }

        return series[num - 1];
    }
}

public class ProbBank5 {
    public static void main(String[] args) {
        MySeries ms = new MySeries();
        System.out.println("res = " + ms.findSpecificTerm());
    }
}
