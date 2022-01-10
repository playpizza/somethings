package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.DBConnecter;
import dao.GAME_DAO;
import dto.*;

public class User {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		GAME_DAO dao = new GAME_DAO();
//		GAME_ID_VIEW_DTO[] idDto = new GAME_ID_VIEW_DTO[4];
//		GAME_CHAR_VIEW_DTO charDto = new GAME_CHAR_VIEW_DTO();
//		dao.join("개주인", "12341234");
//		System.out.println(dao.takeIdNum("개주인"));
//		System.out.println(dao.checkChCount("개주인"));
//		dao.createChar("개주인", "고냥이", "도적");
//		dao.createChar("개주인", "악어개", "전사");
//		System.out.println(dao.takeEquipPart("나무지팡이"));
//		dao.deleteChar("악어개");
//		System.out.println(dao.login("개주인", "12341234"));
//		System.out.println(dao.checkBan("개주인"));
//		System.out.println(dao.equipW("고냥이", "철검"));
//		System.out.println(dao.takeIdExp("개주인"));
//		GAME_CHAR_VIEW_DTO temp = new GAME_CHAR_VIEW_DTO();
//		temp = dao.viewChar("고냥이");
//		System.out.println(temp.getNick() + temp.getLv());	
//	}
	
	
//	1. 로그인
//		1. 캐릭터 선택
//			1. 캐릭터 정보보기
//			2. 장비 장착하기
//				1. 무기장착
//				2. RED장착
//				3. BLUE장착
//				4. GREEN장착
//				5. 모두제외
//				6. 뒤로가기
//			3. 다른 캐릭터 선택
//			4. 캐릭터 삭제
//		2. 캐릭터 생성
//		3. 로그아웃
//	2. 가입하기
//	3. 관리자메뉴
//		1. 대전로그넣기
//		2. 접속권한 관리
//		3. 종료
//	4. 종료

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GAME_DAO dao = new GAME_DAO();
		GAME_ID_VIEW_DTO[] idDto = new GAME_ID_VIEW_DTO[4];
		GAME_CHAR_VIEW_DTO charDto = new GAME_CHAR_VIEW_DTO();
		String userId = null;
		String charNick = null;
		int menu = 0;
				
