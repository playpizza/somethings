package dto;

//equip num
//EQUIP_SEQ

public class GAME_EQUIPMENT_DTO {
	private int num;
	private String name;
	private String part;
	private int level;
	private String rating;
	private String class_name;
	private int plus_health;
	private int plus_attack;
	private int plus_move_speed;
	private int plus_attack_speed;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getPlus_health() {
		return plus_health;
	}
	public void setPlus_health(int plus_health) {
		this.plus_health = plus_health;
	}
	public int getPlus_attack() {
		return plus_attack;
	}
	public void setPlus_attack(int plus_attack) {
		this.plus_attack = plus_attack;
	}
	public int getPlus_move_speed() {
		return plus_move_speed;
	}
	public void setPlus_move_speed(int plus_move_speed) {
		this.plus_move_speed = plus_move_speed;
	}
	public int getPlus_attack_speed() {
		return plus_attack_speed;
	}
	public void setPlus_attack_speed(int plus_attack_speed) {
		this.plus_attack_speed = plus_attack_speed;
	}
}
