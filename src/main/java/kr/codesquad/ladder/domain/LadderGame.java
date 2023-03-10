package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.dto.GameResult;
import kr.codesquad.ladder.view.InputView;
import kr.codesquad.ladder.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public class LadderGame {
    private Ladder ladder;
    private Users users;
    private List<GameResult> gameResultList;
    private InputView inputView;
    private OutputView outputView;

    public LadderGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            users = new Users(inputView.getUserNames());
            List<String> expectedResult = inputView.getResults();
            isValidGameData(users.size(), expectedResult.size());

            ladder = new Ladder(users.size(), inputView.getStepNum());
            gameResultList = generateGameResult(users.getAllUserNames(), expectedResult);

            outputView.printLadder(ladder, users.getAllUserNames(), expectedResult);


            while (true) {
                String userName = inputView.getUserNameForGameResult();
                String result = getUsersGameResult(userName);

               outputView.print(result);
            }

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("게임을 종료합니다.");
        }
    }

    private String getUsersGameResult(String userName) throws NoSuchElementException {
        if (userName.toLowerCase(Locale.ROOT).equals("all")) {
            return 
        }
        return gameResultList.stream()
                .filter(e -> e.isUserData(userName))
                .map(GameResult::getGameResult)
                .findFirst().get();
    }

    private List<GameResult> generateGameResult(List<String> users, List<String> gameResults) {
        List<GameResult> gameResultList = new ArrayList<>();

        for (int i=0; i<users.size(); i++) {
            int endPoint = ladder.getEndPoint(i);
            gameResultList.add(new GameResult(users.get(i), gameResults.get(endPoint)));
        }

        return gameResultList;
    }

    private void isValidGameData(int userNum, int resultNum) {
        if (userNum!=resultNum) {
            throw new IllegalArgumentException("[exception] 사용자와 결과 값의 크기는 같아야 합니다.");
        }
    }


}
