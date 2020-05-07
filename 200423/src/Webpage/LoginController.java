package Webpage;

import java.net.URL;
import java.util.ResourceBundle;

import Webpage.Service.CommonService;
import Webpage.Service.CommonServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class LoginController extends Controller implements Initializable{
	private Parent root;
	/* private LoginService loginServ; */
	private CommonService comServ;
	/* private MembershipService memberServ; */
		
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* loginServ = new LoginServiceImpl(); */
		comServ = new CommonServiceImpl();
		/* memberServ = new MembershipServiceImpl(); */
	}
	public void LoginProc(ActionEvent e) {
		
			
	}
	
	public void CancelProc(ActionEvent e) {		comServ.WindowClose(e);	}
	public void OpenMembershipForm(ActionEvent e) { 
		
	}
}













