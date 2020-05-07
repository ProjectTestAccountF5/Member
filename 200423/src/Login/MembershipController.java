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
			comServ.ErrorMsg("����", "ȸ������ ����", "��ĭ�� �Է����ּ���");
			return false;
		}
		
		String pw = txtFldMap.get(txtFldIdArr[PW]).getText();
		String pwre = txtFldMap.get(txtFldIdArr[PWRE]).getText();
		if(!membershipServ.comparePW(pw, pwre)) {
			comServ.ErrorMsg("����", "ȸ������ ����","�н����尡 �ٸ��ϴ�.");
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
			comServ.ErrorMsg("ȸ������", "����", "������ ���ϵ帳�ϴ�.");
		else
			comServ.ErrorMsg("ȸ������", "����", "�ߺ��� ���̵��Դϴ�.");
	}
	
	
		
		
		
	}














