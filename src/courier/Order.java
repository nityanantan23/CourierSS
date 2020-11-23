package courier;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Order implements fileReader{
    private String orderID;
    private String customerID;
    private GregorianCalendar orderDate;
    private String riderID;
    private static GregorianCalendar expectedDelivery;
    private double orderPrice;
    private orderPackage pkg;
    private String street,city,state;
    private Integer postcode;
    private String deliveryStatus;
    private static Integer orderCount=100;
    private static final String[] lowPriceState={"KUL","SGR","NSN","MLK","PJY"};
    private static final String[] mediumPriceState={"JHR","PHG","PRK","PNG"};
    private static final String[] highPriceState={"TRG","KTN","PLS","KDH"};
    private static ArrayList<Order> orderAL= new ArrayList<>();



    public Order(){};

    public Order(String orderID,String customerID, GregorianCalendar orderDate, String riderID, GregorianCalendar expectedDelivery, double orderPrice,
                 orderPackage orderPackage,String street,String city,String state,Integer postcode, String deliveryStatus){
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
    public void setOrderPackage(orderPackage orderPackage) {  this.pkg= orderPackage; }
    public void setStreet(String street) {this.street = street;}
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setPostcode(Integer postcode) {this.postcode = postcode;}
    public void setDeliveryStatus(String deliveryStatus){this.deliveryStatus=deliveryStatus;}


    //getter
    public orderPackage getOrderPackage() {return pkg;}
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
    public static ArrayList<Order> getOrderAl(){ return orderAL;}
    public static Integer getOrderCount(){return  orderCount;}
    public static String[] getLowPriceState(){return lowPriceState;}
    public static String[] getMediumPriceState(){return mediumPriceState;}
    public static String[] getHighPriceState(){return highPriceState;}

    public static void orderCounter(){
        orderCount=orderCount+1;
    }

    @Override
    public void readFile() {
        String[] lineV;
        String line;
        try {
            Scanner scanner = new Scanner(new File("txtFile/Order.txt"));
            while (scanner.hasNext()){
                line= scanner.nextLine();
                lineV=line.split(";");
                setOrderID(lineV[0]);
                setCustomerID(lineV[1]);
                int day= Integer.parseInt(lineV[2]);
                int month= Integer.parseInt(lineV[3]);
                int year= Integer.parseInt(lineV[4]);
                GregorianCalendar Date= new GregorianCalendar();
                Date.set(year,month,day);
                setOrderDate(Date);
                setRiderID(lineV[5]);
                day= Integer.parseInt(lineV[6]);
                month=Integer.parseInt(lineV[7]);
                year=Integer.parseInt(lineV[8]);
                Date.set(year,month,day);
                setExpectedDelivery(Date);
                setOrderPrice( Double.parseDouble(lineV[9]));
                setStreet(lineV[10]);
                setCity(lineV[11]);
                setState(lineV[12]);
                setPostcode(Integer.parseInt(lineV[13]));
                setDeliveryStatus(lineV[14]);
                //retrieve matching
                for (int i2 =0;i2< courier.orderPackage.getOrderPackagesAl().size();i2++){
                    if (courier.orderPackage.getOrderPackagesAl().get(i2).getPackageID().equals(lineV[15])){
                        setOrderPackage(courier.orderPackage.getOrderPackagesAl().get(i2));
                        break;
                    }
                }
                Order o= new Order(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),getOrderPrice(),getOrderPackage(),getStreet(),getCity(),getState(),getPostcode(),getDeliveryStatus());
                orderAL.add(o);
                orderCounter();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Packages.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(getOrderID()+";"+getCustomerID()+";"+getOrderDate()+";"+getRiderID()+";"+getExpectedDelivery()+";"+
                    getOrderPrice()+";"+getCity()+";"+getOrderPackage().getPackageID()+";"+getState()+";"+getStreet()+";"+getPostcode()+";"+
                    getDeliveryStatus());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
                bw.close();
                fw.close();

            } catch (IOException e) { //instances where the i/o cannot be close
                e.printStackTrace();
            }
        }
    }
//##############################################################
    //Getter and Setters
//##############################################################




    //    public static void main(String[] args){
//        expectedDelivery = new GregorianCalendar();
//        System.out.println(expectedDelivery.getTime());
//    }



//    //calculation of price
//    @Override
//    public double priceCal() throws InvalidLocationException {
//        boolean pass=false;
//        String location =null;
//        for (int i=0; i<NonPickupOrder.nonPickupOrdersAl.size();i++){
//            if (NonPickupOrder.nonPickupOrdersAl.get(i).getOrderID().equals(getOrderID())){
//                location=NonPickupOrder.nonPickupOrdersAl.get(i).getState();
//                pass=true;
//            }
//        }
//        if (pass==false){
//            for (int i=0; i<PickupOrder.pickupOrdersAl.size();i++){
//                if (PickupOrder.pickupOrdersAl.get(i).getOrderID().equals(getOrderID())){
//                    location=PickupOrder.pickupOrdersAl.get(i).getState();
//                    pass=true;
//                }
//            }
//        }
//        //#check if location is valid
//        if (location==null){
//            throw new InvalidLocationException();
//        }else {
//            //set the package price
//            if (ArrayUtils.contains(lowPriceState,location)){
//                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.3+3)));
//            }else if (ArrayUtils.contains(mediumPriceState,location)){
//                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.5+4)));
//            }else {
//                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.8+4)));;
//            }
//        }
//        return 0;
//    }
    public static void main(String[] args){
        Order o= new Order();
        o.readFile();
        System.out.println(Order.getOrderAl().get(0).getStreet());
    }


}
