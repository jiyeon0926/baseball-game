package lv3;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        if (strike == 3) {
            System.out.println("정답입니다!");
            System.out.println("게임을 종료합니다.");
        } else if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println("Strike: " + strike);
            System.out.println("Ball: " + ball);
        }
    }
}
