package day17;

interface skills {
    void skill1();
    void skill2();
    void skill3();
}

class Adventurer implements skills {
    float atk, def, intel, vit, agl;

    public Adventurer(float a, float d,
                      float i, float v, float ag) {
        atk = a;
        def = d;
        intel = i;
        vit = v;
        agl = ag;
    }
    public void skill1() {
        System.out.println("줍기");
    }
    public void skill2() {
        System.out.println("세게 때리기");
    }
    public void skill3() {
        System.out.println("빠르게 때리기");
    }
}

class Warrior extends Adventurer {
    float anger;

    public Warrior(float a, float d, float i,
                   float v, float ag, float ang) {
        super(a, d, i, v, ag);
        anger = ang;
    }
    public void skill1() {
        System.out.println("방패 치기");
    }
    public void skill2() {
        System.out.println("휩쓸기");
    }
    public void skill3() {
        System.out.println("초절 강화");
    }
}

class Thief extends Adventurer {
    public Thief(float a, float d,
                 float i, float v, float ag) {
        super(a, d, i, v, ag);
    }
    public void skill1() {
        float tmp = agl * 10 + (atk + intel) * 3;
        System.out.println("급소 찌르기 = " + tmp);
    }
    public void skill2() {
        float tmp = (intel + atk) * 2;
        System.out.println("중독: 초당 " + tmp + " 데미지");
    }
    public void skill3() {
        float tmp = 0;
        System.out.println("은신: 30 초 유지");
    }
}

public class GameTest {
    public static void main(String[] args) {
        Adventurer adv = new Adventurer(
                10, 10, 10, 10, 10);
        adv.skill1();
        adv.skill2();
        adv.skill3();

        Warrior war = new Warrior(
                70, 50, 15, 40, 20, 100);
        war.skill1();
        war.skill2();
        war.skill3();

        Thief t = new Thief(
                45, 20, 20, 25, 80);
        t.skill1();
        t.skill2();
        t.skill3();
    }
}
