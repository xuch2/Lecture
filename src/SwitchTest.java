import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("0 ~ 100 사이의 정수를 입력해주세요 ~");
        int num = in.nextInt();

        /* 제어문에 한해서 한 줄 짜리는
           block 을 치지 않아도 무방하다.
           그러나 초보자들이 여기서 상당히 큰 실수를 많이 하므로
           되도록이면 처음 할 때는 항상 block 을 치는 습관을 들이자!
         */
        if((num >= 0) && (num <= 100)) {
            System.out.println("Input OK");
        } else {
            System.out.println("다시 입력해주세요 ~");
        }

        num /= 10;

        /* switch 문을 적는 방법

           1. switch() 를 적는다.

           2. 괄호 안에 스위치 대상이 될 값이나 변수를 설정한다.

           3. 괄호 안에 오는 조건을 만족하는 각각의 case 를 적는다.

           4. case 를 적고 아래쪽에
              case 를 만족한 경우 동작시킬 코드를 작성한다.
              그리고 반드시 break 를 표기해주도록 한다.
         */
        switch(num) {
            case 10:
                System.out.println("A+");
                break;
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                /* break 는 switch 문의 종료를 뜻한다.
                   만약 break 가 없다면
                   그 아래 case 도 진행하게 된다.
                 */
                break;
            case 6:
                System.out.println("F");
                break;
            default:
                System.out.println("F");
                break;
        }
    }
}
