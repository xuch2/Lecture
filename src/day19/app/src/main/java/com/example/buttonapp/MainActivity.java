package com.example.buttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/* 특정 버튼을 눌렀을 때
   버튼이 응답을 하도록 해준다.
   (Event Driven 방식이라고 하며 Interrupt 라고도 한다)
   C 에서는 엄밀하게 이들은 사실 함수 포인터에 해당한다.
   Java 관점에서는 결국 interface 에 해당한다. */
public class MainActivity extends AppCompatActivity {
    // Button 클래스 타입의 변수 btn 을 선언함
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 화면 생성
        super.onCreate(savedInstanceState);
        // 화면 생성시 배치할 내용을 activity_main.xml 에서 취하라.
        setContentView(R.layout.activity_main);
        /* activity_main 에 있는 @+id/button 을 찾아서
           해당 내용을 대표할 수 있는 정보를 btn 에 저장한다.
           (주소를 저장한다) */
        btn = (Button)findViewById(R.id.button);

        /* setOnClickListener 는
           btn 을 클릭 했을 경우
           어떤 동작을 하게 만들 것인지
           행동 지침을 지정하는 부분이다.

           OnClickListener 라는 것은 interface 로
           View 라는 클래스에 implements 되어 있다.
           그러므로 반드시 매서드(method) 인
           onClick 의 내용을 개발자가 직접 구현해줘야 한다.

           장점이라면 클릭시
           어떤 처리를 할지 일관되게 만들 수 있다는 것이다.

           그러나 단점은
           개발자가 이 모든 것을 제어할 수 있어야 한다는 것이다.*/

        /* ### 익명 클래스란 ?
           원래 클래스를 사용할 때는
           A a = new A() 와 같은 형태로 사용해야 한다.
           그러나 아래 코드는 'A a =' 부분이 실종되었다.
           아래와 같이 작성하는 형태를 익명 클래스라고 한다.

           추가적인 설명을 적자면
           setOnClickListener 가 클릭을 감시할 것인데
           클릭을 했을때 어떤 동작을 취하게 만들 것인지
           행동 지침을 등록하는 부분이라고 보면 된다.

           인터페이스에 있는 매서드는 반드시
           코드를 작성해줘야지만 new 등의 메모리 할당이 가능하다.

           결론: 이와 같은 형태는
           interface 를 가진 클래스를 객체화 시킬 때
           자주 활용하게 된다.
           그렇기에 Android 에서 밥먹듯이 보게 된다. */

        /* ### 익명 클래스와 일반 사용 방법 비교해보기
           Matrix matA = new Matrix();
           //Matrix matB = new Matrix();
           //matA.addMat(matB);
           matA.addMat(new Matrix()); */
        btn.setOnClickListener(new View.OnClickListener() {
            /* 자동 완성시 Override 가 붙으면
               interface 에 들어있는 매서드라 생각하면 된다.

                onClick 은 실제 클릭시 어떤 행동을 취하게 할지
                개발자가 생각한 내용을 구현하는 부분이다. */
            @Override
            public void onClick(View v) {
                /* Toast 는 말 그대로 토스트다.
                   토스트 기기에 빵을 넣고 3 분이 지나면
                   구워진 빵이 튀어 오른다.
                   여기서도 유사하게 메시지가 튀어 오르기 때문에
                   이름을 토스트라고 붙였다고 한다.

                   makeText() 는 글자를 만드는 매서드다.

                   1 번째 인자 getApplicationContext() 는
                   현재 구동중인 앱의
                   모든 상태 정보를 가져오는 매서드다.

                   2 번째 인자는 "토스트로 만들고 싶은 글자"

                   3 번째 인자는 토스트를 얼마나 오래 띄워놓을 것인지

                   ### 아래 코드 해석에 도움이 되는 부분

                   Toast.makeText(getApplicationContext(),
                        "Pressed Button",
                        Toast.LENGTH_SHORT)

                   뒤 쪽에 붙은 것을 보면 .show() 인데
                   . 과 매서드가 있기 때문에
                   결국 위의 코드는 클래스를 반환한다는 의미다.
                   매서드에 커서를 올리고 우클릭 후
                   go to -> Declaration 으로 가면
                   정의를 볼 수 있다.

                   ### 프로토타입이란 ?
                   매서드(함수)의 리턴, 이름, 인자 등등을 의미함
                   결국 입력, 출력을 보겠다는 의미

                   매서드의 프로토타입을 보면
                   리턴 타입, 인자 등등을 확인할 수 있는데
                   결론은 Toast 를 리턴(반환)한다는 것을 알 수 있다.

                   show() 는 작성한 내용을 화면에 출력해준다. */
                Toast.makeText(getApplicationContext(),
                        "Pressed Button",
                        Toast.LENGTH_SHORT).show();
                /* ###Event Driven(Interrupt) (이)란 ?
                   1. 모든 Event Driven 방식은
                      어떠한 경우에도 반드시 운영체제가 실행한다.
                   2. 사용자(개발자)는 행동 지침만을 결정한다.
                      (사용자 - User, 운영체제 - Kernel)
                   3. 특정 상황(Event - 이벤트) 이 발생하면
                      운영체제가 지정된 행동 지침을 실행한다.
                 */
            }
        });

        tv = (TextView)findViewById(R.id.resText);
        tv.setText("잘.된.다.?");
    }
}

/* 문제 19. 두 개의 Button 을 만듭니다.
            Layout 은 LinearLayout 으로 만듭니다.
            그나마 보기 좋게 vertical 로 만듭니다.
            오늘 배운 padding 한 번 해주세요 ~
            TextView 를 1 개 만듭니다.
            1 번째 Button 을 누르면 Toast 메시지 출력
            2 번째 Button 을 누르면 TextView 의 글자를 변경 */