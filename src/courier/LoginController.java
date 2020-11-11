package courier;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField Email;
    @FXML
    private TextField pass;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void sign_in() {
        File tempFile = new File("tempAccounts.txt");
        File orifile = new File("Admin_account.txt");

        try (BufferedReader reader_admin = new BufferedReader(new FileReader("Admin_account.txt"));
             BufferedReader reader_manager = new BufferedReader(new FileReader("Manager_account.txt"))) {
            String line = reader_admin.readLine();
            String line1 = reader_manager.readLine();
            String email = Email.getText();
            String password = pass.getText();

            while (((line != null) && (line1 != null))) {
                String[] information = line.split(",");
                String[] information1 = line1.split(",");
                //hard coding the login
                String username_admin = information[0];
                String password1_admin = information[1];
                String username_manager = information1[0];
                String password1_manager = information1[1];
                if (email.equals(username_admin) && password.equals(password1_admin)) {
                    final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("courier/admin/admin_home.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("Courier Service System");
                    stage.setScene(scene);
                    scene.getStylesheets().setAll(getClass().getResource("style.css").toExternalForm());
                    stage.setResizable(false);
                    stage.show();
                    break;
                } else if (email.equals(username_manager) && password.equals(password1_manager)) {
                    final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("courier/manager/manager_home.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("Courier Service System");
                    stage.setScene(scene);
                    scene.getStylesheets().setAll(getClass().getResource("style.css").toExternalForm());
                    stage.setResizable(false);
                    stage.show();
                    break;
                } else {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR, "Invalid credentials", ButtonType.OK);
                    alert1.show();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
