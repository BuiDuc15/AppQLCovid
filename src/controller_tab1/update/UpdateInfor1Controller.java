package controller_tab1.update;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.TaiSanModel;
import controller_tab1.Tab1BottomController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdateInfor1Controller implements Initializable {
	@FXML
	private TextField textFieldTen;
	@FXML
	private TextField textFieldHienTrang;
	@FXML
	private TextField textFieldSoLuong;
	
	
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonCancel;
	double x, y;

	@FXML
	void draged(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setX(event.getScreenX() - x);
		stage.setY(event.getScreenY() - y);
	}

	@FXML
	void pressed(MouseEvent event) {
		x = event.getSceneX();
		y = event.getSceneY();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		setHoverButton();
		setData();
		
		buttonCancel.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				Node node = (Node) arg0.getSource();
				Stage stage = (Stage) node.getScene().getWindow();
				stage.close();

			}
		});

	}

	TaiSanModel model = Tab1BottomController.getClickedRow();
	

	public void setData() {
		
		textFieldTen.setText(model.getTen());
		textFieldHienTrang.setText(model.getHienTrang());
		textFieldSoLuong.setText(String.valueOf(model.getSoLuong()));
	}
	

	

}
