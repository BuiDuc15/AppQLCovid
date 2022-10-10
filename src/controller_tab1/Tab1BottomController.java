package controller_tab1;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.Singleton;
import application.model.TaiSanModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Tab1BottomController implements Initializable {
	@FXML
	private TableView<TaiSanModel> tableView;
	@FXML
	private TableColumn<String, String> column1;
	@FXML
	private TableColumn<String, String> column2;
	@FXML
	private TableColumn<String, String> column3;
	@FXML
	private TableColumn<String, String> column4;
	@FXML
	private TableColumn<String, String> column5;
	@FXML
	private TableColumn<String, String> column6;
	@FXML
	private TableColumn<String, String> column7;
	@FXML
	private TableColumn<String, String> column8;
	List<TaiSanModel> list = new ArrayList<TaiSanModel>();
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;
	private static TaiSanModel clickedRow;
	
	public static TaiSanModel getClickedRow() {
		return clickedRow;
	}
	public static void setClickedRow(TaiSanModel clickedRow) {
		Tab1BottomController.clickedRow = clickedRow;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Hello1");
		buttonAdd.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Hello");
				showPopup("/controller_tab1/add/AddInfor1Layout.fxml", false,"Thêm Thông Tin").show();
			}
		});
		buttonUpdate.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Hello");
				showPopup("/controller_tab1/update/UpdateInfor1Layout.fxml", false,"Sửa Thông Tin").show();
			}
		});
		loadData();
		getDataRow();
		
		
	}
	public void loadData() {
		List<TaiSanModel> list = new ArrayList<TaiSanModel>();
		TaiSanModel model = new TaiSanModel(1L,false,new Date(System.currentTimeMillis()),"admin",null,"","Ghế","Còn",100);
		list.add(model);
		TaiSanModel model1 = new TaiSanModel(2L,false,new Date(System.currentTimeMillis()),"admin",null,"","Bàn","Còn",150);
		list.add(model1);
		TaiSanModel model2 = new TaiSanModel(3L,false,new Date(System.currentTimeMillis()),"admin",null,"","Quạt","Còn",20);
		list.add(model2);
		TaiSanModel model3 = new TaiSanModel(4L,false,new Date(System.currentTimeMillis()),"admin",null,"","Loa","Còn",10);
		list.add(model3);
		TaiSanModel model4 = new TaiSanModel(5L,false,new Date(System.currentTimeMillis()),"admin",null,"","Ti Vi","Còn",5);
		list.add(model4);
		column1.setCellValueFactory(new PropertyValueFactory<>("id"));
		column2.setCellValueFactory(new PropertyValueFactory<>("ten"));
		column3.setCellValueFactory(new PropertyValueFactory<>("hienTrang"));
		column4.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
		column5.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
		column6.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
		column7.setCellValueFactory(new PropertyValueFactory<>("updatedDate"));
		column8.setCellValueFactory(new PropertyValueFactory<>("updatedBy"));
		

		final ObservableList<TaiSanModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);
		
	}
	public void refresh() {
		System.out.println("REFRESH OK");
		list = Singleton.getInstance().getList();
		System.out.println("list:" + list.size());
		final ObservableList<TaiSanModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);

		Platform.runLater(() -> tableView.refresh());

	}

	public Stage showPopup(String view,boolean resize,String name) {
		FXMLLoader loader;
		Stage dialog = null;
		try {
			loader = new FXMLLoader(getClass().getResource(view));
			System.out.println("view = "+view.toString());
			Parent secondUI = loader.load();
			Scene scene = new Scene(secondUI);
			dialog = new Stage();
			dialog.setResizable(resize);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			dialog.setScene(scene);
			dialog.initModality(Modality.WINDOW_MODAL);
//			dialog.initStyle(StageStyle.TRANSPARENT);
//			dialog.setIconified(true);
			dialog.setTitle(name);
			dialog.setAlwaysOnTop(true);
			dialog.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {

				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dialog;

	}
	public void getDataRow() {
		List<TaiSanModel> list = Singleton.getInstance().getList();
		tableView.setRowFactory(tv -> {
			TableRow<TaiSanModel> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					Tab1BottomController.clickedRow = row.getItem();
					System.out.println("Model : "+Tab1BottomController.getClickedRow().toString());
					
				}
			});
			return row;
		});
	}

}
