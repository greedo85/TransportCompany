package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import lombok.Getter;

@Getter
public class BoxElements{

    private Button addDriverButton, clearTextAreaButton, showDriverInTableButton, addCarButton, showCarsInTable;
    private Label label1, label2, label3, label4, label5;
    private HBox hBox;
    private VBox vBoxDriver, vBoxCar;
    private TextField textField1, textField2, textField3, textField4, textField5, textField6;
    private Text text;

    public BoxElements() {
        label1 = new Label("Podaj imię:");
        label2 = new Label("Podaj nazwisko:");
        label3 = new Label("Podaj PESEL:");
        addDriverButton = new Button("Dodaj kierowcę");
        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        label4 = new Label("Podaj Markę:");
        label5 = new Label("Podaj nr rejestracyjny");
        addCarButton = new Button("Dodaj Samochód");
        textField4 = new TextField();
        textField5 = new TextField();
        textField6 = new TextField();
        hBox = addUpperHbox();
        vBoxCar = getCarVbox();
        vBoxDriver = getDriverVbox();

    }

    public HBox addUpperHbox() {
        text = new Text("Dodaj:");
        text.setFont(Font.font(14));
        showDriverInTableButton = new Button("Pokaż kierowców");
        showCarsInTable = new Button("Pokaż samochody");
        clearTextAreaButton = new Button("Wyczyść textArea");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10.0);
        hBox.setStyle("-fx-background-color: #336688;");
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll(showDriverInTableButton, showCarsInTable, clearTextAreaButton);
        return hBox;
    }

    public VBox getDriverVbox() {
        text = new Text("Dodaj kierowcę:");
        text.setFont(Font.font(14));
        VBox vBoxDriver = new VBox();
        vBoxDriver.setPrefWidth(50);
        vBoxDriver.setPadding(new Insets(10));
        vBoxDriver.setSpacing(5.0);
        vBoxDriver.getChildren().addAll(text, label1, textField1, label2, textField2, label3, textField3, addDriverButton);
        return vBoxDriver;
    }

    public VBox getCarVbox() {
        text = new Text("Dodaj Samochód:");
        text.setFont(Font.font(14));
        VBox vBoxCar = new VBox();
        vBoxCar.setMaxWidth(50);
        vBoxCar.setPadding(new Insets(10));
        vBoxCar.setSpacing(5.0);
        vBoxCar.getChildren().addAll(text, label4, textField4, label5, textField5, addCarButton);
        return vBoxCar;
    }
}
