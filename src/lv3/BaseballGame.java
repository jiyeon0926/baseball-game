package lv3;

import java.util.*;

public class BaseballGame {
    private String answer;
    private static List<Integer> list = new ArrayList<>(); // static 을 사용해 데이터 유지

    // 객체 생성시 생성자가 정답만 반환해 초기화하도록 구성
    public BaseballGame() {
        this.answer = randomAnswer();
    }

    public String randomAnswer() {
        Random random = new Random();
        HashSet<String> set = new HashSet<>();
        StringBuilder answerBuilder = new StringBuilder();

        // set 요소 3개만 추가될 때까지 반복
        while (set.size() < 3) {
            String numbers = String.valueOf(random.nextInt(9) + 1); // 1부터 9까지의 숫자
            set.add(numbers);
        }

        /*
         * set 요소를 가져와 배열 상태가 아닌, 문자열 형태로 변환
         * [1, 2, 3] -> 123
         * */
        for (String num : set) {
            answerBuilder.append(num);
        }

        // 변환한 문자열을 String 타입인 answer 변수에 저장
        String answer = answerBuilder.toString();
        return answer; // 정답만 반환
    }

    public int play() {
        Scanner sc = new Scanner(System.in);
        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
        int count = 0;

        // 플레이어가 3 스트라이커가 될 때까지 반복
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String input = sc.next();

            boolean validate = validateInput(input); // 검증

            if (validate) {
                int strike = countStrike(input); // 스트라이크 개수 계산
                int ball = countBall(input); // 볼 개수 계산

                baseballGameDisplay.displayHint(strike, ball); // 개수에 따른 출력
                count++; // 진행횟수 증가

                // 정답이면 반복문 탈출
                if (strike == 3) {
                    break;
                }
            }
        }
        list.add(count);

        // 게임 진행횟수 반환
        System.out.println("총 진행횟수는 " + count + "번 입니다.");
        return count;
    }

    /*
     * 길이가 3이면서 입력값 중복이 아닐 때만 true 반환
     * 이외에 false 반환
     * */
    protected boolean validateInput(String input) {
        // 숫자 정규식을 사용해 숫자 입력이 아니면 false 반환
        if (!input.matches("^[0-9]*$")) {
            System.out.println("올바르지 않은 입력값입니다.");
            return false;
        }

        // 문자에 0이 있으면 false 반환
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                System.out.println("올바르지 않은 입력값입니다.");
                return false;
            }
        }

        if (input.length() == 3) {
            /*
            * 입력 받은 세 자릿수를 잘라서 배열에 저장
            * 배열에 저장된 숫자 3개 모두 중복이 아닐 때, true 반환
            * 이외 false 반환
            * */
            String[] split = input.split("");
            if (!split[0].equals(split[1]) && !split[1].equals(split[2]) &&
                    !split[0].equals(split[2])) {
                return true;
            } else {
                System.out.println("올바르지 않은 입력값입니다.");
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
    private int countStrike(String input) {
        int strike = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    /*
     * 볼
     * 숫자는 맞지만 위치가 다를 경우만 카운트
     * */
    private int countBall(String input) {
        int ball = 0;

        for (int i = 0; i < input.length(); i++) {
            if (answer.contains(String.valueOf(input.charAt(i))) &&
                    input.charAt(i) != answer.charAt(i)) {
                ball++;
            }
        }

        return ball;
    }

    // 총 진행횟수 담을 리스트
    public static List<Integer> totalCount() {
        return list;
    }
}