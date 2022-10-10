package controller_tab2;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.HoatDongModel;
import application.model.Singleton;
import application.model.TaiSanModel;
import controller_tab1.Tab1BottomController;
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

public class Tab2BottomController implements Initializable {
	@FXML
	private TableView<HoatDongModel> tableView;
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
	private Button buttonAdd;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;

	private static HoatDongModel clickedRow;

	public static HoatDongModel getClickedRow() {
		return clickedRow;
	}

	public static void setClickedRow(HoatDongModel clickedRow) {
		Tab2BottomController.clickedRow = clickedRow;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Hello1");
		buttonAdd.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Hello");
				showPopup("/controller_tab2/add/AddInfor2Layout.fxml", false, "Thêm Hoạt Động").show();
			}
		});
		buttonUpdate.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Hello");
				showPopup("/controller_tab2/update/UpdateInfor2Layout.fxml", false, "Sửa Hoạt Động").show();
			}
		});
		loadData();
		getDataRow();

	}
	List<HoatDongModel> list = new ArrayList<HoatDongModel>();
	public void loadData() {
		
		HoatDongModel model = new HoatDongModel(1L, false, new Date(System.currentTimeMillis()), "admin", null, "", "Đám Cưới");
		list.add(model);
		HoatDongModel model1 = new HoatDongModel(2L, false, new Date(System.currentTimeMillis()), "admin", null, "", "Đám Hỏi");
		list.add(model1);
		
		column1.setCellValueFactory(new PropertyValueFactory<>("id"));
		column2.setCellValueFactory(new PropertyValueFactory<>("ten"));
		
		column3.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
		column4.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
		column5.setCellValueFactory(new PropertyValueFactory<>("updatedDate"));
		column6.setCellValueFactory(new PropertyValueFactory<>("updatedBy"));

		final ObservableList<HoatDongModel> data = FXCollections.observableArrayList(list);
		tableView.getItems().clear();
		tableView.setItems(data);

	}

	public void refresh() {
		System.out.println("REFRESH OK");
		list = Singleton.getInstance().getList1();
		System.out.println("list:" + list.size());
		final ObservableList<HoatDongModel> data = FXCollections.observableArrayList(list);
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
			TableRow<HoatDongModel> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					Tab2BottomController.clickedRow = row.getItem();
					System.out.println("Model : " + Tab2BottomController.getClickedRow().toString());

				}
			});
			return row;
		});
	}

}
