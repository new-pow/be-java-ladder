package kr.codesquad.ladder.dto;

public class GameResult {
    private String userName;
    private String gameResult;

    public String getUserName() {
        return userName;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public GameResult(String userName, String gameResult) {
        this.userName = userName;
        this.gameResult = gameResult;
    }

    public boolean isUserData(String inputName) {
        return userName.equals(inputName);
    }
}
