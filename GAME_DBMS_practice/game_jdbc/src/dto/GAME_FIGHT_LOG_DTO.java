package dto;

//fight num
//FIGHT_SEQ

public class GAME_FIGHT_LOG_DTO {
	private int num;
	private int playerA;
	private int playerB;
	private int winner;
	private String play_date;
	private int play_time;
	private String log;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPlayerA() {
		return playerA;
	}
	public void setPlayerA(int playerA) {
		this.playerA = playerA;
	}
	public int getPlayerB() {
		return playerB;
	}
	public void setPlayerB(int playerB) {
		this.playerB = playerB;
	}
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
	public String getPlay_date() {
		return play_date;
	}
	public void setPlay_date(String play_date) {
		this.play_date = play_date;
	}
	public int getPlay_time() {
		return play_time;
	}
	public void setPlay_time(int play_time) {
		this.play_time = play_time;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
}
