package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
			Scene scene = new Scene(root,1300,800);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stg=primaryStage;
			primaryStage.setScene(scene);
			primaryStage.show();
			stg.setTitle("Login");
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void changeScene(String fxml,String title) throws IOException {
		  
		  
		  BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
		  Scene scene = new Scene(root,1300,800);
		  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
		  stg.setScene(scene); 
		  stg.show(); 
		  stg.setTitle(title);
		  }
	
}
