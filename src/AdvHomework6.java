import java.util.Random;

public class AdvHomework6 {
    /* 배열 요소 하나의 공간이
       4096, 8192, 16384, 32768, 65536, 2^17 까지 가능하다고 가정한다.
       그리고 무작위 데이터는 1 ~ 2^17 까지 할당할 수 있다.
       편의상 공간의 개수는 10 개로 진행 */
    public static void main(String[] args) {
        int storage[] = {4096, 8192, 16384, 32768, 65536, 131072};
        final int MAXLEN = 10;
        // 실제 데이터가 배치되는 영역
        int arr[] = new int[MAXLEN];
        // 인덱스로 활용할 예정
        int idx[] = new int[MAXLEN];
        Random rand = new Random();

        /* 4096 = 2^12, 2^13, 2^14, 2^15, 2^16, 2^17
           2^12 = 00 0001 0000 0000 0000 -> 0
           2^13 = 00 0010 0000 0000 0000 -> 1
           2^14 = 00 0100 0000 0000 0000 -> 2
           2^15 = 00 1000 0000 0000 0000 -> 3
           2^16 = 01 0000 0000 0000 0000 -> 4
           2^17 = 10 0000 0000 0000 0000 -> 5

           &~ == and not, nand */
        for(int i = 0; i < MAXLEN; i++) {
            /* rand.nextInt(131072) + 1
               1 <= x < 131073
               어차피 정수이므로
               1 <= x <= 131072

               &~ nand 는 특정 숫자
               배수로 정렬시키는 특수한 기능이 있다.
               현재 케이스의 경우 4096 의 배수로 정렬시킨 것이다. */
            idx[i] = (rand.nextInt(131072) + 1) &~ (4095);
            System.out.println("idx[" + i + "] = " + idx[i] +
                                ", idx = " + idx[i] / 4096);
        }

        // 공간을 무작위로 배치할 것임을 명시
        for(int i = 0; i < MAXLEN; i++) {
            idx[i] = rand.nextInt(6);
        }

        // 실제 랜덤 데이터 할당
        for(int i = 0; i < MAXLEN; i++) {
            arr[i] = rand.nextInt(131072) + 1;
        }

        System.out.println("15000 nand 4095 = " + (15000 &~ 4095));
    }
}
