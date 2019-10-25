public class ChallengeProb {
    /* 1,    5,    10,   10,   15,   150,  1500, 2300,
       2350, 2350, 2350, 2350, 2350, 2350, 2350, 2350,
       23423, 1231, 52352, 2352332, 13123, 34531, 2342,
       1231, 2342, 2342, 368, 4675, 47905, 45604, 4500,
       5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000

       위와 같은 데이터가 배열에 들어있다고 가정한다(무선 주파수임)
       여기서 가장 빈도수가 높은 주파수 대역을 2 개 추출하고
       몇 번 검출되었는지 확인하는 프로그램을 작성하시오.

       1. 목적: 가장 빈번한 숫자 2 개와 출현 횟수
       2. 배열을 활용하도록 한다.
       3. 각각이 몇 번 출현했는지(빈도수)를 표현해주는 배열이 필요하다.
       4. 이것에 대응대는 숫자 배열이 필요하다.
          (빈도수가 어떤 숫자인지를 알 필요가 있기 때문)
       5. 숫자 값들이 오름차순으로 정렬되면 좀 더 편할 것이다.
     */
    public static void main(String[] args) {
        // Stack 에 배열을 할당하는 방법
        // 들어올 값이 고정된 경우에만 활용 할 수 있음
        int[] wirelessFreq = {
                1, 5, 10, 10, 15, 150, 1500, 2300,
                2350, 2350, 2350, 2350, 2350, 2350, 2350, 2350,
                23423, 1231, 52352, 2352332, 13123, 34531, 2342,
                1231, 2342, 2342, 368, 4675, 47905, 45604, 4500,
                5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000,
                5000
        };

        // 정렬에 활용할 변수들
        int i, j, key;

        // 배열의 원소 개수를 파악하는데 사용함
        int len = wirelessFreq.length;

        // 정렬 알고리즘(Insertion Sort)

        /* ### 동작 과정 분석 ###
           23423, 1231,  52352, 2352332
            [0]    [1]    [2]    [3]

           key = 1231  [1], i = 1
           j = 0, 23423 [0] > 1231 [1]
           [1] = 23423

           23423, 23423, 52352, 2352332
            [0]    [1]    [2]    [3]

           [0] = 1231

           1231, 23423, 52352, 2352332
            [0]   [1]    [2]    [3]
         */
        for(i = 1; i < len; i++) {
            key = wirelessFreq[i];

            for(j = i - 1; wirelessFreq[j] > key; j--) {
                wirelessFreq[j + 1] = wirelessFreq[j];
            }

            wirelessFreq[j + 1] = key;
        }

        for(i = 0; i < len; i++) {
            System.out.println("arr[" + i + "] = " + wirelessFreq[i]);
        }

        int[] number;
        int[] freqCheck;

        /* ### 추가 사항 ###
           프로그램을 개발하다보면 최초 설계와는 다르게
           구현상 문제들이 발생하는 경우가 있습니다 ~
           이런 경우에 해당 문제를 어떻게 해결할 것인지 짱구를 굴립니다 ~

           숫자 배열과 빈도수 배열을 작성하는데 문제가 있다.
           어떤 문제가 있는가 ?
           중복되는 숫자가 몇 개 있는지 모르기 때문에
           정확한 원소의 개수를 산출 할 수 없다.

           6. 그러므로 먼저 중복되지 않은 원소 개수를 판별할 필요가 있다.
         */
        int nonRecursNum = 0;

        System.out.println("len = " + len);

        for(i = 0; i < len; i++) {
            if(i == 0) {
                nonRecursNum++;
                // continue 는 무조건 다시 for 문으로 돌아가게 한다.
                // 단 증감부를 거치게 됨
                continue;
            }

            // 중복이 없으면
            for(j = 0; j < i; j++) {
                // 중복이 있다면 for 문을 바로 빠져나옴
                // 그러므로 j 값이 어떤 경우에도 i 와 같아질 수 없다.
                if(wirelessFreq[i] == wirelessFreq[j]) {
                    break;
                }
            }

            // 그러므로 i 가 j 와 같다는 것은 중복이 없다는 뜻
            if(j == i)
                nonRecursNum++;
        }

        System.out.println("중복 없는 원소의 개수 = " + nonRecursNum);

        number = new int[nonRecursNum];
        freqCheck = new int[nonRecursNum];

        int nonRecursElem = 0;

        for(i = 0; i < len; i++) {
            for(j = 0; j < i; j++) {
                if(wirelessFreq[i] == wirelessFreq[j]) {
                    break;
                }
            }

            if(j == i) {
                number[nonRecursElem++] = wirelessFreq[i];
            }
        }

        System.out.println("nonRecursElem = " + nonRecursElem);

        for(i = 0; i < nonRecursElem; i++) {
            System.out.println("number[" + i + "] = " + number[i]);
        }

        /* 빈도수에 대한 검사는
           기존에 중복 없는 숫자 배열을 만드는 것과 동일한 패턴이다.
           다만 중복되었을 때 이 녀석이
           어디에 배치되어야 하는지를 한 번 더 생각해줘야 한다.

           아래 방법 보다 더 빠르고 효율적인 방법

           i Loop 를 len 으로 검색하는게 아니라
           nonRecursElem 으로 for Loop 을 돌리고
           wirelessFreq 전체를 비교해서 값을 올리면 훨씬 간단하다.

           ### Loop 란 ? ###
           반복문을 의미한다.
           while Loop, for Loop 등등
         */

        for(i = 0; i < len; i++) {
            for(j = 0; j < nonRecursElem; j++) {
                if(number[j] == wirelessFreq[i]) {
                    freqCheck[j]++;
                    break;
                }
            }
        }

        /*
        for(i = 0; i < len; i++) {
            for(j = 0; j < i; j++) {
                if(wirelessFreq[i] == wirelessFreq[j]) {
                    for(int k = 0; k < nonRecursElem; k++) {
                        if(wirelessFreq[i] == number[k]) {
                            freqCheck[k]++;
                            break;
                        }
                    }
                }
            }

            // 중복은 없다가 보장되는 부분임
            if(i == j) {
                for(int k = 0; k < nonRecursElem; k++) {
                    if(wirelessFreq[i] == number[k]) {
                        freqCheck[k] = 1;
                        break;
                    }
                }
            }
        }
         */

        for(i = 0; i < nonRecursElem; i++) {
            System.out.println("freqCheck[" + i + "] = " +
                    freqCheck[i]);
        }

        /* 7. 오름 차순으로 freqCheck 와 number 를 정렬하면 끝!
              내림 차순 버그는 월요일날 해결해서 코드 제공!
         */
        int key2;

        for(i = 1; i < nonRecursNum; i++) {
            key = freqCheck[i];
            key2 = number[i];

            for(j = i - 1; freqCheck[j] > key; j--) {
                freqCheck[j + 1] = freqCheck[j];
                number[j + 1] = number[j];
            }

            freqCheck[j + 1] = key;
            number[j + 1] = key2;
        }

        for(i = 0; i < nonRecursNum; i++) {
            System.out.println("number[" + i + "] = " +
                                number[i] + ", freqCheck[" + i +
                                "] = " + freqCheck[i]);

        }
    }
}