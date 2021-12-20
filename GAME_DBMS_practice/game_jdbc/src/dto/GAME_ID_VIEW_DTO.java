package dto;

public class GAME_ID_VIEW_DTO {
	private String userId;
	private int userLv;
	private int userNum;
	private String charNick;
	private String className;
	private int charLv;
	
	
	public GAME_ID_VIEW_DTO() {
		super();
	}
	public GAME_ID_VIEW_DTO(String userId, int userLv, int userNum, String charNick, String className, int charLv) {
		super();
		this.userId = userId;
		this.userLv = userLv;
		this.userNum = userNum;
		this.charNick = charNick;
		this.className = className;
		this.charLv = charLv;
	}
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserLv() {
		return userLv;
	}
	public void setUserLv(int userLv) {
		this.userLv = userLv;
	}
	public String getCharNick() {
		return charNick;
	}
	public void setCharNick(String charNick) {
		this.charNick = charNick;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getCharLv() {
		return charLv;
	}
	public void setCharLv(int charLv) {
		this.charLv = charLv;
	}
	
}
