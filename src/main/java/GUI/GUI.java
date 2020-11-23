package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import transportcompany.Car;
import transportcompany.CarDriver;


public class GUI extends Application {

    private TextArea textArea;
    private TableElements tableElements;
    private Scene scene;
    private BorderPane borderPane;


    public GUI() {
        System.out.println("Konstruktor GUI");

        tableElements = new TableElements();

        //dodajemy layout
        borderPane = new BorderPane();
        textArea = new TextArea();
        textArea.setMaxWidth(670);
        //ustawiamy elementy layoutu
        borderPane.setTop(tableElements.getHBox());
        borderPane.setLeft(tableElements.getVBoxDriver());
        borderPane.setCenter(tableElements.getVBoxCar());
        borderPane.setBottom(textArea);
    }

    @Override
    public void start( Stage stage ) {
        stage.setTitle("Transport Company");
        scene = new Scene(borderPane, 670, 500);
        stage.setScene(scene);
        stage.show();
        tableElements.getAddDriverButton().setOnAction(driver -> {

            if (tableElements.addCarDriver(new CarDriver(
                    tableElements.getTextField1().getText(), tableElements.getTextField2().getText(),tableElements.getTextField3().getText()))) {
                textArea.appendText("Dodałem kierowcę");
            } else
                textArea.appendText("Nie mogę dodać kierowcy, już istnieje");

        });
       tableElements.getAddCarButton().setOnAction(car -> {
            if ((tableElements.addCar(new Car(tableElements.getTextField4().getText(), tableElements.getTextField5().getText())))) {
                textArea.appendText("Dodałem samochód");
            } else
                textArea.appendText("Nie mogę dodać samochodu");

        });
       tableElements.getClearTextAreaButton().setOnAction(x -> clearTextArea());
       tableElements.getShowDriverInTableButton().setOnAction(x -> borderPane.setRight(tableElements.getCarDriverTableView()));
       tableElements.getShowCarsInTable().setOnAction(c -> borderPane.setRight(tableElements.getCarTableView()));

    }


   /* public void setTextArea( Collection collection ) {
        textArea.clear();
        if (text != null) {
            textArea.appendText(collection + "\n");
        }
    }*/

    public void clearTextArea() {
        textArea.clear();
    }
}
