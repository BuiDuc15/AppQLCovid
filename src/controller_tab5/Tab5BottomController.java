package controller_tab5;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.KhaiBaoDichTeModel;
import application.model.Singleton;
import application.model.ThongTinCachLyModel;
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

public class Tab5BottomController implements Initializable {
	@FXML
	private TableView<ThongTinCachLyModel> tableView;
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
	
	List<ThongTinCachLyModel> list = new ArrayList<ThongTinCachLyModel>();
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;
	private static ThongTinCachLyModel clickedRow;
	
	public static ThongTinCachLyModel getClickedRow() {
		return clickedRow;
	}
	public static void setClickedRow(ThongTinCachLyModel clickedRow) {
		Tab5BottomController.clickedRow = clickedRow;
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
		List<ThongTinCachLyModel> list = new ArrayList<ThongTinCachLyModel>();
		ThongTinCachLyModel model = new ThongTinCachLyModel(1L, false, new Date(System.currentTimeMillis()), "admin", null, "","Lê Anh Đào", new Date(System.currentTimeMillis()),"F4",true);
		ThongTinCachLyModel model1 = new ThongTinCachLyModel(2L, false, new Date(System.currentTimeMillis()), "admin", null, "","Nguyễn Kim Phươngg",  new Date(System.currentTimeMillis()),"F3",true);
		ThongTinCachLyModel model2 = new ThongTinCachLyModel(3L, false, new Date(System.currentTimeMillis()), "admin", null, "","Lê Thái An",  new Date(System.currentTimeMillis()),"F5",true);
		ThongTinCachLyModel model3 = new ThongTinCachLyModel(4L, false, new Date(System.currentTimeMillis()), "admin", null, "","Quách Trọng Đạt", new Date(System.currentTimeMillis()),"F2",true);
		list.add(model);
		list.add(model1);
		list.add(model2);
		list.add(model3);
//		TaiSanModel model = new TaiSanModel(1L,false,new Date(System.currentTimeMillis()),"admin",null,"","Ghế","Còn",100);
//		list.add(model);
//		TaiSanModel model1 = new TaiSanModel(2L,false,new Date(System.currentTimeMillis()),"admin",null,"","Bàn","Còn",150);
//		list.add(model1);
//		TaiSanModel model2 = new TaiSanModel(3L,false,new Date(System.currentTimeMillis()),"admin",null,"","Quạt","Còn",20);
//		list.add(model2);
//		TaiSanModel model3 = new TaiSanModel(4L,false,new Date(System.currentTimeMillis()),"admin",null,"","Loa","Còn",10);
//		list.add(model3);
//		TaiSanModel model4 = new TaiSanModel(5L,false,new Date(System.currentTimeMillis()),"admin",null,"","Ti Vi","Còn",5);
//		list.add(model4);
		column1.setCellValueFactory(new PropertyValueFactory<>("id"));
		column2.setCellValueFactory(new PropertyValueFactory<>("ten"));
		column3.setCellValueFactory(new PropertyValueFactory<>("thoiGianBatDau"));
		column4.setCellValueFactory(new PropertyValueFactory<>("mucDoCachLy"));
		column5.setCellValueFactory(new PropertyValueFactory<>("tested"));
		column6.setCellValueFactory(new PropertyValueFactory<>("updatedDate"));
		column7.setCellValueFactory(new PropertyValueFactory<>("updatedBy"));
		
		

		final ObservableList<ThongTinCachLyModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);
		
	}
	public void refresh() {
		System.out.println("REFRESH OK");
		list = Singleton.getInstance().getList4();
		System.out.println("list:" + list.size());
		final ObservableList<ThongTinCachLyModel> data = FXCollections.observableArrayList(list);
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
		List<ThongTinCachLyModel> list = Singleton.getInstance().getList4();
		tableView.setRowFactory(tv -> {
			TableRow<ThongTinCachLyModel> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					Tab5BottomController.clickedRow = row.getItem();
					System.out.println("Model : "+Tab5BottomController.getClickedRow().toString());
					
				}
			});
			return row;
		});
	}

}
