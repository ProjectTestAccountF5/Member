package Webpage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MembershipController implements Initializable{
	private Parent root;

	/* Connection conn ; */
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void CancelProc(ActionEvent event) {
	}
	public void MembershipProc() {
	}

	/*
	 * public void updateMember (Member member) throws Exception { Connection conn =
	 * this.conn; PreparedStatement pstmt = null;
	 * 
	 * StringBuilder sql = new StringBuilder();
	 * 
	 * sql.append("UPDATE member SET ") .append("       name=?,")
	 * .append("       pw=?");
	 * 
	 * 
	 * try { pstmt = conn.prepareStatement(sql.toString());
	 * 
	 * 
	 * pstmt.setString(1, member.getName()); pstmt.setString(2, member.getPw());
	 * 
	 * 
	 * 
	 * if (pstmt.executeUpdate() == 1) { System.out.println("회원정보 수정에 성공하였습니다.");
	 * 
	 * } else { System.out.println("회원정보 수정에 실패하였습니다."); } } catch (Exception e) {
	 * System.out.println("uptateMember E : "); e.printStackTrace(); }
	 * 
	 * }
	 */
 
}













