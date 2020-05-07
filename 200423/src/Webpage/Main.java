package Webpage;

import java.io.IOException;

import Webpage.Service.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {	
		CommonService comServ = new CommonServiceImpl();
		BorderPane borderPane = (BorderPane)comServ.getScene("/Webpage/mypage(main).fxml");
		Parent loginScene = comServ.getScene("/Webpage/mypage(회원정보).fxml");

		
		//BorderPane borderPane = (BorderPane)comServ.showWindow(primaryStage, "/Webpage/Main.fxml");
		borderPane.setCenter(loginScene);
		
		primaryStage.setScene(new Scene(borderPane));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
