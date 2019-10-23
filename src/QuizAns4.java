import java.util.Scanner;

public class QuizAns4 {
    /*숙제 4. 아래와 같은 수열이 존재한다.
      while 문을 사용해서 풀어보자 ~

      1 1 3 4 5 8 12 17 25 37 ...

      키보드 입력을 받아 몇 번째 항 까지
      합치기(sigma) 를 수행할지 정한다.

      합치기 결과를 출력하시오.
     */
    public static void main(String[] args) {
        // final 은 상수를 만들때 사용한다.
        final int INIT = 3;

        Scanner in = new Scanner(System.in);

        System.out.print("몇 번째 항까지 진행할까요 ? ");
        int num = in.nextInt();

        int first = 1, second = 1, third = 3;
        int finalRes = first + second + third;

        System.out.println("first = " + first);
        System.out.println("second = " + second);
        System.out.println("third = " + third);

        num -= INIT;

        /* 1       1       3       4       5       8      12
         first  second   third
                 first  second   third
                         first  second   third
                                 first  second   third
                                         first  second   third

           second = next first
           third = next second
           first + third = next third
         */
        while(num-- > 0) {
            int tmp = first;
            first = second;
            second = third;
            third = tmp + second;

            finalRes += third;

            System.out.println("third = " + third);
        }

        System.out.println("Final Res = " + finalRes);
    }
}
