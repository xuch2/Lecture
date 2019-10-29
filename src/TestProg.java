import java.util.Random;

public class TestProg {
    public static void main(String args[]) {
        //                0      1     2      3      4       5
        int storage[] = {4096, 8192, 16384, 32768, 65536, 131072};
        final int MAXLEN = 10;

        Random rand = new Random();

        int idxCnt[] = {0, 0, 0, 0, 0, 0};

        int stor [][] = null;
        stor = new int[6][10];

        final int END = 131072;
        final int START = 4096;
        final int MAXIDX = 6;

        for(int i = 0; i < MAXLEN; i++) {
            int tmp = rand.nextInt(131072) + 1;
            for(int j = 0; j < MAXIDX; j++) {
                if(tmp > END >> (j + 1)) {
                    stor[j][idxCnt[j]++] = tmp;
                    break;
                }
            }
        }

        for(int i = 0; i < MAXLEN; i++) {
            for(int j = 0; j < MAXIDX; j++) {
                System.out.println("stor[" + j + "][" + i + "] = " + stor[j][i]);
            }
        }
    }
}
