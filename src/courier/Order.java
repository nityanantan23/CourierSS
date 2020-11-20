package courier;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Order implements fileAccess {
    private String orderID;
    private String customerID;
    private GregorianCalendar orderDate;
    private String riderID;
    private static GregorianCalendar expectedDelivery;
    private double orderPrice;
    private ArrayList<courier.orderPackage> orderPackage= new ArrayList<>();
    private String street,city,state;
    private Integer postcode;
    private String deliveryStatus;
    private static Integer orderCount=100;

    public Order(){};

    public Order(String orderID,String customerID, GregorianCalendar orderDate, String riderID, GregorianCalendar expectedDelivery, double orderPrice,
                 ArrayList<courier.orderPackage> orderPackage,String street,String city,String state,Integer postcode, String deliveryStatus){
        //place all setter method here
        setOrderID(orderID);
        setCustomerID(customerID);
        setOrderDate(orderDate);
        setRiderID(riderID);
        setExpectedDelivery(expectedDelivery);
        setOrderPrice(orderPrice);
        setCity(city);
        setOrderPackage(orderPackage);
        setState(state);
        setStreet(street);
        setPostcode(postcode);
        setDeliveryStatus(deliveryStatus);

    }

//##############################################################
    //Getter and Setters
//##############################################################
    //setter
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public void setExpectedDelivery(GregorianCalendar expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }
    public void setOrderDate(GregorianCalendar orderDate) {this.orderDate = orderDate;}
    public void setOrderID(String orderID) {this.orderID = orderID;}
    public void setOrderPrice(double orderPrice) {this.orderPrice = orderPrice; }
    public void setRiderID(String riderID) { this.riderID = riderID; }
    public void setOrderPackage(ArrayList<courier.orderPackage> orderPackage) { this.orderPackage = orderPackage; }
    public void setStreet(String street) {this.street = street;}
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setPostcode(Integer postcode) {this.postcode = postcode;}
    public void setDeliveryStatus(String deliveryStatus){this.deliveryStatus=deliveryStatus;}


    //getter
    public ArrayList getOrderPackage() {return orderPackage;}
    public double getOrderPrice() {return orderPrice;}
    public GregorianCalendar getExpectedDelivery() {return expectedDelivery;}
    public GregorianCalendar getOrderDate() {return orderDate;}
    public String getOrderID() {return orderID;}
    public String getCustomerID() {return customerID;}
    public String getRiderID() { return riderID;}
    public String getStreet() {return street;}
    public String getState() {return state;}
    public String getCity() {return city;}
    public Integer getPostcode() { return postcode; }
    public String getDeliveryStatus(){return deliveryStatus;}
    public static Integer getOrderCount(){return  orderCount;}

    public static void orderCounter(){
        orderCount=orderCount+1;
    }


//##############################################################
    //Getter and Setters
//##############################################################

    //    public static void main(String[] args){
//        expectedDelivery = new GregorianCalendar();
//        System.out.println(expectedDelivery.getTime());
//    }

}
