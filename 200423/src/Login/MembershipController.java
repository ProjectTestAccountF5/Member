package Login;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import Login.Service.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MembershipController extends Controller implements Initializable{
	final int NAME = 0;
	final int ID = 1;
	final int PW = 2;
	final int PWRE = 3;
	final int PW2 = 4;
	private Parent root;
	private CommonService comServ;
	private MembershipService membershipServ;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		membershipServ = new MembershipServiceImpl();
	}
	public void CancelProc(ActionEvent event) {
		comServ.WindowClose(event);
	}
	private boolean isCheck(Map<String, TextField> txtFldMap, String []txtFldIdArr) {
		if(comServ.isEmpty(txtFldMap, txtFldIdArr)) {
			comServ.ErrorMsg("실패", "회원가입 실패", "빈칸을 입력해주세요");
			return false;
		}
		
		String pw = txtFldMap.get(txtFldIdArr[PW]).getText();
		String pwre = txtFldMap.get(txtFldIdArr[PWRE]).getText();
		if(!membershipServ.comparePW(pw, pwre)) {
			comServ.ErrorMsg("실패", "회원가입 실패","패스워드가 다릅니다.");
			return false;
		}
		return true;
	}
	public void MembershipProc() {
		String []txtFldIdArr = {"#IdTxt", "#NameTxt", "#PwTxt", "#PwTxtre"};
		Map<String, TextField> txtFldMap = 
				comServ.getTextFieldInfo(root, txtFldIdArr);
		
		if(!isCheck(txtFldMap, txtFldIdArr))
			return;
		
		Member member = new Member();
		member.setName(	txtFldMap.get(txtFldIdArr[ID]).getText());
		member.setId(txtFldMap.get(txtFldIdArr[NAME]).getText());
		member.setPw(txtFldMap.get(txtFldIdArr[PW]).getText());

	
		
		if(membershipServ.MembershipProc(member))
			comServ.ErrorMsg("회원가입", "성공", "가입을 축하드립니다.");
		else
			comServ.ErrorMsg("회원가입", "실패", "중복된 아이디입니다.");
	}
	
	
		
		
		
	}














