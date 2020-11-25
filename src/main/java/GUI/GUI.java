package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Collection;


public class GUI extends Application {

    private TextArea textArea;
    private GUITableElements tableElements;
    private GUIBoxElements boxElements;
    private Scene scene;
    private BorderPane borderPane;


    public GUI() {

        tableElements = new GUITableElements();
        boxElements=new GUIBoxElements();
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

            if (tableElements.addToDriver(boxElements.getTextField1().getText(), boxElements.getTextField2().getText(), boxElements.getTextField3().getText())) {
                textArea.clear();
                textArea.appendText("Dodałem kierowcę\n");
            } else
                textArea.appendText("Nie mogę dodać kierowcy, już istnieje\n");

        });
        boxElements.getAddCarButton().setOnAction(car -> {
            if (tableElements.addToCar(boxElements.getTextField4().getText(), boxElements.getTextField5().getText())) {
                textArea.clear();
                textArea.appendText("Dodałem samochód\n");
            } else
                textArea.appendText("Nie mogę dodać samochodu\n");

        });
        boxElements.getClearTextAreaButton().setOnAction(x -> clearTextArea());
        boxElements.getShowDriverInTableButton().setOnAction(x ->
        {
            borderPane.setRight(tableElements.getCarDriverTableView());
            setTextArea(tableElements.getDriversFromDB());
        });
        boxElements.getShowCarsInTable().setOnAction(c ->
        {
            borderPane.setRight(tableElements.getCarTableView());
            setTextArea(tableElements.getCarsFromDB());
        });

    }


    public void setTextArea( Collection collection ) {
        textArea.clear();
        textArea.appendText(collection + "\n");

    }

    public void clearTextArea() {
        textArea.clear();
    }
}
