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
    private BoxElements boxElements;
    private Scene scene;
    private BorderPane borderPane;


    public GUI() {

        tableElements = new TableElements();
        boxElements=new BoxElements();

        //dodajemy layout
        borderPane = new BorderPane();
        textArea = new TextArea();
        textArea.setMaxWidth(670);
        //ustawiamy elementy layoutu
        borderPane.setTop(boxElements.getHBox());
        borderPane.setLeft(boxElements.getVBoxDriver());
        borderPane.setCenter(boxElements.getVBoxCar());
        borderPane.setBottom(textArea);
    }

    @Override
    public void start( Stage stage ) {
        stage.setTitle("Transport Company");
        scene = new Scene(borderPane, 670, 500);
        stage.setScene(scene);
        stage.show();
        boxElements.getAddDriverButton().setOnAction(driver -> {

            if (boxElements.addCarDriver(new CarDriver(
                    boxElements.getTextField1().getText(), boxElements.getTextField2().getText(),boxElements.getTextField3().getText()))) {
                textArea.appendText("Dodałem kierowcę");
            } else
                textArea.appendText("Nie mogę dodać kierowcy, już istnieje");

        });
       boxElements.getAddCarButton().setOnAction(car -> {
            if ((boxElements.addCar(new Car(boxElements.getTextField4().getText(), boxElements.getTextField5().getText())))) {
                textArea.appendText("Dodałem samochód");
            } else
                textArea.appendText("Nie mogę dodać samochodu");

        });
       boxElements.getClearTextAreaButton().setOnAction(x -> clearTextArea());
       boxElements.getShowDriverInTableButton().setOnAction(x -> borderPane.setRight(tableElements.getCarDriverTableView()));
       boxElements.getShowCarsInTable().setOnAction(c -> borderPane.setRight(tableElements.getCarTableView()));

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
