package Webpage;

import java.net.URL;
import java.util.ResourceBundle;

import Webpage.Service.CommonService;
import Webpage.Service.CommonServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable{
	private Parent root;
	private CommonService comServ;
	
	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
	}
	public void ProfileView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent loginScene = comServ.getScene("/Webpage/mypage(회원정보).fxml");
		borderPane.setCenter(loginScene);
	}
	
	  public void basketView(ActionEvent e) { 
		  BorderPane borderPane = (BorderPane)getScene(e); 
		  Parent basketScene = comServ.getScene("/Webpage/shoppingbasket.fxml");
	  borderPane.setCenter(basketScene); 
	  
	 }
	  public void orderlistView(ActionEvent e) { 
		  BorderPane borderPane = (BorderPane)getScene(e); 
		  Parent orderlistScene = comServ.getScene("/Webpage/orderlist.fxml");
	  borderPane.setCenter(orderlistScene); 
	  }
	  public void LogoutProc(ActionEvent e) { 
		  ; 
	  }
	  
	  
	  
	  
	/* public void 
	 * MembershipView(ActionEvent e) { BorderPane borderPane =
	 * (BorderPane)getScene(e); Parent membershipScene =
	 * comServ.getScene("/Webpage/Membership.fxml");
	 * borderPane.setCenter(membershipScene); } public void
	 * MembershipView(ActionEvent e) { BorderPane borderPane =
	 * (BorderPane)getScene(e); Parent membershipScene =
	 * comServ.getScene("/Webpage/Membership.fxml");
	 * borderPane.setCenter(membershipScene); }
	 */
	
	
}













