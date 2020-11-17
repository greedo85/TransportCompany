

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
    private Button button5;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private BorderPane borderPane;
    private HBox hBox;
    private Scene scene;
    private VBox vBoxDriver;
    private VBox vBoxCar;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private Text text;
    private TextArea textArea;
    TransportCompany transportCompany;

    public GUI() {
        transportCompany = new TransportCompany();
        hBox = addHbox();
        vBoxDriver = addDriverVbox();
        vBoxCar = addCarVbox();
        //dodajemy layout
        borderPane = new BorderPane();
        textArea = new TextArea();
        textArea.setMaxWidth(380);
        //ustawiamy elementy layoutu
        borderPane.setTop(hBox);
        borderPane.setLeft(vBoxDriver);
        borderPane.setCenter(vBoxCar);
        borderPane.setRight(textArea);
    }

    @Override
    public void start( Stage stage ) throws Exception {
        stage.setTitle("Transport Company");
        scene = new Scene(borderPane, 670, 400);
        stage.setScene(scene);
        stage.show();
        button1.setOnAction(driver -> {
            transportCompany.addCarDriver(new CarDriver(textField1.getText(), textField2.getText(), textField3.getText()));
            if (true) {
                textArea.appendText("Dodałem kierowcę");
            }
        });
        button2.setOnAction(x -> clearTextArea());
        button3.setOnAction(x -> setTextArea(transportCompany.getCarDriverHashSet()));
        button4.setOnAction(car -> {
            transportCompany.addCar(new Car(textField4.getText()));
            if (true) {
                textArea.appendText("Dodałem samochód");
            }

        });
        button5.setOnAction(c -> setTextArea(transportCompany.getCarHashSet()));
    }

    public HBox addHbox() {
        text = new Text("Dodaj:");
        text.setFont(Font.font(14));
        button3 = new Button("Pokaż kierowców");
        button5 = new Button("Pokaż samochody");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10.0);
        hBox.setStyle("-fx-background-color: #336688;");
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll(button3, button5);
        return hBox;
    }

    public VBox addDriverVbox() {
        text = new Text("Dodaj kierowcę:");
        text.setFont(Font.font(14));
        label1 = new Label("Podaj imię:");
        label2 = new Label("Podaj nazwisko:");
        label3 = new Label("Podaj PESEL:");
        button1 = new Button("Dodaj kierowcę");
        button2 = new Button("Wyczyść textArea");
        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        VBox vBoxDriver = new VBox();
        vBoxDriver.setPrefWidth(50);
        vBoxDriver.setPadding(new Insets(10));
        vBoxDriver.setSpacing(5.0);
        vBoxDriver.getChildren().addAll(text, label1, textField1, label2, textField2, label3, textField3, button1, button2);
        return vBoxDriver;
    }

    public VBox addCarVbox() {
        text = new Text("Dodaj Samochód:");
        text.setFont(Font.font(14));
        label4 = new Label("Podaj Markę:");
        button4 = new Button("Dodaj Samochód");
        textField4 = new TextField();
        textField5 = new TextField();
        textField6 = new TextField();
        VBox vBoxCar = new VBox();
        vBoxCar.setMaxWidth(50);
        vBoxCar.setPadding(new Insets(10));
        vBoxCar.setSpacing(5.0);
        vBoxCar.getChildren().addAll(text, label4, textField4, button4);
        return vBoxCar;
    }

    public void setTextArea( Collection collection ) {
        textArea.clear();
        if (text != null) {
            textArea.appendText(collection + "\n");
        }
    }

    public void clearTextArea() {
        textArea.clear();
    }
}
