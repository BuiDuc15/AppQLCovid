package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller_tab1.Tab1Controller;
import controller_tab4.Tab2Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable {
	@FXML
	private StackPane stackPaneParent;
	@FXML
	private AnchorPane anchorPane1;
	@FXML
	private AnchorPane anchorPane2;
	@FXML
	private AnchorPane anchorPane3;
	@FXML
	private AnchorPane anchorPane4;
	@FXML
	private AnchorPane anchorPane5;
	@FXML
	private AnchorPane anchorPane6;
	@FXML
	private AnchorPane anchorPane7;

	@FXML
	private Pane paneBorder1;
	@FXML
	private Pane paneBorder2;
	@FXML
	private Pane paneBorder3;
	@FXML
	private Pane paneBorder4;
	@FXML
	private Pane paneBorder5;
	@FXML
	private Pane paneBorder6;
	@FXML
	private Pane paneBorder7;

	@FXML
	private Pane paneBackGround1;
	@FXML
	private Pane paneBackGround2;
	@FXML
	private Pane paneBackGround3;
	@FXML
	private Pane paneBackGround4;
	@FXML
	private Pane paneBackGround5;
	@FXML
	private Pane paneBackGround6;
	@FXML
	private Pane paneBackGround7;
	private static Tab1Controller tab1Controller;
	private static Tab2Controller tab2Controller;
	

	public static Tab2Controller getTab2Controller() {
		return tab2Controller;
	}

	public static void setTab2Controller(Tab2Controller tab2Controller) {
		MainController.tab2Controller = tab2Controller;
	}

	public static Tab1Controller getTab1Controller() {
		return tab1Controller;
	}

	public static void setTab1Controller(Tab1Controller tab1Controller) {
		MainController.tab1Controller = tab1Controller;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setDefault();

		anchorPane3.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				paneBorder3.setVisible(true);
				paneBorder6.setVisible(false);
				tab1Controller = new Tab1Controller();

				try {

					stackPaneParent.getChildren().clear();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab1/Tab1Layout.fxml"));
					loader1.setController(tab1Controller);

					Parent root1 = loader1.load();

					stackPaneParent.getChildren().add(root1);

//					stackPaneParent.getChildren().addAll(stackPaneTop,stackPaneBottom);
//					stackPaneParent.getChildren().add();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		anchorPane6.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				paneBorder3.setVisible(false);
				paneBorder6.setVisible(true);
				tab2Controller = new Tab2Controller();

				try {

					stackPaneParent.getChildren().clear();
					FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/controller_tab4/Tab2Layout.fxml"));
					loader1.setController(tab2Controller);

					Parent root1 = loader1.load();

					stackPaneParent.getChildren().add(root1);

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
		anchorPane1.setVisible(true);
		anchorPane2.setVisible(true);

		anchorPane3.setVisible(true);

		anchorPane4.setVisible(true);

		anchorPane5.setVisible(true);

		anchorPane6.setVisible(true);

		anchorPane7.setVisible(true);

		paneBorder1.setVisible(false);
		paneBorder2.setVisible(false);
		paneBorder3.setVisible(false);
		paneBorder4.setVisible(false);
		paneBorder5.setVisible(false);
		paneBorder6.setVisible(false);
		paneBorder7.setVisible(false);

		paneBackGround1.setVisible(false);
		paneBackGround2.setVisible(false);
		paneBackGround3.setVisible(false);
		paneBackGround4.setVisible(false);
		paneBackGround5.setVisible(false);
		paneBackGround6.setVisible(false);
		paneBackGround7.setVisible(false);
	}

}
