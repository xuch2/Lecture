public class IfWhileTest {
    /* 1 ~ 5 까지의 숫자중 짝수만 찾아서
       1 ~ 9 까지 곱하고 각각의 결과를 출력해보자!
     */
    public static void main(String[] args) {
        int i = 1, j = 1;
        for( ; i < 6; i++) {
            System.out.println("i Loop");
            if(i % 2 == 0) {
                System.out.println("Condition Success");
                /* j 의 초기화 부분이 없었을 때
                   j 가 1 로 다시 초기화되지 않고
                   10 인 상태를 유지하여 출력이 되지 않음
                 */
                System.out.println("j = " + j);

                for(j = 1; j < 10; j++) {
                    System.out.println("res = " + (i * j));
                }
            }
        }
    }
}
