package Login;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Login.Service.CommonService;
import Login.Service.CommonServiceImpl;
import Login.Service.LoginService;
import Login.Service.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class LoginController extends Controller implements Initializable{
	private Parent root;
	private LoginService loginServ;
	private CommonService comServ;
	/* Button btn = new Button("#LoginBtn"); */

	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginServ = new LoginServiceImpl();
		comServ = new CommonServiceImpl();
		
	}
	public void LoginProc() {
		String []txtFldIdArr = {"#loginIdTxt", "#loginPwTxt"};
		Map<String, TextField> txtFldMap = 
				comServ.getTextFieldInfo(root, txtFldIdArr);
		if(comServ.isEmpty(txtFldMap, txtFldIdArr)) {
			JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է����ּ���");
			return ;
			
		}
		
		if(loginServ.LoginProc(root))
			loginsuccess();
		/*
		 * if(loginServ.LoginProc(root)) btn.setVisible(false);
		 */
		
		else
			comServ.ErrorMsg("�α���", "�α��� ����", "�α��ο� �����ϼ̽��ϴ�.");	
	}
	
	
	public void CancelProc(ActionEvent event) {		comServ.WindowClose(event);	}
	public void OpenMembershipForm() {
		Parent form = loginServ.OpenMembershipForm();
	
	}
	public void favertalkloginForm() {
		Parent form2 = loginServ.favertalkloginForm();
}
	
	public void loginsuccess() {

		Parent form3 = loginServ.loginsuccess();
}
	
	
}















