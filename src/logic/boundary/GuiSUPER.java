package logic.boundary;

import java.io.File;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.control.LibraryMainPageController;
import logic.control.LoginController;

public class GuiSUPER {
	static Logger myLogger = Logger.getLogger("logger");
	public static final String PROJ_NAME = "Stud.io";
	public static final String START = "StartGUI";
	public static final String LOGIN = "LoginGUI";
	public static final String REGISTRATION = "RegistrationGUI";
	public static final String STUDENT = "StudentGUI";
	public static final String NOTIFIEDSTUDENT = "StudentNotifiedGUI";
	public static final String BANNEDSTUDENT = "StudentBannedGUI";
	public static final String LIBRARIAN = "LibrarianGUI";
	public static final String GUEST = "GuestGUI";
	public static final String REG_STUD_SETTINGS = "RegStudentSettingsGUI";
	public static final String REG_LIBR_SETTINGS = "RegLibrarianSettingsGUI";

	protected GuiSUPER() {

	}

	public static void leftPadding(VBox panel, int padding) {
		panel.setPadding(new Insets(0, 0, 0, padding));
	}

	public static void leftVPadding(VBox vPanel, int padding) {
		vPanel.setPadding(new Insets(0, 0, 0, padding));
	}

	public static void leftHPadding(HBox hPanel) {
		hPanel.setPadding(new Insets(0, 0, 0, 20));
	}

	public static VBox createPanel(Node... nodes) {
		VBox panel = new VBox();
		for (Node next : nodes)
			panel.getChildren().add(next);
		panel.setAlignment(Pos.CENTER);
		panel.setMaxWidth(250);
		panel.setSpacing(10);
		return panel;
	}

	public static HBox createTopPanel(Node btn, String title) {
		Label titleLabel = new Label(title);
		HBox topPanel = new HBox();
		topPanel.getChildren().addAll(btn, titleLabel);
		topPanel.setPrefWidth(760);
		topPanel.setPrefHeight(50);
		topPanel.setSpacing(20);
		topPanel.setAlignment(Pos.CENTER_LEFT);
		HBox.setMargin(btn, new Insets(0, 0, 0, 20));
		topPanel.setStyle("-fx-background-color: #52be8c;");
		return topPanel;
	}

	public static HBox createLibrTopPanel() {
		HBox top = new HBox();
		ImageView img = createImg("src/resources/libraryIcon.png");
		img.prefWidth(100);
		VBox titles = createPanel(new Label(LoginController.getLoginController().getLibrary().getName()),
				new Label(LoginController.getLoginController().getLibrary().getIndirizzo()),
				new Label(LoginController.getLoginController().getLibrary().getMail()),
				new Label(LoginController.getLoginController().getLibrary().getPhone()));
		titles.setPadding(new Insets(0, 0, 0, 20));
		titles.setStyle("-fx-font-size: 14");
		titles.setSpacing(0);
		titles.setAlignment(Pos.CENTER_LEFT);
		top.getChildren().addAll(createPanel(img), titles);
		leftHPadding(top);
		top.setPrefWidth(600);
		top.setPrefHeight(100);
		top.setStyle("-fx-background-color: #52be8c;");
		return top;
	}

	public static Button createBtn(String nameBtn) {
		Button btn = new Button(nameBtn);
		btn.setPrefWidth(100);
		btn.setPrefHeight(20);
		return btn;
	}

	public static ImageView createImg(String nameImg) {
		File file = new File(nameImg);
		ImageView imageW = new ImageView();
		Image image = new Image(file.toURI().toString());
		imageW.setImage(image);
		imageW.prefWidth(100);
		imageW.prefHeight(100);
		return imageW;
	}

	/*
	 * setta altezza button a 100
	 */
	public static void setHeightBtn(Button nameBtn, int height) {
		nameBtn.setPrefHeight(height);
	}

	/*
	 * crea label della dimensione specificata in size, con padding bottom 20
	 */
	public static Label createLabel(String title, int size) {
		Label lbl = new Label(title);
		lbl.setStyle("-fx-font: " + size + " arial;");
		lbl.setPadding(new Insets(0, 0, 20, 0));
		return lbl;
	}

	/*
	 * Metodo che crea textfield della larghezza specificata (inserendo una stringa
	 * come parametro in TextField, essa viene inizializzata con una stringa)
	 */
	public static TextField createTextField(int width) {
		TextField txtFld = new TextField();
		txtFld.setAlignment(Pos.CENTER);
		txtFld.setPrefWidth(width);
		return txtFld;
	}

	/*
	 * Metodo per creare una riga composta da label e button
	 */
	public static HBox createLabelWithBtn(String nomeLabel, String typeBtn) {
		HBox panel = new HBox();
		panel.setPrefWidth(300);
		Button btn = new Button();
		btn.setPrefSize(30, 40);
		Button lbl = new Button(nomeLabel);
		lbl.setPrefSize(300, 40);
		if (typeBtn.equals("del")) {
			btn.setGraphic(createImg("src/resources/delete.png"));
		}
		if (typeBtn.equals("reply")) {
			btn.setGraphic(createImg("src/resources/reply.png"));
		} else myLogger.info("Errore passaggio parametro typeBtn "
					+ "a metodo createLabelWithBtn(String nomeLabel, String typeBtn). Use 'del' or 'reply' ");
		panel.getChildren().addAll(lbl, btn);
		return panel;
	}

	public void setOnClick(Button btn, Main main, String string) {
		btn.setOnAction((event -> {
			try {
				main.setNewStage(string);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
	}

	public VBox loadPrefers() {
		Label title = createLabel("Prefers:", 24);

		ScrollPane scroll = new ScrollPane();

		VBox listFavourites = new VBox();
		listFavourites.setMinWidth(250);

		for (int j = 0; j < 10; j++) {
			HBox panel = new HBox();
			Button namePref = new Button("Favourite library " + j);
			namePref.setPrefSize(300, 40);
			Button delPref = new Button();
			delPref.setGraphic(createImg("src/resources/delete.png"));
			delPref.setPrefSize(30, 40);
			panel.getChildren().addAll(namePref, delPref);
			listFavourites.getChildren().add(panel);
		}

		scroll.setContent(listFavourites);
		scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		VBox content = new VBox();
		content.getChildren().addAll(title, scroll);
		content.setAlignment(Pos.CENTER);
		content.setMinWidth(365);
		content.setMaxHeight(300);
		return content;

	}

	public void setOnActionRefresh(Button btn, Main main) {
		btn.setOnAction((event -> {
			try {
				// VA RESETTATA LA PAGINA
				LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
				main.setNewStage(LIBRARIAN);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
	}

	public void setOnActionNoticeBoard(Button btn, Main main) {
		btn.setOnAction((event -> {
			try {

				new LibrarianNoticeboardGUI().createLibrarianNoticeboardGUI(main);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
	}

	public void setOnActionServices(Button btn, Main main) {
		btn.setOnAction((event -> {
			try {

				new LibrarianServicesGUI().createLibrarianServicesGUI(main);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
	}

}
