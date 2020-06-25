import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class FinderController {

    @FXML
    TableView startTable, endTable, resultTable;

    @FXML
    TableColumn startLandmarksColumn, endLandmarksColumn, resultLandmarkName, resultLandmarkDistance;

    @FXML
    TextField startLandmarkField, endLandmarkField;

    GraphNode<?> startLandmark, endLandmark;

    public void initialize() {

        GraphNode<?>[] landmarks;

        try {

            // nodes loaded in from file
            landmarks = Main.loadNodesFromFile();

            // convert the nodes return to a observable list
            ObservableList landmarkList = FXCollections.observableList(new ArrayList(Arrays.asList(landmarks)));

            startLandmarksColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            endLandmarksColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            startTable.setItems(landmarkList);
            endTable.setItems(landmarkList);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * called by both of the set buttons
     */
    public void setTextFields() {
        startLandmark = (GraphNode)startTable.getSelectionModel().getSelectedItem();
        if(startLandmark != null)
            startLandmarkField.setText(startLandmark.getName());

        endLandmark = (GraphNode)endTable.getSelectionModel().getSelectedItem();
        if(endLandmark != null)
            endLandmarkField.setText(endLandmark.getName());
    }

}