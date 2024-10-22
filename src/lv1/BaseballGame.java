package lv1;

import java.util.*;

public class BaseballGame {
    private List<Integer> answer;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        Random random = new Random();
        answer = new ArrayList<>();

        /*
         * 플레이어가 맞춰야 할 정답 세 자릿수 생성
         * set.size() < 3 -> 인덱스 0 ~ 2
         * */
        while (answer.size() < 3) {
            answer.add(random.nextInt(9) + 1); // 랜덤으로 1 ~ 9 사이의 숫자로만 추가
        }

        Collections.shuffle(answer);
    }

    public int play() {
        Scanner sc = new Scanner(System.in);
        int[] player = new int[3];

        int count = 0; // 진행횟수 선언 및 0으로 초기화

        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();

        // 플레이어가 3 스트라이커가 될 때까지 반복
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String input = sc.next();

            try {
                // 검증
                int intInput = Integer.parseInt(input);
                boolean validate = validateInput(String.valueOf(intInput));

                if (validate) {
                    /*
                     * 배열 길이만큼 for 문을 순회
                     * int 타입을 문자열로 변환하고, 문자를 정수로 변환해 배열에 담음
                     * */
                    for (int i = 0; i < player.length; i++) {
                        String strInput = Integer.toString(intInput);
                        player[i] = Character.getNumericValue(strInput.charAt(i));
                    }

                    int strike = countStrike(player); // 스트라이크 개수 계산
                    int ball = countBall(player); // 볼 개수 계산

                    baseballGameDisplay.displayHint(strike, ball);

                    count++; // 진행횟수 증가

                    // 정답이면 break 를 이용해 반복문 탈출
                    if (strike == 3) {
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            }
        }
        // 게임 진행횟수 반환
        System.out.println("총 진행횟수는 " + count + "번 입니다.");
        return count;
    }

    /*
     * 길이가 3이면서 입력값 중복이 아닐 때만 true 반환
     * 이외에 false 반환
     * */
    protected boolean validateInput(String input) {
        if (input.length() == 3) {
            String[] split = input.split(""); // 입력 받은 세 자릿수를 잘라서 배열에 저장
            // 배열에 저장된 숫자 3개 모두 중복이 아닐 때, true 반환
            if (!split[0].equals(split[1]) && !split[1].equals(split[2]) && !split[0].equals(split[2])) {
                return true;
            } else {
                System.out.println("중복된 수가 있습니다.");
                return false;
            }
        } else {
            System.out.println("올바르지 않은 입력값입니다.");
            return false;
        }
    }

    /*
     * 스트라이크
     * 숫자와 위치가 맞을 경우만 카운트
     * */
    private int countStrike(int[] player) {
        int strike = 0;

        for (int i = 0; i < player.length; i++) {
            if (player[i] == answer.get(i)) {
                strike++;
            }
        }

        return strike;
    }

    /*
     * 볼
     * 숫자는 맞지만 위치가 다를 경우만 카운트
     * */
    private int countBall(int[] player) {
        int ball = 0;

        for (int num : player) {
            if (answer.contains(num) && player[answer.indexOf(num)] != num) {
                ball++;
            }
        }

        return ball;
    }
}
