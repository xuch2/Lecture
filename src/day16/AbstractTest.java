package day16;

/* abstract 클래스에 있는 내용은
   반드시 생성자쪽에서 같이 처리해줘야 한다.
   상속을 받았지만 super 로 처리하는 방식은 아니다.
   이것을 응용한 것이 interface 인데
   super 처리 방식이 아니라 언제나 형태를 바꿀 수 있다.
   결론: 같은 이름으로 여러 기능을 구현할 수 있다.
 */
abstract class Message {
    public String subject;
    public String content;

    public void test() { }
}

class Messanger extends Message {
    private String sender;
    private String receiver;

    public Messanger(String sender, String receiver,
                     String subject, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
    }
    private void sendingCheck() {
        System.out.println("메시지를 보냅니다 ~");
    }
    public String toString() {
        sendingCheck();
        return "송신자 = " + sender +
                ", 수신자 = " + receiver +
                ", 제목 = " + subject +
                ", 내용 = " + content;
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        Messanger m = new Messanger("엄마",
                "아들", "너 어디니 ?",
                "학원에서 안왔다고 전화왔어");
        System.out.println(m);
    }
}
