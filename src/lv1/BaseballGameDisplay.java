package lv1;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        System.out.println("Strike: " + strike);
        System.out.println("Ball: " + ball);

        if (strike == 3) {
            System.out.println("Strike: " + strike);
            System.out.println("정답입니다!");
            System.out.println("게임을 종료합니다.");
        }
    }
}
