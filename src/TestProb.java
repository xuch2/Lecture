import java.util.Random;

public class TestProb {
    public static void main(String args[]) {
        //                0      1     2      3      4       5
        int storage[] = {4096, 8192, 16384, 32768, 65536, 131072};
        final int MAXLEN = 10;

        Random rand = new Random();

        int idxCnt[] = {0, 0, 0, 0, 0, 0};

        int freeIdx = 0;
        int freeMem[] = new int[10];
        int freeArea[][] = null;
        freeArea = new int[6][10];

        int stor [][] = null;
        stor = new int[6][10];

        final int END = 131072;
        final int START = 4096;
        final int MAXIDX = 6;

        // ex) in: 70000, comp: 70000 vs 4096 -> 70000 vs 8192
        // 70000 vs 16384 -> 70000 vs 32768 -> 70000 vs 65536 -> 70000 vs 131072
        for(int i = 0; i < MAXLEN; i++) {
            int tmp = rand.nextInt(131072) + 1;
            System.out.println("tmp = " + tmp);
            for(int j = 0; j < MAXIDX; j++) {
                if(tmp < START << j) {
                    stor[j][idxCnt[j]++] = tmp;
                    freeMem[freeIdx++] = END - tmp;
                    break;
                }
            }
        }

        for(int i = 0; i < MAXIDX; i++) {
            for(int j = 0; j < MAXLEN; j++) {
                if(stor[i][j] == 0) {
                    continue;
                }
                System.out.println("stor[" + i + "][" + j + "] = " + stor[i][j]);
            }
        }

        System.out.println("idxCnt = ");
        for(int i = 0; i < MAXIDX; i++) {
            System.out.printf("%d ", idxCnt[i]);
        }
        System.out.println();

        System.out.println("freeMem = ");
        for(int i = 0; i < MAXLEN; i++) {
            System.out.printf("%d ", freeMem[i]);
        }
        System.out.println();

        System.out.println("Align Mem with 4096");
        for(int i = 0; i < MAXLEN; i++) {
            freeMem[i] = freeMem[i] &~ 4095;
        }

        System.out.println("Aligned freeMem = ");
        for(int i = 0; i < MAXLEN; i++) {
            System.out.printf("%d ", freeMem[i]);
        }
        System.out.println();

        System.out.println("Check Distributed Mem");
        for(int i = 0; i < MAXLEN; i++) {
            for(int j = MAXIDX - 1; j >= 0; j--) {
                //int tmp = freeMem[i] &~ (START << j - 1);
                //freeMem[i] = freeMem[i] &~ (START << (j + 1));
                int tmp = freeMem[i] &~ ((START << (j + 1)) - 1);
                if (tmp > 0) {
                    freeArea[j][i] = tmp;
                    freeMem[i] = freeMem[i] - tmp;
                    System.out.println("freeMem = " + freeMem[i] +
                                    ", tmp = " + tmp);
                    //break;
                }
            }
        }
        System.out.println();

        for(int i = 0; i < MAXIDX - 1; i++) {
            for(int j = 0; j < MAXLEN; j++) {
                if(freeArea[i][j] == 0) {
                    continue;
                }
                System.out.println("freeArea[" + i + "][" + j + "] = " + freeArea[i][j]);
            }
        }
    }
}
