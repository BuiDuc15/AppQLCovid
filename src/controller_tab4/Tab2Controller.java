package controller_tab4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller_tab2.Tab2BottomController;
import controller_tab5.Tab5BottomController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Tab2Controller implements Initializable {
	@FXML 
	private StackPane stackPaneChildren1;
	@FXML
	private AnchorPane anchorPane1;
	@FXML
	private AnchorPane anchorPane2;
	
	@FXML
	private AnchorPane anchorPaneBottom1;
	@FXML
	private AnchorPane anchorPaneBottom2;
	
	
	

	static Tab4BottomController tab4BottomController;
	
	public static Tab4BottomController getTab4BottomController() {
		return tab4BottomController;
	}

	public static void setTab4BottomController(Tab4BottomController tab4BottomController) {
		Tab2Controller.tab4BottomController = tab4BottomController;
	}
	static Tab5BottomController tab5BottomController;
	

	public static Tab5BottomController getTab5BottomController() {
		return tab5BottomController;
	}

	public static void setTab5BottomController(Tab5BottomController tab5BottomController) {
		Tab2Controller.tab5BottomController = tab5BottomController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setDefault();
		anchorPane1.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				
				try {
					anchorPaneBottom1.setVisible(true);
					anchorPaneBottom2.setVisible(false);
					
					stackPaneChildren1.getChildren().clear();
					tab4BottomController = new Tab4BottomController();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab4/Tab2BottomLayout1.fxml"));
					loader1.setController(tab4BottomController);

					Parent root1 = loader1.load();

					stackPaneChildren1.getChildren().add(root1);

//					stackPaneParent.getChildren().addAll(stackPaneTop,stackPaneBottom);
//					stackPaneParent.getChildren().add();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		anchorPane2.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				try {
					anchorPaneBottom1.setVisible(false);
					anchorPaneBottom2.setVisible(true);
					
					tab5BottomController = new Tab5BottomController();
					stackPaneChildren1.getChildren().clear();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab5/Tab2BottomLayout1.fxml"));
					loader1.setController(tab5BottomController);

					Parent root1 = loader1.load();

					stackPaneChildren1.getChildren().add(root1);

//					stackPaneParent.getChildren().addAll(stackPaneTop,stackPaneBottom);
//					stackPaneParent.getChildren().add();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
		
	public void setDefault() {
		anchorPaneBottom1.setVisible(false);
		anchorPaneBottom2.setVisible(false);
		
	}

}
