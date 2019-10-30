import java.util.Random;

class AlignTest {
    final int RANGE = 1024;
    int arr[];
    Random rand;

    void initArr() {
        arr = new int[7];
        rand = new Random();

        for(int i = 0; i < 7; i++) {
            arr[i] = rand.nextInt(7777) + 1;
        }
    }

    void alignArr() {
        for(int i = 0; i < 7; i++) {
            // arr[i] &= ~(RANGE - 1);
            arr[i] = arr[i] & ~(RANGE - 1);
        }
    }

    void printArr() {
        for(int i = 0; i < 7; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        System.out.println();
    }
}

public class Homework7 {
    /* 숙제 7-3. 랜덤 숫자를 입력 받아서
       1024 단위로 정렬하도록 프로그램 하시오. */
    public static void main(String[] args) {
        AlignTest at = new AlignTest();
        at.initArr();
        at.printArr();
        at.alignArr();
        at.printArr();
    }
}
