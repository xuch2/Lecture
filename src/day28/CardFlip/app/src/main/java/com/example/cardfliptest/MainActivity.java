package com.example.cardfliptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    boolean mShowingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = findViewById(R.id.container);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });

        /* 첫 시작 */
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new CardFrontFragment())
                    .commit();
        }
    }

    /* 클릭하면 */
    void flipCard() {
        if (mShowingBack) {
            mShowingBack = false;
            getSupportFragmentManager().popBackStack();
        } else {
            mShowingBack = true;
            /* getSupportFragmentManager() 를 통해서
               Fragment 를 관리하는 객체를 얻는다.
               Activity 는 새로운 창을 만드는 것인데
               Fragment 는 새로운 창을 띄우는것이 아닌
               기존 화면에 덮어 쓰는 형식으로 처리된다.

               beginTransaction() 은
               애니메이션 동작이 예약되어 있는
               작업이 있다면 실행하는 형식이 된다.
               setCustomAnimations() 를 사용했으므로
               기존에 가지고 있던 애니메이션이 아닌
               우리가 커스텀한 애니메이션을 사용하게 된다.
               결국 인자로는 사용할 애니메이션 XML 을 배치하면 된다.

               replace() 는 ImageView 에서는
               setImageResource("*.jpg") 로 처리했는데
               이 작업을 대신해주는 녀석이라고 보면 된다.
               첫 번째 인자는 FrameLayout 이 되고
               두 번째 인자는 이 동작을 수행할
               Activity 혹은 Fragment 를 배치한다.

               addToBackStack() 은
               Activity 와 다르게
               Context 를 저장하고 복원하는 방식이 다르기 때문이다.
               단순히 이전 스택으로 돌아오는 작업에 해당한다.

               commit() 은 실제 위에 준비한것들을 일괄 실행한다.
               위 부분에서 동작할 작업들을 미리 설정해놓고
               commit() 을 통해서 실제 구동하는 것이라 보면 되겠다. */
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.card_flip_right_enter,
                            R.anim.card_flip_right_exit,
                            R.anim.card_flip_left_enter,
                            R.anim.card_flip_left_exit)
                    .replace(R.id.container, new CardBackFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}
