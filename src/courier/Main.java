package courier;

import courier.manager.ManagerHome;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main {
    public static StaffLogin LoginPage;
    public static ManagerHome ManagerPage;

    public static void main(String[] args) {
//        launch(args);
        //LoginPage= new StaffLogin();
        Admin a= new Admin();
        Manager m= new Manager();
        Customer c= new Customer();
        Rider r= new Rider();
        NonPickupOrder npo= new NonPickupOrder();
        PickupOrder po= new PickupOrder();
        r.loadStaff();
        m.loadStaff();
        a.loadStaff();
        c.readFile();
        npo.readFile();
        po.readFile();
        ManagerPage=new ManagerHome();
        CustomerRegister= new CustomerRegistration();
    }
}
