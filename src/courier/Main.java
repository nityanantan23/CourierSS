package courier;


public class Main {
    public static StaffLogin LoginPage;
    public static ManagerHome ManagerPage;
    public static CustomerRegistration CustomerRegister;
    public static AssignOrder assignOrderPage;
    public static Admin_UserMatrix adminUserMatrix;

    public static RiderHome riderHome;


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
//        assignOrderPage= new AssignOrder();
//        ManagerPage=new ManagerHome();
//        CustomerRegister= new CustomerRegistration();
        adminUserMatrix = new Admin_UserMatrix();
        //TODO only assign the rider id when the user login this is for testing purpose
//        riderHome= new RiderHome("R002");

    }
}
