package controller_tab2.add;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.model.Singleton;
import application.model.TaiSanModel;
import controller_tab1.Tab1Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddInfor2Controller implements Initializable {
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
		buttonOK.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				save();
				Stage stage = (Stage) buttonOK.getScene().getWindow();
				// do what you have to do
				stage.close();

			}
		});
//		loadData();
	}

	

	public TaiSanModel getDataAdd() {
		TaiSanModel model = new TaiSanModel(1L, false, new Date(System.currentTimeMillis()), "admin",
				new Date(System.currentTimeMillis()), "", textFieldTen.getText(), textFieldHienTrang.getText(),
				Integer.valueOf(textFieldSoLuong.getText()));
		return model;
	}

	public void save() {
		List<TaiSanModel> list = Singleton.getInstance().getList();
		list.add(getDataAdd());

		Singleton.getInstance().setList(list);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller_tab1/Tab1BottomLayout1"));
		try {
			Parent root = loader.load();
			Tab1Controller.getTab1BottomController().refresh();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//
//	public void setHoverButton() {
//		buttonOK.setOnMouseEntered(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				buttonOK.setStyle(CSSFinal.HOVERED_BUTTON_OK);
//
//			}
//		});
//		buttonOK.setOnMouseExited(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				buttonOK.setStyle(CSSFinal.IDLE_BUTTON_OK);
//
//			}
//		});
//
//		buttonCancel.setOnMouseEntered(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				buttonCancel.setStyle(CSSFinal.HOVERED_BUTTON_CANCEL);
//
//			}
//		});
//		buttonCancel.setOnMouseExited(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				buttonCancel.setStyle(CSSFinal.IDLE_BUTTON_CANCEL);
//
//			}
//		});
//	}
//
//	public void autoSetOnCLickOK() {
//		textFieldId.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//
//		textFieldFullname.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldYearOfBirth.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		comboBoxGender.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldCurrentJob.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//		textFieldSchool.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldSubject.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldClasses.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldTime.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldPersonalId.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//
//		textFieldAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//		textFieldPhoneNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//		textFieldNote.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent key) {
//				if (key.getCode() == KeyCode.ENTER) {
//					setOnClickOK();
//				}
//
//			}
//		});
//	}
//
//	public void setOnClickOK() {
//		if (textFieldId.getText().equals("") || textFieldFullname.getText().equals("")
//				|| textFieldYearOfBirth.getText().equals("") || comboBoxGender.getValue().toString().equals("")
//				|| textFieldCurrentJob.getText().equals("") || textFieldSchool.getText().equals("")
//				|| textFieldSubject.getText().equals("") || textFieldClasses.getText().equals("")
//				|| textFieldArea.getText().equals("") || textFieldTime.getText().equals("")
//				|| textFieldPersonalId.getText().equals("") || textFieldAddress.getText().equals("")
//				|| textFieldPhoneNumber.getText().equals("") || textFieldNote.getText().equals("")) {
//			showPopup("/tabquanly/tabgiasu/addgiasu/AlertAddGiaSu.fxml", false).show();
//		}else {
//			save();
//			Stage stage = (Stage) buttonOK.getScene().getWindow();
//			// do what you have to do
//			stage.close();
//		}
//		
//	}
//	
//
//	public void setOnClick() {
//		buttonOK.setOnMouseClicked(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				setOnClickOK();
//				
//			}
//		});
//		buttonCancel.setOnMouseClicked(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event arg0) {
//				Node node = (Node) arg0.getSource();
//				Stage stage = (Stage) node.getScene().getWindow();
//				stage.close();
//
//			}
//		});
//	}
//	public Stage showPopup(String view,boolean resize) {
//		FXMLLoader loader;
//		Stage dialog = null;
//		try {
//			loader = new FXMLLoader(getClass().getResource(view));
//			System.out.println("view = "+view.toString());
//			Parent secondUI = loader.load();
//			Scene scene = new Scene(secondUI);
//			dialog = new Stage();
//			dialog.setResizable(resize);
//			scene.getStylesheets().add(getClass().getResource("/tabGiaSu.css").toExternalForm());
//			dialog.setScene(scene);
//			dialog.initModality(Modality.WINDOW_MODAL);
////			dialog.initStyle(StageStyle.TRANSPARENT);
////			dialog.setIconified(true);
//
//			dialog.setAlwaysOnTop(true);
//			dialog.setOnCloseRequest(new EventHandler<WindowEvent>() {
//				@Override
//				public void handle(WindowEvent arg0) {
//
//				}
//			});
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return dialog;
//
//	}
}
