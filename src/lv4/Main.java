package lv4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n0. 자릿수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            try {
                int text = sc.nextInt();

                if (text == 0) {
                    System.out.println("설정하고자 하는 자릿수를 입력하세요.");
                    int size = sc.nextInt();

                    if (size == 3 || size == 4 || size == 5) {
                        System.out.println(size + "자릿수 난이도로 설정되었습니다.\n");

                        BaseballGame baseballGame = new BaseballGame(size);
                        baseballGame.play();
                    } else {
                        System.out.println("3, 4, 5자릿수만 가능합니다.\n");
                    }

                } else if (text == 1) {
                    try {
                        List<Integer> beforSize = GameDataList.beforeSize();
                        BaseballGame baseballGame = new BaseballGame(beforSize.getLast());
                        baseballGame.play();
                    } catch (NoSuchElementException e) {
                        System.out.println("자릿수 설정을 먼저 해주세요.\n");
                    }

                } else if (text == 2) {
                    System.out.println("< 게임 기록 보기 >");
                    List<Integer> totalCount = GameDataList.totalCount();

                    for (int i = 0; i < totalCount.size(); i++) {
                        System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + totalCount.get(i));
                    }

                    System.out.println();
                } else if (text == 3) {
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    break;
                } else {
                    System.out.println("올바른 숫자를 입력해주세요!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력할 수 있습니다.");
                break;
            }
        }
    }
}
