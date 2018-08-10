
package calender;

import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    public Label dateLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        Thread dateThread = new Thread(() -> {
            while(true){
                DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy"); ///HH:mm:ss dd/MM/yyyy
                Platform.runLater(() -> {
                    dateLabel.setText(dateTimeFormatter.format(ZonedDateTime.now()));
                });
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex) {
                    break;
                }
            }
        });
        dateThread.setDaemon(true);
        dateThread.start();
    }
    
    @FXML
    public void exitAction(MouseEvent event){
        if(event.getClickCount() >= 2){
            System.exit(0);
        }
    }
}
