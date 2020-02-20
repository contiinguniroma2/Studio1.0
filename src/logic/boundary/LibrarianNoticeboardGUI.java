package logic.boundary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.entity.Post;

public class LibrarianNoticeboardGUI extends LibrarianGUI {

	TableView<Post> tableNoticeboard;
	TextField titoloPost;
	TextField contenutoPost;
	TextField dataPost;
	Button add;
	Button del;

	public ObservableList<Post> getPost() {
		ObservableList<Post> avvisi = FXCollections.observableArrayList();
		avvisi.add(new Post("Chiusura", "bib1@live.it", "La biblioteca restera' chiusa il giorno 7/5/2020.",
				"27 09 2016"));
		avvisi.add(new Post("Bagno", "bib2@live.it", "Bagno piano terra inagibile.", "07 05 2016"));
		avvisi.add(new Post("Servizi", "bib3@live.it", "Da oggi e' attivo il servizio bar.", "17 03 2016"));
		avvisi.add(new Post("Prenotazioni", "bib4@live.it", "E' attivo il servizio prenotazioni.", "02 01 2016"));
		return avvisi;
	}

	@SuppressWarnings("unchecked")
	public void createLibrarianNoticeboardGUI(Main main) {

		Label titleNoticeboard = createLabel("Notice board", 24);

		TableColumn<Post, String> titoloCol = new TableColumn<>("Titolo");
		titoloCol.setMinWidth(100);
		titoloCol.setCellValueFactory(new PropertyValueFactory<>("title"));

		TableColumn<Post, String> contenutoCol = new TableColumn<>("Post");
		contenutoCol.setMinWidth(463);
		contenutoCol.setCellValueFactory(new PropertyValueFactory<>("testo"));

		TableColumn<Post, String> dataCol = new TableColumn<>("Data");
		dataCol.setMinWidth(50);
		dataCol.setCellValueFactory(new PropertyValueFactory<>("data"));

		titoloPost = new TextField();
		titoloPost.setPromptText("Titolo");
		titoloPost.setPrefWidth(100);

		contenutoPost = new TextField();
		contenutoPost.setPromptText("Contenuto");
		contenutoPost.setPrefWidth(311);

		dataPost = new TextField();
		dataPost.setPromptText("Data");
		dataPost.setPrefWidth(100);

		add = new Button("Add");
		add.setOnAction(e -> addClicked());

		del = new Button("Del");
		del.setOnAction(e -> delClicked());

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(titoloPost, contenutoPost, dataPost, add, del);

		tableNoticeboard = new TableView<>();
		tableNoticeboard.setItems(getPost());
		tableNoticeboard.getColumns().addAll(titoloCol, contenutoCol, dataCol);

		VBox vboxNoticeboard = new VBox();
		vboxNoticeboard.getChildren().addAll(titleNoticeboard, tableNoticeboard, hbox);
		vboxNoticeboard.setAlignment(Pos.CENTER);
		vboxNoticeboard.setPadding(new Insets(20, 20, 20, 20));

		root = (BorderPane) main.getScene().getRoot();
		root.setCenter(vboxNoticeboard);
		main.getScene().setRoot(root);

	}

	private void delClicked() {
		ObservableList<Post> postSelected;
		ObservableList<Post> allAvvisi;
		allAvvisi = tableNoticeboard.getItems();
		postSelected = tableNoticeboard.getSelectionModel().getSelectedItems();
		postSelected.forEach(allAvvisi::remove);
	}

	private void addClicked() {
		Post post = new Post();
		post.setTitle(titoloPost.getText());
		post.setTesto(contenutoPost.getText());
		post.setData(dataPost.getText());
		tableNoticeboard.getItems().add(post);
		titoloPost.clear();
		contenutoPost.clear();
		dataPost.clear();
	}

}
