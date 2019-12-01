package day13;

import java.util.Random;

public class ProbSol {
    public static void main(String[] args) {
        final int MAXLEN = 10;
        final int MAXIDX = 6;
        final int START = 4096;

        int stor[][] = null;
        int idxCnt[] = {0, 0, 0, 0, 0, 0};
        stor = new int[MAXIDX][MAXLEN];

        int remain;
        int freeArea[][] = new int[6][10];
        int freeIdxCnt[] = {0, 0, 0, 0, 0, 0};
        int freeMem[] = new int[10];

        Random rand = new Random();

        /* 현재까지의 구현은 공간 할당과 낭비된 공간을 표현한다.
           이 상태에서 추가적으로 처리해야하는 문제는 예로 아래와 같다.
           70000 이 입력된 경우 131072 를 할당한다.
           남은 공간은 51072 가 될 것이다.
           이 경우 32786, 16384 를 추가로 분해하여 사용할 수 있다.
           어떻게 표현할 것인가 ?

           낭비되고 있는 남은 공간은 freeMem 이 표현하고 있다.

           1. freeMem &~ (4096 ... 65536) 을 통해서
              분해가 가능한지 여부를 판별해야 한다.
           2. 3 번 작업을 위해 freeIdxCnt[5] 도 필요하다.
           3. freeArea[2 의 승수 인덱스][해당 인덱스의 몇 번째] 를 저장
           4. freeMem &~ 32786 ===> res = 32786
              freeMem - res = remain(나머지) = 51072 - 32768 ~ 18000
              remain &~ 16384 ===> res = 16384
              freeMem - res = remain(나머지) = ~18000 - 16384 ~ 1000
              if(remain < 4096) 의 조건을 가지고 작업한다.
           5. 4 번을 보면 freeMem 을 쓰다가 remain 을 쓰고 있다.
              하나로 통일 시켜야 for 문을 활용할 수 있을텐데
              이 부분을 고려해보도록 한다.
           6. 최종적으로 각 파트별(4096 ... 65536) 공간이
              몇 개씩 활용이 가능한지 출력하면 된다.
         */
        for(int i = 0; i < MAXLEN; i++) {
            // 1 ~ 131072
            int tmp = rand.nextInt(131072) + 1;
            System.out.println("first tmp = " + tmp);
            for(int j = 0; j < MAXIDX; j++) {
                if(tmp < START << j) {
                    stor[j][idxCnt[j]] = tmp;
                    System.out.printf("stor[%d][%d] = %d\n",
                            j, idxCnt[j], stor[j][idxCnt[j]]);
                    freeMem[i] = (START << j) - tmp;
                    System.out.printf("freeMem[%d] = %d\n\n",
                            i, freeMem[i]);
                    idxCnt[j]++;
                    break;
                }
            }

            for(int j = 4; j >= 0; j--) {
                remain = freeMem[i];

                if((remain & ~((START << j) - 1)) >= 4096) {
                    freeArea[j][freeIdxCnt[j]++] = START << j;
                    freeMem[i] -= START << j;
                }

                /* 디버깅 용도였으므로 주석처리함
                System.out.println("remain = " + remain);
                System.out.printf("freeMem[%d] = %d\n",
                        i, freeMem[i]);
                System.out.printf("freeArea[%d][%d] = %d\n\n",
                        j, freeIdxCnt[j]-1,
                        freeArea[j][freeIdxCnt[j]-1]);
                 */
            }
        }

        for(int i = 0; i < MAXLEN; i++) {
            for(int j = 0; j < MAXIDX; j++) {
                System.out.printf("before freeArea[%d][%d] = %d\n",
                        j, i, freeArea[j][i]);
            }
        }

        /* stor[][] 배열에 설정된 것은 실제 할당된 것들
           freeArea[][] 는 현재 빈 공간에 대한 정보
           더 이상 stor[][] 에 공간이 부족하여
           할당할 수 있는 상태가 아니라 가정

           그러므로 이제 다시 뭔가를 할당할 때
           freeArea 에서 적절한 녀석을 찾아서
           배치하는 것을 확인하면 된다.
         */
        for(int i = 0; i < MAXIDX; i++) {
            System.out.printf("freeIdxCnt[%d] = %d\n",
                    i, freeIdxCnt[i]);
        }

        /* 실제 랜덤값을 배치해보도록 한다. */
        for(int i = 0; i < 3; i++) {
            // 1 ~ 32768
            int tmp = rand.nextInt(32768) + 1;
            System.out.printf("rand tmp = %d\n", tmp);

            for(int j = 0; j < 4; j++) {
                if(tmp >> (12 + j) <= 0) {
                    freeArea[j][freeIdxCnt[j]-1] = 0;
                    freeIdxCnt[j]--;
                    break;
                }
            }
        }

        for(int i = 0; i < MAXLEN; i++) {
            for(int j = 0; j < MAXIDX; j++) {
                System.out.printf("after freeArea[%d][%d] = %d\n",
                        j, i, freeArea[j][i]);
            }
        }
    }
}
