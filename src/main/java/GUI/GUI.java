package GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import transportcompany.Car;
import transportcompany.CarDriver;
import transportcompany.TransportCompany;

import java.util.Collection;


public class GUI extends Application {

    private Button button1, button2, button3, button4, button5;
    private Label label1, label2, label3, label4, label5;
    private BorderPane borderPane;
    private HBox hBox;
    private Scene scene;
    private VBox vBoxDriver, vBoxCar;
    private TextField textField1, textField2, textField3, textField4, textField5, textField6;
    private Text text;
    private TextArea textArea;
    private TransportCompany transportCompany;
    private TableColumn<Car, String> brandTable, plateTable;
    private TableColumn<CarDriver, String> nameTable, surnameTable, peselTable;
    private ObservableList<Car> carData;
    private ObservableList<CarDriver> driverData;
    private TableView<Car> carTableView;
    private TableView<CarDriver> carDriverTableView;

    public GUI() {
        transportCompany = new TransportCompany();
        carData = getCarData();
        driverData = getDriverData();
        addDriverTable();
        addCarTable();
        hBox = addCarHbox();
        vBoxDriver = addDriverVbox();
        vBoxCar = addCarVbox();
        //dodajemy layout
        borderPane = new BorderPane();
        textArea = new TextArea();
        textArea.setMaxWidth(670);
        //ustawiamy elementy layoutu
        borderPane.setTop(hBox);
        borderPane.setLeft(vBoxDriver);
        borderPane.setCenter(vBoxCar);
        borderPane.setBottom(textArea);
    }

    @Override
    public void start( Stage stage ){
        stage.setTitle("Transport Company");
        scene = new Scene(borderPane, 670, 500);
        stage.setScene(scene);
        stage.show();
        button1.setOnAction(driver -> {

            if (transportCompany.addCarDriver(new CarDriver(textField1.getText(), textField2.getText(), textField3.getText()))) {
                textArea.appendText("Dodałem kierowcę");
            } else
                textArea.appendText("Nie mogę dodać kierowcy, już istnieje");

        });
        button2.setOnAction(x -> clearTextArea());
        button4.setOnAction(car -> {
            if (transportCompany.addCar(new Car(textField4.getText(), textField5.getText()))) {
                textArea.appendText("Dodałem samochód");
            } else
                textArea.appendText("Nie mogę dodać samochodu");

        });
        button3.setOnAction(x -> borderPane.setRight(carDriverTableView));
        button5.setOnAction(c -> borderPane.setRight(carTableView));
    }

    public HBox addCarHbox() {
        text = new Text("Dodaj:");
        text.setFont(Font.font(14));
        button3 = new Button("Pokaż kierowców");
        button5 = new Button("Pokaż samochody");
        button2 = new Button("Wyczyść textArea");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10.0);
        hBox.setStyle("-fx-background-color: #336688;");
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll(button3, button5, button2);
        return hBox;
    }

    public VBox addDriverVbox() {
        text = new Text("Dodaj kierowcę:");
        text.setFont(Font.font(14));
        label1 = new Label("Podaj imię:");
        label2 = new Label("Podaj nazwisko:");
        label3 = new Label("Podaj PESEL:");
        button1 = new Button("Dodaj kierowcę");

        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        VBox vBoxDriver = new VBox();
        vBoxDriver.setPrefWidth(50);
        vBoxDriver.setPadding(new Insets(10));
        vBoxDriver.setSpacing(5.0);
        vBoxDriver.getChildren().addAll(text, label1, textField1, label2, textField2, label3, textField3, button1);
        return vBoxDriver;
    }

    public VBox addCarVbox() {
        text = new Text("Dodaj Samochód:");
        text.setFont(Font.font(14));
        label4 = new Label("Podaj Markę:");
        label5 = new Label("Podaj nr rejestracyjny");
        button4 = new Button("Dodaj Samochód");
        textField4 = new TextField();
        textField5 = new TextField();
        textField6 = new TextField();
        VBox vBoxCar = new VBox();
        vBoxCar.setMaxWidth(50);
        vBoxCar.setPadding(new Insets(10));
        vBoxCar.setSpacing(5.0);
        vBoxCar.getChildren().addAll(text, label4, textField4, label5, textField5, button4);
        return vBoxCar;
    }

    public ObservableList<Car> getCarData() {
        ObservableList<Car> cars = FXCollections.observableArrayList();
        cars.addAll(transportCompany.getCarHashSet());
        return cars;
    }

    public ObservableList<CarDriver> getDriverData() {
        ObservableList<CarDriver> drivers = FXCollections.observableArrayList();
        drivers.addAll(transportCompany.getCarDriverHashSet());
        return drivers;
    }

    public void addDriverTable() {
        nameTable = new TableColumn<>("Imię");
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTable = new TableColumn<>("Nazwisko");
        surnameTable.setCellValueFactory(new PropertyValueFactory<>("surname"));
        peselTable = new TableColumn<>("PESEL");
        peselTable.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        carDriverTableView = new TableView<>();
        carDriverTableView.setEditable(true);
        carDriverTableView.setPrefSize(300,200);
        carDriverTableView.setItems(driverData);
        carDriverTableView.getColumns().addAll(nameTable, surnameTable, peselTable);
    }

    public void addCarTable() {
        brandTable = new TableColumn<>("Marka");
        brandTable.setCellValueFactory(new PropertyValueFactory<>("brand"));
        plateTable = new TableColumn<>("Nr rejestracyjny");
        plateTable.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));
        carTableView = new TableView<>();
        carTableView.setEditable(true);
        carTableView.setPrefSize(300,200);
        carTableView.setItems(carData);
        carTableView.getColumns().addAll(brandTable, plateTable);
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
