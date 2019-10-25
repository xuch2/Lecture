import java.util.Scanner;

public class Homework5 {
    /* 숙제 5.
       1 2 4 8 16 32 64 128 256 512 1024 2048 4096 ...
       위 수열의 데이터를 각각 배열에 저장한다.
       인덱스는 0 부터 시작한다.
       8번째, 10 번째, 12 번째, 16 번째
       인덱스의 값들을 추출하여 출력하고
       추출한 값들을 모두 더한 값을 출력하시오.
     */
    public static void main(String[] args) {
        // 배열 선언
        int[] series;
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print("몇 번째 항 까지 살펴볼까요 ? ");
        num = in.nextInt();

        // 배열에 메모리 할당
        series = new int[num];

        // 초기값 설정
        series[0] = 1;

        System.out.println("series[0] = " + series[0]);

        // shift 연산을 써서 x 2 를 수행함
        // 기본적으로 비트 연산자는 무조건 1 clock 에 처리된다.
        for(int i = 1; i < num; i++) {
            series[i] = series[i - 1] << 1;
            System.out.println("series[" + i +
                                "] = " + series[i]);
        }
    }
    /* 1,    5,    10,   10,   15,   150,  1500, 2300,
       2350, 2350, 2350, 2350, 2350, 2350, 2350, 2350,
       23423, 1231, 52352, 2352332, 13123, 34531, 2342,
       1231, 2342, 2342, 368, 4675, 47905, 45604, 4500,
       5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000

       위와 같은 데이터가 배열에 들어있다고 가정한다(무선 주파수임)
       여기서 가장 빈도수가 높은 주파수 대역을 2 개 추출하고
       몇 번 검출되었는지 확인하는 프로그램을 작성하시오.
     */
}
