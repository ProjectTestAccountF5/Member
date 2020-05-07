package Login.Service;

import Login.Data.IMembershipManage;
import Login.Data.MembershipManageImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl implements LoginService{
	
	
	@Override
	public boolean LoginProc(Parent root) {
		TextField idTxt = (TextField)root.lookup("#loginIdTxt");//idTxt
		TextField pwTxt = (TextField)root.lookup("#loginPwTxt");//pwTxt
		
		IMembershipManage membershipManage = new MembershipManageImpl();
		if(membershipManage.LoginProc(idTxt.getText(), pwTxt.getText())==1)
			return true;
		
		return false;		
	}
		@Override
	public Parent OpenMembershipForm() {
		CommonService comServ = new CommonServiceImpl();
		Stage membershipForm = new Stage();
		Parent form =  comServ.showWindow(membershipForm, "../membershipForm.fxml");
		
		return form;
	}
	
		public Parent favertalkloginForm() {
			CommonService comServ = new CommonServiceImpl();
			Stage FatalkloginForm = new Stage();
			Parent form2 =  comServ.showWindow(FatalkloginForm, "../favertalklogin.fxml");
			
			return form2;
		}
	
		public Parent loginsuccess() {
			
			CommonService comServ = new CommonServiceImpl();
			
			Stage mypage = new Stage();
			Parent form3 =  comServ.showWindow(mypage, "../mypage(main).fxml");
			
			return form3;
		}
		
	
	
}








