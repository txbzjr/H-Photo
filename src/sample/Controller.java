package sample;


import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.UserUtil.Login;
import sample.UserUtil.User;

public class Controller{
    @FXML TextField usernametf,passwdtf;
    @FXML Label msglab;
    @FXML public void onLoginClick(){
        Login login = new Login(new User(usernametf.getText(),passwdtf.getText()));
        if (!login.VerifyInfo()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"用户名或密码不能为空");
            alert.setTitle("H-Photo");
            alert.setContentText("用户名或密码不能为空");
            alert.show();
        }else {
            Task<Void> task = new Task<Void>() {
                /*@Override
                protected void succeeded() {
                    super.succeeded();
                    updateMessage("Succeeded");
                }*/
                @Override
                protected void cancelled() {
                    super.cancelled();
                    updateMessage("Cancelled");
                }
                @Override
                protected void failed() {
                    super.failed();
                    updateMessage("Failed");
                }
                @Override
                protected Void call() throws Exception {
                    Login login = new Login(new User(usernametf.getText(),passwdtf.getText()));
                    updateMessage(login.VerifyUser());
                    return null;
                }
            };
            msglab.textProperty().bind(task.messageProperty());
            new Thread(task).start();
        }
    }

}