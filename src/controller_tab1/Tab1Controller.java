package controller_tab1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller_tab2.Tab2BottomController;
import controller_tab3.Tab3BottomController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Tab1Controller implements Initializable {
	@FXML 
	private StackPane stackPaneChildren1;
	@FXML
	private AnchorPane anchorPane1;
	@FXML
	private AnchorPane anchorPane2;
	@FXML
	private AnchorPane anchorPane3;
	@FXML
	private AnchorPane anchorPaneBottom1;
	@FXML
	private AnchorPane anchorPaneBottom2;
	@FXML
	private AnchorPane anchorPaneBottom3;
	
	static Tab1BottomController tab1BottomController;
	static Tab2BottomController tab2BottomController;
	static Tab3BottomController tab3BottomController;
	

	public static Tab1BottomController getTab1BottomController() {
		return tab1BottomController;
	}



	public static void setTab1BottomController(Tab1BottomController tab1BottomController) {
		Tab1Controller.tab1BottomController = tab1BottomController;
	}



	public static Tab2BottomController getTab2BottomController() {
		return tab2BottomController;
	}



	public static void setTab2BottomController(Tab2BottomController tab2BottomController) {
		Tab1Controller.tab2BottomController = tab2BottomController;
	}



	public static Tab3BottomController getTab3BottomController() {
		return tab3BottomController;
	}



	public static void setTab3BottomController(Tab3BottomController tab3BottomController) {
		Tab1Controller.tab3BottomController = tab3BottomController;
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
					anchorPaneBottom3.setVisible(false);
					stackPaneChildren1.getChildren().clear();
					tab1BottomController = new Tab1BottomController();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab1/Tab1BottomLayout1.fxml"));
					loader1.setController(tab1BottomController);

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
					anchorPaneBottom3.setVisible(false);
					tab2BottomController = new Tab2BottomController();
					stackPaneChildren1.getChildren().clear();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab2/Tab1BottomLayout2.fxml"));
					loader1.setController(tab2BottomController);

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
		anchorPane3.setOnMouseClicked(new EventHandler<Event>() {
			
			@Override
			public void handle(Event arg0) {
				try {
					anchorPaneBottom1.setVisible(false);
					anchorPaneBottom2.setVisible(false);
					anchorPaneBottom3.setVisible(true);
					tab3BottomController = new Tab3BottomController();
					stackPaneChildren1.getChildren().clear();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab3/Tab1BottomLayout3.fxml"));
					loader1.setController(tab3BottomController);

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
		anchorPaneBottom3.setVisible(false);
	}

}
