package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import transportcompany.Car;
import transportcompany.CarDriver;
import transportcompany.JDBC;

@Getter
public class GUITableElements extends JDBC {

    private TableColumn<Car, String> brandTable, plateTable;
    private TableColumn<Car, Integer> carIdTable;
    private TableColumn<CarDriver, String> nameTable, surnameTable, peselTable;
    private TableColumn<CarDriver,Integer> driverIdTable;
    private ObservableList<Car> carData;
    private ObservableList<CarDriver> driverData;
    private TableView<Car> carTableView;
    private TableView<CarDriver> carDriverTableView;

    public GUITableElements() {

        carData = getCarData();
        driverData = getDriverData();
        addCarTable();
        addDriverTable();
        carTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        carDriverTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public ObservableList<Car> getCarData() {
        ObservableList<Car> cars = FXCollections.observableArrayList();
        cars.addAll(getCarsFromDB());
        return cars;
    }

    public ObservableList<CarDriver> getDriverData() {
        ObservableList<CarDriver> drivers = FXCollections.observableArrayList();
        drivers.addAll(getDriversFromDB());
        return drivers;
    }

    public TableView<CarDriver> addDriverTable() {
        driverIdTable =new TableColumn<>("ID");
        driverIdTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTable = new TableColumn<>("Imię");
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameTable = new TableColumn<>("Nazwisko");
        surnameTable.setCellValueFactory(new PropertyValueFactory<>("surname"));
        peselTable = new TableColumn<>("PESEL");
        peselTable.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        carDriverTableView = new TableView<>();
        carDriverTableView.setEditable(true);
        carDriverTableView.setPrefSize(300, 200);
        carDriverTableView.setItems(driverData);
        carDriverTableView.getColumns().addAll(driverIdTable, nameTable, surnameTable, peselTable);
        return carDriverTableView;
    }

    public TableView<Car> addCarTable() {
        carIdTable = new TableColumn<>("ID");
        carIdTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        brandTable = new TableColumn<>("Marka");
        brandTable.setCellValueFactory(new PropertyValueFactory<>("brand"));
        plateTable = new TableColumn<>("Nr rejestracyjny");
        plateTable.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));
        carTableView = new TableView<>();
        carTableView.setEditable(true);
        carTableView.setPrefSize(300, 200);
        carTableView.setItems(carData);
        carTableView.getColumns().addAll(carIdTable, brandTable, plateTable);
        return carTableView;
    }
}
