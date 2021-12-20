package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.*;

public class GAME_DAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	//아이디 중복검사 (해당아이디가 없을 때 true)
	public boolean checkId(String id) {
		String query = "SELECT COUNT(USER_ID) FROM GAME_USER_ID WHERE USER_ID = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			rs.next();
			if(rs.getInt(1) == 0) {check = true;}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//캐릭터 닉네임 중복검사 (해당 닉네임이 없을 때 true)
	public boolean checkCh(String nick) {
		String query = "SELECT COUNT(CHAR_NICKNAME) FROM GAME_USER_CHAR WHERE CHAR_NICKNAME = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
			
			rs.next();
			if(rs.getInt(1) == 0) {check = true;}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//현재 id의 캐릭터 수 검사
	public int checkChCount(String id) {
		String query = "SELECT COUNT(USER_NUM) FROM GAME_USER_CHAR WHERE USER_NUM = ?";
		int count = 0;
		try {
			int idNum = takeIdNum(id);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idNum);
			
			rs = pstm.executeQuery();
			rs.next();
			count = rs.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return count;
	}
	
	//equip존재검사 (해당 장비이름이 없을 때 true)
	public boolean checkEquip(String name) {
		String query = "SELECT COUNT(EQUIP_NAME) FROM GAME_EQUIPMENT WHERE EQUIP_NAME = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			
			rs.next();
			if(rs.getInt(1) == 0) {check = true;}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//아이디의 NUM 가져오기 
	public int takeIdNum(String id) {
		String query = "SELECT USER_NUM " + 
			"FROM GAME_USER_ID " + 
			"WHERE USER_ID = ?";
		
		int num = 0;
		try {
			if(checkId(id)) {return 0;}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return num;
	}
	
	//캐릭터 NUM가져오기 													
	public int takeCharNum(String nick) {
		String query = "SELECT CHAR_NUM " + 
			"FROM GAME_USER_CHAR " + 
			"WHERE CHAR_NICKNAME = ?";
		
		int num = 0;
		try {
			if(checkCh(nick)) {return 0;}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nick);
			
			rs = pstm.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return num;
	}
	
	//캐릭터의 유저NUM가져오기
	public int takeCharIdNum(String nick) {
		String query = "SELECT USER_NUM " + 
			"FROM GAME_USER_CHAR " + 
			"WHERE CHAR_NICKNAME = ?";
		
		int num = 0;
		try {
			if(checkCh(nick)) {return 0;}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nick);
			
			rs = pstm.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return num;
	}
	
	//장비의 NUM가져오기
	public int takeEquipNum(String name) {
		String query = "SELECT EQUIP_NUM " + 
			"FROM GAME_EQUIPMENT " + 
			"WHERE EQUIP_NAME = ?";
		
		int num = 0;
		try {
			if(checkEquip(name)) {return 0;}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			
			rs = pstm.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return num;
	}
	
	//장비의 PART가져오기
	public String takeEquipPart(String name) {
		String query = "SELECT EQUIP_PART " + 
			"FROM GAME_EQUIPMENT " + 
			"WHERE EQUIP_NAME = ?";
		
		String part = "";
		try {
			if(checkEquip(name)) {return "";}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			
			rs = pstm.executeQuery();
			rs.next();
			part = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return part;
	}
	
	//회원가입
	public boolean join(String id, String pw) {
		String query = "INSERT INTO GAME_USER_ID " + 
			"(USER_NUM, USER_ID, USER_PW) " + 
			"VALUES(USER_SEQ.NEXTVAL, ?, ?)";
		boolean check = false;
		if(id.length() > 32) {return check;}
		if(pw.length() > 32) {return check;}
		try {
			if(!checkId(id)) {return check;}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//캐릭터생성
	public boolean createChar(String id, String nick, String cl) {
		String query = "INSERT INTO GAME_USER_CHAR " +
			"(CHAR_NUM, USER_NUM, CHAR_NICKNAME, CLASS_NAME) " +
			"VALUES(CHAR_SEQ.NEXTVAL, ?, ?, ?)";
		boolean check = false;
		try {
			if(checkChCount(id) > 4) {return check;}
			if(checkId(id)) {return check;}
			if(!checkCh(nick)) {return check;}
			int idNum = takeIdNum(id);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idNum);
			pstm.setString(2, nick);
			pstm.setString(3, cl);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}

	//회원삭제
	public boolean without(String id) {
		String query = "DELETE FROM GAME_USER_ID " + 
			"WHERE USER_NUM = ?";
		boolean check = false;
		try {
			if(checkId(id)) {return check;}
			int idNum = takeIdNum(id);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idNum);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//캐릭터삭제													
	public boolean deleteChar(String id) {
		String query = "DELETE FROM GAME_USER_CHAR " + 
			"WHERE CHAR_NUM = ?";
		boolean check = false;
		try {
			if(checkCh(id)) {return check;}
			int charNum = takeCharNum(id);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, charNum);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//로그인
	public boolean login(String id, String pw) {
		String query = "SELECT COUNT(USER_ID) FROM GAME_USER_ID " +
				"WHERE USER_ID = ? AND USER_PW = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			rs.next();
			
			if(rs.getInt(1) == 1) {check = true;}
			if(!checkBan(id)) {return false;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//밴 확인
	public boolean checkBan(String id) {
		String query = "SELECT USER_ACCESS " + 
				"FROM GAME_USER_ID " + 
				"WHERE USER_ID = ?";
		boolean check = false;
		String access = "N";
		try {
			if(checkId(id)) {return check;}
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			rs.next();
			access = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		if(access.equals("Y")) {check = true;}
		return check;
	}
	
	//장비 W 장착
	public boolean equipW(String nick, String w) {
		String query = "UPDATE GAME_USER_CHAR " + 
			"SET CHAR_WEAPON = ? " + 
			"WHERE CHAR_NUM = ?";
		boolean check = false;
		try {
			if(checkCh(nick)) {return check;}
			if(checkEquip(w)) {return check;}
			if(!takeEquipPart(w).equals("W")) {return check;}
			int equipNum = takeEquipNum(w);
			int charNum = takeCharNum(nick);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, equipNum);
			pstm.setInt(2, charNum);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	//장비 R 장착
	public boolean equipR(String nick, String r) {
		String query = "UPDATE GAME_USER_CHAR " + 
			"SET CHAR_RED = ? " + 
			"WHERE CHAR_NUM = ?";
		boolean check = false;
		try {
			if(checkCh(nick)) {return check;}
			if(checkEquip(r)) {return check;}
			if(!takeEquipPart(r).equals("R")) {return check;}
			int equipNum = takeEquipNum(r);
			int charNum = takeCharNum(nick);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, equipNum);
			pstm.setInt(2, charNum);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	//장비 B 장착
	public boolean equipB(String nick, String b) {
		String query = "UPDATE GAME_USER_CHAR " + 
			"SET CHAR_BLUE = ? " + 
			"WHERE CHAR_NUM = ?";
		boolean check = false;
		try {
			if(checkCh(nick)) {return check;}
			if(checkEquip(b)) {return check;}
			if(!takeEquipPart(b).equals("B")) {return check;}
			int equipNum = takeEquipNum(b);
			int charNum = takeCharNum(nick);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, equipNum);
			pstm.setInt(2, charNum);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	//장비 G 장착
	public boolean equipG(String nick, String g) {
		String query = "UPDATE GAME_USER_CHAR " + 
			"SET CHAR_GREEN = ? " + 
			"WHERE CHAR_NUM = ?";
		boolean check = false;
		try {
			if(checkCh(nick)) {return check;}
			if(checkEquip(g)) {return check;}
			if(!takeEquipPart(g).equals("G")) {return check;}
			int equipNum = takeEquipNum(g);
			int charNum = takeCharNum(nick);
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, equipNum);
			pstm.setInt(2, charNum);
			if(pstm.executeUpdate() == 1) {check = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return check;
	}
	
	//아이디의 캐릭터 열람
	public GAME_ID_VIEW_DTO[] viewId(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs;
		GAME_ID_VIEW_DTO[] dto = new GAME_ID_VIEW_DTO[4];
		String query = "SELECT * " + 
				"FROM GAME_ID_VIEW " + 
				"WHERE USER_ID = ? " + 
				"ORDER BY CHAR_NUM";
			
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			int i = 0;
			while(rs.next()) {
				dto[i] = new GAME_ID_VIEW_DTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				i++;
			}
			while(i<4) {
				dto[i] = new GAME_ID_VIEW_DTO();
				i++;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return dto;
	}
	//캐릭터 정보 열람
	public GAME_CHAR_VIEW_DTO viewChar(String nick) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs;
		GAME_CHAR_VIEW_DTO dto = new GAME_CHAR_VIEW_DTO();
		String query = "SELECT * " + 
				"FROM GAME_CHAR_VIEW " + 
				"WHERE CHAR_NICKNAME = ? ";
			
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nick);
			
			rs = pstm.executeQuery();
			rs.next();
			dto.setNick(rs.getString(1));
			dto.setLv(rs.getInt(2));
			dto.setCl(rs.getString(3));
			dto.setTier(rs.getString(4));
			dto.setWin(rs.getInt(5));
			dto.setRate(rs.getInt(6));
			dto.setHp(rs.getInt(7));
			dto.setAmmor(rs.getInt(8));
			dto.setPower(rs.getInt(9));
			dto.setMove(rs.getInt(10));
			dto.setaSpeed(rs.getInt(11));
			dto.setW(rs.getString(12));
			dto.setR(rs.getString(13));
			dto.setB(rs.getString(14));
			dto.setG(rs.getString(15));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return dto;
	}
	
	//아이디 경험치 가져오기
	public int takeIdExp(String id) {
		String query = "SELECT USER_EXP " + 
			"FROM GAME_USER_ID " + 
			"WHERE USER_ID = ?";
		
		int num = 0;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return num;
	}
	//캐릭터경험치 가져오기
	public int takeCharExp(String nick) {
		String query = "SELECT CHAR_EXP " + 
			"FROM GAME_USER_CHAR " + 
			"WHERE CHAR_NICKNAME = ?";
		
		int num = 0;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nick);
			
			rs = pstm.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 		
		return num;
	}
	
	//클래스 개수
	public int takeClCount() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs;
		int count = 0;
		String query = "SELECT COUNT(CLASS_NAME) " + 
				"FROM GAME_CLASS ";
			
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery();
			rs.next();
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return count;
	}
	
	//클래스종류 가져오기
	public String[] takeClAll() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs;
		String[] cls = new String[takeClCount()];
		String query = "SELECT CLASS_NAME " + 
				"FROM GAME_CLASS ";
			
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery();
			int i = 0;
			while(rs.next()) {
				cls[i] = rs.getString(1);
				i++;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} 
		
		return cls;
	}
	
	//대전기록 입력과 exp획득
	
	
}
