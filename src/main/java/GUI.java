

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.util.Collection;


public class GUI extends Application {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Label label1;
    private Label label2;
    private Label label3;
    private BorderPane borderPane;
    private HBox hBox;
    private Scene scene;
    private VBox vBox;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private Text text;
    private TextArea textArea;
    TransportCompany transportCompany;
    public GUI() {
        transportCompany=new TransportCompany();
        hBox = addHbox();
        vBox = addVbox();
        //dodajemy layout
        borderPane = new BorderPane();
        textArea = new TextArea();
        //ustawiamy elementy layoutu
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);
        borderPane.setCenter(textArea);
    }

    @Override
    public void start( Stage stage ) throws Exception {
        stage.setTitle("Transport Company");
        scene = new Scene(borderPane, 400, 500);
        stage.setScene(scene);
        stage.show();
        button1.setOnAction(x -> transportCompany.addCarDriver(new CarDriver (textField1.getText(),textField2.getText(),textField3.getText())));
        button2.setOnAction(x -> clearTextArea());
        button3.setOnAction(x-> setTextArea(transportCompany.getCarDriverList()));
    }

    public HBox addHbox() {
        text = new Text("To jest Hbox");
        text.setFont(Font.font(14));
        button3=new Button("Pokaż kierowców");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10.0);
        hBox.setAlignment(Pos.BASELINE_LEFT);
        hBox.getChildren().addAll(button3);
        return hBox;
    }

    public VBox addVbox() {
        text = new Text("To jest Vbox");
        text.setFont(Font.font(14));
        label1 = new Label("Podaj imię:");
        label2 = new Label("Podaj nazwisko:");
        label3 = new Label("Podaj PESEL:");
        button1 = new Button("Dodaj kierowcę");
        button2 = new Button("Wyczyść textArea");
        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(5.0);
        vBox.getChildren().addAll(text, label1,textField1,label2,textField2, label3,textField3, button1, button2);
        return vBox;
    }

    public void setTextArea( Collection collection ) {
        textArea.clear();
        if (text != null) {
            textArea.appendText(collection+ "\n");
        }
    }

    public void clearTextArea() {
        textArea.clear();
    }
}
