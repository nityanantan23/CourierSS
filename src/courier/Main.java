package courier;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends   Application {
    public static StaffLogin LoginPage;
    public static ManagerHome ManagerPage;
    public static CustomerRegistration CustomerRegister;
    public static AssignOrder assignOrderPage;
    public static RiderHome riderHome;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("CourierSS");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
//        launch(args);
        //LoginPage= new StaffLogin();
        Admin a= new Admin();
        Manager m= new Manager();
        Customer c= new Customer();
        Rider r= new Rider();
        Order o= new Order();
        orderPackage op= new orderPackage();
        op.readFile();
        o.readFile();
        r.loadStaff();
        m.loadStaff();
        a.loadStaff();
        c.readFile();
        assignOrderPage= new AssignOrder();
        ManagerPage=new ManagerHome();
        CustomerRegister= new CustomerRegistration();
        riderHome= new RiderHome("R002");

    }
}
