package lv4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            BaseballGame baseballGame = new BaseballGame(); // 객체를 생성
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n0. 자릿수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String text = sc.next();

            if (text.contains("0")) {
                System.out.println("설정하고자 하는 자리수를 입력하세요.");
                int size = sc.nextInt();
                System.out.println(size + "자릿수 난이도로 설정되었습니다.\n");
                baseballGame.play();
                System.out.println();
            } else if (text.contains("1")) {
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
