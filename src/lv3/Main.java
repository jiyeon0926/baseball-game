package lv3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(); // 객체를 생성
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String text = sc.next();

            if (text.contains("1")) {
                System.out.println("< 게임을 시작합니다 >");
                baseballGame.play();
                System.out.println();
            } else if (text.contains("2")) {
                System.out.println("< 게임 기록 보기 >\n");
                List<Integer> list = baseballGame.totalCount();

                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + list.get(i));
                }
            } else if (text.contains("3")) {
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                break;
            } else {
                System.out.println("올바른 숫자를 입력해주세요!\n");
            }
        }
    }
}
