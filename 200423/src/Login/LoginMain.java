package Login;

import java.io.IOException;

import Login.Service.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {	
		CommonService comServ = new CommonServiceImpl();
		comServ.showWindow(primaryStage, "../loginform.fxml");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

