package kr.codesquad.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
    private List<User> userList;
    private final int MAX_USER_NUM = 100;
    private final int MIN_USER_NUM = 1;

    public Users(List<String> nameList) {
        this.userList = generateUserList(nameList);
    }

    // 중복 이름 제거
    private List<User> generateUserList(List<String> nameList) {
        isValidUserNum(nameList.size());

        return nameList.stream().distinct()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int size () {
        return userList.size();
    }

    /**
     * 사다리 순서에 맞는 유저 이름 반환
     * */
    public String getUserName(int order) {
        return userList.get(order).getName();
    }
    private void isValidUserNum (int userNum) {
        if (userNum > MAX_USER_NUM || userNum < MIN_USER_NUM) {
            throw new IllegalArgumentException(String.format("[exception] 참여자 수는 %d~%d 범위 내여야 합니다.", MIN_USER_NUM, MAX_USER_NUM));
        }
    }
}
