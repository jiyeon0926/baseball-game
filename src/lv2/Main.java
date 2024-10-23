package lv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
        String text = sc.next();

        if (text.contains("1")) {
            BaseballGame baseballGame = new BaseballGame(); // 객체를 생성
            System.out.println("게임을 시작합니다.");
            baseballGame.play(); // 객체를 통해 play() 메서드를 사용해 게임 실행
        } else if (text.contains("2")) {
            // Lv3에서 구현 예정
        } else if (text.contains("3")){
            System.out.println("게임을 종료합니다.");
        } else {
            System.out.println("없는 번호입니다.");
        }
    }
}
