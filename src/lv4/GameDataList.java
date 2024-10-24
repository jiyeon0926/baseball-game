package lv4;

import java.util.ArrayList;
import java.util.List;

public class GameDataList {
    // static 을 사용해 데이터 유지
    private static List<Integer> countList = new ArrayList<>();
    private static List<Integer> sizeList = new ArrayList<>();

    public GameDataList() {
    }

    // 총 진행횟수 담을 리스트
    public static List<Integer> totalCount() {
        return countList;
    }

    public static List<Integer> beforeSize() {
        return sizeList;
    }
}
