package sample;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    private ObservableList<Student> studentData= FXCollections.observableArrayList();
    @FXML
    private TableView<Student> tableStudent;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> groupColumn;
    @FXML
    private TableColumn<Student, Integer> markColumn;
    @FXML
    private CheckBox idCheck;
    @FXML
    private CheckBox groupCheck;
    @FXML
    private CheckBox markCheck;
    @FXML
    private Button addButton;
    @FXML
    private TextField textFirst;
    @FXML
    private TextField textSecond;
    @FXML
    private TextField textThird;
    @FXML
    private void initialize() {
       addButton.setOnAction(event -> initData());
        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("group"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("mark"));

        tableStudent.setItems(studentData);
        idCheck.selectedProperty().addListener(new javafx.beans.value.ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(idCheck.isSelected())idColumn.setVisible(true);
                if(!idCheck.isSelected())idColumn.setVisible(false);
            }
        });

        groupCheck.selectedProperty().addListener(new javafx.beans.value.ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(groupCheck.isSelected())groupColumn.setVisible(true);
                if(!groupCheck.isSelected())groupColumn.setVisible(false);
            }
        });
        markCheck.selectedProperty().addListener(new javafx.beans.value.ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(markCheck.isSelected())markColumn.setVisible(true);
                if(!markCheck.isSelected())markColumn.setVisible(false);
            }
        });
    }

    private void initData() {
        studentData.add(new Student(textFirst.getText(), textSecond.getText(), Integer.parseInt(textThird.getText())));

    }

}
