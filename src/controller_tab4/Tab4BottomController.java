package controller_tab4;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.KhaiBaoDichTeModel;
import application.model.Singleton;
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

public class Tab4BottomController implements Initializable {
	@FXML
	private TableView<KhaiBaoDichTeModel> tableView;
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
	
	List<KhaiBaoDichTeModel> list = new ArrayList<KhaiBaoDichTeModel>();
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;
	private static KhaiBaoDichTeModel clickedRow;
	
	public static KhaiBaoDichTeModel getClickedRow() {
		return clickedRow;
	}
	public static void setClickedRow(KhaiBaoDichTeModel clickedRow) {
		Tab4BottomController.clickedRow = clickedRow;
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
		List<KhaiBaoDichTeModel> list = new ArrayList<KhaiBaoDichTeModel>();
		KhaiBaoDichTeModel model = new KhaiBaoDichTeModel(1L, false, new Date(System.currentTimeMillis()), "admin", null, "","Lê Thế Công", "Bình Thường");
		KhaiBaoDichTeModel model1 = new KhaiBaoDichTeModel(2L, false, new Date(System.currentTimeMillis()), "admin", null, "","Nguyễn Kim Anh", "Bình Thường");
		KhaiBaoDichTeModel model2 = new KhaiBaoDichTeModel(3L, false, new Date(System.currentTimeMillis()), "admin", null, "","Lê Quốc Anh", "Bình Thường");
		KhaiBaoDichTeModel model3 = new KhaiBaoDichTeModel(4L, false, new Date(System.currentTimeMillis()), "admin", null, "","Phạm Đình Dũng", "Bình Thường");
		list.add(model);
		list.add(model1);
		list.add(model2);
		list.add(model3);
		column1.setCellValueFactory(new PropertyValueFactory<>("id"));
		column2.setCellValueFactory(new PropertyValueFactory<>("ten"));
		column3.setCellValueFactory(new PropertyValueFactory<>("trangThaiSucKhoe"));
		column4.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
		column5.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
		column6.setCellValueFactory(new PropertyValueFactory<>("updatedDate"));
		column7.setCellValueFactory(new PropertyValueFactory<>("updatedBy"));
		
		

		final ObservableList<KhaiBaoDichTeModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);
		
	}
	public void refresh() {
		System.out.println("REFRESH OK");
		list = Singleton.getInstance().getList3();
		System.out.println("list:" + list.size());
		final ObservableList<KhaiBaoDichTeModel> data = FXCollections.observableArrayList(list);
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
		List<KhaiBaoDichTeModel> list = Singleton.getInstance().getList3();
		tableView.setRowFactory(tv -> {
			TableRow<KhaiBaoDichTeModel> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					Tab4BottomController.clickedRow = row.getItem();
					System.out.println("Model : "+Tab4BottomController.getClickedRow().toString());
					
				}
			});
			return row;
		});
	}

}
