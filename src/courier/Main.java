package courier;


public class Main {
    public static StaffLogin LoginPage;
    public static ManagerHome ManagerPage;
    public static CustomerRegistration CustomerRegister;
    public static AssignOrder assignOrderPage;
    public static Admin_UserMatrix adminUserMatrix;
    public static Report report;
    public static Manager_profile manager_profile;
    public static FeedbackPage feedbackPage;
    public static RiderHome riderHome;
    public static EditOrder editOrder;
    public static OrderOverview orderOverview;
    public static Rider_profile riderProfile;



    public static void main(String[] args) {

        LoginPage= new StaffLogin();
        Customer c= new Customer();
        Order o= new Order();
        Feedback f = new Feedback();
        orderPackage op= new orderPackage();
        op.readFile();
        o.readFile();
        c.readFile();
        f.readFile();
//        assignOrderPage= new AssignOrder();
//        ManagerPage=new ManagerHome();
//        CustomerRegister= new CustomerRegistration();
//        adminUserMatrix = new Admin_UserMatrix();
//        report = new Report();
        //TODO only assign the rider id when the user login this is for testing purpose
//        riderHome= new RiderHome("R002");
//        manager_profile = new Manager_profile();
//        feedbackPage = new FeedbackPage();

    }
}
