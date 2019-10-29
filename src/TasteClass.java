/* Good Abstraction 이란 ?
   1. 내가 표현하려는 class 에 필요한 변수를 설정한다.
   2. 이 변수들을 제어할 수 있는 기능들이 존재한다.
   3. 두 가지가 잘 갖춰진 상태에서
      접근 제어(private, public, protected) 를 잘 활용하면
      이것을 Good Abstraction 이라고 한다.
      이 부분이 잘못될 경우 매일 야근하게 될 것이다.
      설계를 잘 하면 칼퇴할 확률이 올라갑니다 ~
 */
class Car {
    int speed;
    // String 클래스는 문자열을 저장할 수 있다.
    String color;

    /* 함수(매서드) 작성법
       1. 리턴 타입을 적는다.
       2. 함수 이름을 리턴 타입 옆에 짓는다.
       3. 인자를 설정한다.
       4. 기능을 block 안에 작성한다. */
    void setSpeed(int s) {
        speed = s;
    }
    int getSpeed() {
        return speed;
    }
}

class Account {
    int money;
}

public class TasteClass {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.money = 1000000000;

        // Scanner in = new Scanner(System.in);
        Car myCar = new Car();
        myCar.speed = 70;
        myCar.color = "Blue";

        Car myCar2 = new Car();
        myCar2.speed = 30;
        myCar2.color = "Red";

        myCar.setSpeed(180);
        System.out.println("speed = " + myCar.getSpeed());

        System.out.printf("speed = %d, color = %s\n",
                myCar.speed, myCar.color);
        System.out.printf("speed = %d, color = %s\n",
                myCar2.speed, myCar2.color);

        acc.money = 0;
    }
}