		do {
			System.out.println("---- ---- ---- ---- ----");
			System.out.println("---- 메인메뉴 ----");
			System.out.println("1. 로그인");
			System.out.println("2. 가입하기");
			System.out.println("3. 관리자메뉴");
			System.out.println("4. 종료");
			System.out.print("   >> ");
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 1) { //로그인
				menu = 0;
				System.out.println("---- ---- ---- ---- ----");
				System.out.print("ID : ");
				userId = sc.nextLine();
				System.out.print("PW : ");
				String pw = sc.nextLine();
				if(dao.login(userId, pw)) {
					System.out.println("로그인 되었습니다.");
				} else {
					userId = null;
					System.out.println("로그인 실패했습니다.");
					continue;
				}
				
				do {
					System.out.println("---- ---- ---- ---- ----");
					idDto = dao.viewId(userId);
					System.out.println("---- USER : " + userId + "\tLV : " + idDto[0].getUserLv() + " ----");
					for(int i = 0; i < 4; i++) {
						if(idDto[i].getUserId() == null) {
							System.out.println((i + 1) + ". 캐릭터 생성 가능");
						} else {
							System.out.println((i + 1) + ". NICK : " + idDto[i].getCharNick() + "\tLV : " + idDto[i].getCharLv() + "\tCLASS : " + idDto[i].getClassName());
						}
					}
					System.out.println("5. 로그아웃");
					System.out.print("   >> ");
					menu = sc.nextInt();
					sc.nextLine();
					
					if(menu >= 1 && menu <= 4) {
						if(idDto[menu - 1].getUserId() == null) {
							menu = 2;
						} else {
							charNick = idDto[menu - 1].getCharNick();
							charDto = dao.viewChar(charNick);
							menu = 1;
						}
					}
					
					if(menu == 1) { //캐릭터 선택
						
						
						
						do {
							System.out.println("---- ---- ---- ---- ----");
							System.out.println("NICKNAME : " + charDto.getNick() + "\tLV : " + charDto.getLv() + "\tCLASS : " + charDto.getCl());
							System.out.println("WIN : " + charDto.getWin() + "\tRATE : " + charDto.getRate() + "\tTIER : " + charDto.getTier());
							System.out.println("POWER : " + charDto.getPower() + "\tATTACK SPEED : " + charDto.getaSpeed());
							System.out.println("HP : " + charDto.getHp() + "\tAMMOR : " + charDto.getAmmor() + "\tSPEED : " + charDto.getMove());
							System.out.println("WEAPON : " + charDto.getW() + "\tRED : " + charDto.getR());
							System.out.println("BLUE : " + charDto.getB() + "\tGREEN : " + charDto.getG());
							System.out.println();
							
							System.out.println("---- 캐릭터 메뉴 ----");
							System.out.println("1. 장비 장착하기 \t2.다른 캐릭터 선택\t3.캐릭터 삭제");
							System.out.print("   >> ");
							menu = sc.nextInt();
							sc.nextLine();
							
							if(menu == 1) { //장비 장착하기
								System.out.println("---- ---- ---- ---- ----");
								System.out.println("---- 장비 메뉴 ----");
								System.out.println("1. 무기");
								System.out.println("2. RED");
								System.out.println("3. BLUE");
								System.out.println("4. GREEN");
								System.out.println("5. 모두제외");
								System.out.println("6. 뒤로가기");
								System.out.print("   >> ");
								menu = sc.nextInt();
								sc.nextLine();
								
							} else if(menu == 2) { //다른 캐릭터 선택하기(뒤로가기
								charDto = new GAME_CHAR_VIEW_DTO();
								charNick = null;
								System.out.println();
							} else if(menu == 3) { //캐릭터 삭제
								System.out.println("정말로 삭제하시겠습니까? 삭제시 \'Y\'입력 >> ");
								String temp = sc.nextLine();
								if(temp.equals("Y")) {
									menu = 2;
									if(dao.deleteChar(charDto.getNick())) {
										System.out.println("삭제성공");
									}else {
										System.out.println("삭제실패");
									}
									charDto = new GAME_CHAR_VIEW_DTO();
									charNick = null;
								} else {
									menu = 0;
								}
							} else {
								System.out.println("없는 메뉴입니다.");
								System.out.println();
								menu = 0;
							}
							
						}while(menu != 2);
						
					} else if(menu == 2) { //캐릭터 생성
						System.out.println("---- ---- ---- ---- ----");
						System.out.println("NICKNAME : ");
						String makeNick = sc.nextLine();
						//class정하기
						String[] tempCl = dao.takeClAll();
						for(int i = 0; i < tempCl.length; i++) {
							System.out.print((i + 1) + ". " + tempCl[i] + "\t");
							if(i % 4 == 0 && i != 0) {
								System.out.println();
							}
						}
						System.out.println("그 외번호 : 취소");
						System.out.println(" >> ");
						menu = sc.nextInt(); sc.nextLine();
						if(menu <= tempCl.length && menu > 0) {
							String makeCl = tempCl[menu - 1];
							if(dao.createChar(userId, makeNick, makeCl)) {
								System.out.println("생성되었습니다.");
							}else {
								System.out.println("실패했습니다.");
							}
						} else {
							System.out.println("취소됨");
						}
						menu = 0;
					} else if(menu == 5) { //로그아웃
						idDto = new GAME_ID_VIEW_DTO[4];
						userId = null;
						
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println();
						menu = 0;
					}
					
				}while(menu != 5);
				
				
			} else if(menu == 2) { //가입하기
				menu = 0;
				System.out.println("---- ---- ---- ---- ----");
				System.out.print("ID : ");
				userId = sc.nextLine();
				System.out.print("PW : ");
				String pw = sc.nextLine();
				if(dao.join(userId, pw)) {
					System.out.println("가입되었습니다.");
				} else {
					System.out.println("가입 실패했습니다.");
				}
				System.out.println();
				System.out.println();
				
			} else if(menu == 3) { //관리자메뉴
				menu = 0;
				do {
					System.out.println("---- ---- ---- ---- ----");
					System.out.println("---- 관리자메뉴 ----");
					System.out.println("1. 대전로그넣기");
					System.out.println("2. 접속권한 관리");
					System.out.println("3. 종료");
					System.out.print("   >> ");
					menu = sc.nextInt();
					sc.nextLine();
					if (menu == 1) { //대전로그넣기

					} else if (menu == 2) { //접속권한관리
						System.out.println("---- ---- ---- ---- ----");
						System.out.println("1. 접속권한 허락하기");
						System.out.println("2. 접속권한 제한하기");
						System.out.println("3. 뒤로가기");
						System.out.print("  >> ");
						menu = sc.nextInt();
						sc.nextLine();
						if(menu == 1) {
							System.out.println("---- ---- ---- ---- ----");
							System.out.print("대상 ID 입력 : ");
							String temp = sc.nextLine();
							if(dao.allowAccess(temp, true)) {
								System.out.println("변경되었습니다.");
								System.out.println();
							}else {
								System.out.println("실패했습니다.");
								System.out.println();
							}
							
						}else if(menu == 2) {
							System.out.println("---- ---- ---- ---- ----");
							System.out.print("대상 ID 입력 : ");
							String temp = sc.nextLine();
							if(dao.allowAccess(temp, false)) {
								System.out.println("변경되었습니다.");
								System.out.println();
							}else {
								System.out.println("실패했습니다.");
								System.out.println();
							}
						}else if(menu == 3) {
							System.out.println();
							System.out.println();
						}else {
							System.out.println();
							System.out.println();
						}
					} else if (menu == 3) { //종료
						System.out.println();
					} else {
						System.out.println();
					} 
				} while (menu != 3);
				
			} else if(menu == 4) { //종료
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
				System.out.println();
				menu = 0;
			}
			
		}while(menu != 4);
		System.out.println("테스트 프로그램이 종료되었습니다.");
		
	}


}



