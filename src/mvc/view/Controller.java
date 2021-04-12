package mvc.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


public class Controller {

    @FXML
    private void onExitButtonClicked(MouseEvent event) {

        Platform.exit();
        System.exit(0);

    }

    private void onMinimizedButtonClicked(ActionEvent event) {




    }




}
