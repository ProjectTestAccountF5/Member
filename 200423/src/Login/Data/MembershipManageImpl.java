package Login.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Login.Member;

public class MembershipManageImpl implements IMembershipManage {
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:C:/자바취업반/shop.db";
	Connection conn ;
	public MembershipManageImpl() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}
	}
	@Override
	public boolean MembershipProc(Member member) {
		String sql = 	"INSERT INTO member "+
						"(id, name, pw ) "+
						"VALUES (?,?,?) ";
		
		PreparedStatement pStmt;
		try {
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, member.getId());
			pStmt.setString(2, member.getName());
			pStmt.setString(3, member.getPw());


			
			pStmt.executeUpdate();
			
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			return false;
		}
		return true;
	}

	@Override
	public int LoginProc(String id, String pw) {
		String sql = 	"SELECT count(*) "+
						"FROM member "+
						"WHERE id=? "+
						"AND pw=? ";
		int result =0;
		PreparedStatement pStmt;
		
		try {
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, id);
			pStmt.setString(2, pw);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt("count(*)");
			
			pStmt.executeUpdate();
			
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			/* e.printStackTrace(); */
			//return result;
		}
		return result;
	}
	@Override
	public List<Member> getMember() {
		String sql ="SELECT * "+
				"FROM Member ";
		List<Member> lstMember =new ArrayList<Member>();
		
		try {
			PreparedStatement pStmt =conn.prepareStatement(sql);
			
			ResultSet rs =pStmt.executeQuery();
			
			while(rs.next()) {
				Member member =new Member();
				
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));



				
				lstMember.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
		return lstMember;
}
	
	public void updateMember (Member member) throws Exception {
		Connection conn = this.conn;
		PreparedStatement pstmt = null;
		
		StringBuilder sql = new StringBuilder();
 
        sql.append("UPDATE member SET ")
            .append("       name=?,")
            .append("       pw=?");
       
 
        try {
            pstmt = conn.prepareStatement(sql.toString());
 
          
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPw());
 
          
 
            if (pstmt.executeUpdate() == 1) {
                System.out.println("회원정보 수정에 성공하였습니다.");
 
            } else {
                System.out.println("회원정보 수정에 실패하였습니다.");
            }
        } catch (Exception e) {
            System.out.println("uptateMember E : ");
            e.printStackTrace();
        } 
          
        }
 

	}

