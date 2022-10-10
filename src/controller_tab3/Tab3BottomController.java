package controller_tab3;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.DangKyModel;
import application.model.HoatDongModel;
import application.model.Singleton;
import controller_tab2.Tab2BottomController;
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

public class Tab3BottomController implements Initializable{
	@FXML
	private TableView<DangKyModel> tableView;
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
	@FXML
	private TableColumn<String, String> column9;
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;

	private static DangKyModel clickedRow;

	public static DangKyModel getClickedRow() {
		return clickedRow;
	}

	public static void setClickedRow(DangKyModel clickedRow) {
		Tab3BottomController.clickedRow = clickedRow;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Hello1");
		buttonAdd.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Hello");
				showPopup("/controller_tab3/add/AddInfor3Layout.fxml", false, "Thêm Đăng Ký").show();
			}
		});
		buttonUpdate.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Hello");
				showPopup("/controller_tab3/update/UpdateInfor3Layout.fxml", false, "Sửa Đăng Ký").show();
			}
		});
		loadData();
		getDataRow();

	}
	List<DangKyModel> list = new ArrayList<DangKyModel>();
	public void loadData() {
		
		DangKyModel model = new DangKyModel(1L, false, new Date(System.currentTimeMillis()), "admin", null, "", "Đăng Ký Tổ Chức Đám Cưới","Nguyễn Văn A",500000,"0999746356");
		list.add(model);
		DangKyModel model1 = new DangKyModel(2L, false, new Date(System.currentTimeMillis()), "admin", null, "", "Đăng Ký Tổ Chức Sự Kiện","Nguyên Văn B",600000,"0789675444");
		list.add(model1);
		
		column1.setCellValueFactory(new PropertyValueFactory<>("id"));
		column2.setCellValueFactory(new PropertyValueFactory<>("ten"));
		column3.setCellValueFactory(new PropertyValueFactory<>("tenNguoiDangKy"));
		column4.setCellValueFactory(new PropertyValueFactory<>("phi"));
		column5.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
		column6.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
		column7.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
		column8.setCellValueFactory(new PropertyValueFactory<>("updatedDate"));
		column9.setCellValueFactory(new PropertyValueFactory<>("updatedBy"));

		final ObservableList<DangKyModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);

	}

	public void refresh() {
		System.out.println("REFRESH OK");
		list = Singleton.getInstance().getList2();
		System.out.println("list:" + list.size());
		final ObservableList<DangKyModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);

		Platform.runLater(() -> tableView.refresh());

	}

	public Stage showPopup(String view, boolean resize, String name) {
		FXMLLoader loader;
		Stage dialog = null;
		try {
			loader = new FXMLLoader(getClass().getResource(view));
			System.out.println("view = " + view.toString());
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
		List<HoatDongModel> list = Singleton.getInstance().getList1();
		tableView.setRowFactory(tv -> {
			TableRow<DangKyModel> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					Tab3BottomController.clickedRow = row.getItem();
					System.out.println("Model : " + Tab2BottomController.getClickedRow().toString());

				}
			});
			return row;
		});
	}


}
