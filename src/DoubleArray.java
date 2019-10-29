public class DoubleArray {
    /* 이중 배열(데이터 타입이 일치)
       1. 수학에서는 행렬 연산을 풀 경우에 사용함
       2. 연립 방정식도 가우스-조르단 소거법(행렬)을 통해 계산 가능
       3. 로봇에 관심이 많다면 필수!
       4. 재고 관리 프로그램
     */
    public static void main(String[] args) {
        // 1. 행렬 타입
        int matrix [][];
        matrix = new int[3][3];

        System.out.println("res = ");

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix[i][j] = i * 3 + j + 1;
            }

            System.out.println(matrix[i][0] + " " +
                                matrix[i][1] + " " +
                                matrix[i][2]);
        }

        int tri[][] = new int[3][];
        tri[0] = new int[3];
        tri[1] = new int[2];
        tri[2] = new int[1];

        int idx = 3;

        System.out.println("res = ");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < idx; j++) {
                tri[i][j] = i * 3 + j + 1;
                // printf -> format = 서식
                // %d 는 숫자, %f 는 소수점
                System.out.printf("%d ", tri[i][j]);
            }
            idx--;
            System.out.println();
        }
        /* 문제 6. class 를 활용하여
           2 by 2 행렬의 덧셈을 구현하시오. */
    }
}
