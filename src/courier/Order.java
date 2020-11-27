package courier;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Order implements fileReader,IDGenerator{
    private String orderID;
    private String customerID;
    private LocalDate orderDate;
    private String riderID;
    private LocalDate expectedDelivery;
    private double orderPrice;
    private orderPackage pkg;
    private String street,city,state;
    private Integer postcode;
    private String deliveryStatus;
    private static Integer orderCount=100;
    private static final String[] LOW_PRICE_STATE ={"KUL","SGR","NSN","MLK","PJY"};
    private static final String[] MEDIUM_PRICE_STATE ={"JHR","PHG","PRK","PNG"};
    private static final String[] HIGH_PRICE_STATE ={"TRG","KTN","PLS","KDH"};
    private static ArrayList<Order> orderAL= new ArrayList<>();
    public static final NumberFormat DF = new DecimalFormat("#0.00");



    public Order(String orderID,String customerID, LocalDate orderDate,LocalDate expectedDelivery,
                 double orderPrice,orderPackage orderPackage,String street,String city,String state,
                 Integer postcode){
        this.orderID=(orderID);
        this.customerID=(customerID);
        this.orderDate=(orderDate);
        setRiderID("null");
        this.expectedDelivery =(expectedDelivery);
        this.orderPrice=(orderPrice);
        this.city=(city);
        this.pkg=orderPackage;
        this.state=state;
        this.street=street;
        this.postcode=postcode;
        setDeliveryStatus("Order Placed");
        generateID();
    }

    public Order(String orderID,String customerID, LocalDate orderDate, String riderID,
                 LocalDate expectedDelivery, double orderPrice,
                 orderPackage orderPackage,String street,String city,String state,
                 Integer postcode, String deliveryStatus){
        this.orderID=(orderID);
        this.customerID=(customerID);
        this.orderDate=(orderDate);
        setRiderID(riderID);
        this.expectedDelivery =(expectedDelivery);
        this.orderPrice=(orderPrice);
        this.city=(city);
        this.pkg=orderPackage;
        this.state=state;
        this.street=street;
        this.postcode=postcode;
        setDeliveryStatus(deliveryStatus);
        generateID();
    }

    public Order(){};

//##############################################################
    //Getter and Setters
//##############################################################
    //setter
    public void setRiderID(String riderID) { this.riderID = riderID; }
    public void setDeliveryStatus(String deliveryStatus){this.deliveryStatus=deliveryStatus;}
    //getter
    public orderPackage getOrderPackage() {return pkg;}
    public double getOrderPrice() {return orderPrice;}
    public LocalDate getExpectedDelivery() {return expectedDelivery;}
    public LocalDate getOrderDate() {return orderDate;}
    public String getOrderID() {return orderID;}
    public String getCustomerID() {return customerID;}
    public String getRiderID() { return riderID;}
    public String getStreet() {return street;}
    public String getState() {return state;}
    public String getCity() {return city;}
    public Integer getPostcode() { return postcode; }
    public String getDeliveryStatus(){return deliveryStatus;}
    public static ArrayList<Order> getOrderAl(){ return orderAL;}




    public static LocalDate expectedDateCal(LocalDate g,String state){
        LocalDate expDate=  g;

        if (ArrayUtils.contains(LOW_PRICE_STATE,state)){
            expDate.plusDays(3);
        }else if(ArrayUtils.contains(MEDIUM_PRICE_STATE,state)){
            expDate.plusDays(5);
        }else {
            expDate.plusDays(7);
        }
        return expDate;
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
                this.orderID=lineV[0];
                this.customerID=lineV[1];
                int day= Integer.parseInt(lineV[2]);
                int month= Integer.parseInt(lineV[3]);
                int year= Integer.parseInt(lineV[4]);
                LocalDate Date1= LocalDate.of(year,month,day);
                this.orderDate=Date1;
                setRiderID(lineV[5]);
                day= Integer.parseInt(lineV[6]);
                month=Integer.parseInt(lineV[7]);
                year=Integer.parseInt(lineV[8]);
                LocalDate Date2= LocalDate.of(year,month,day);
                this.expectedDelivery=Date2;
                this.orderPrice=Double.parseDouble(lineV[9]);
                this.street=lineV[10];
                this.city=lineV[11];
                this.state=lineV[12];
                this.postcode=Integer.parseInt(lineV[13]);
                setDeliveryStatus(lineV[14]);
                //retrieve matching
                for (int i2 =0;i2< courier.orderPackage.getOrderPackagesAl().size();i2++){
                    if (courier.orderPackage.getOrderPackagesAl().get(i2).getPackageID().equals(lineV[15])){
                        this.pkg=courier.orderPackage.getOrderPackagesAl().get(i2);
                        break;
                    }
                }
                Order o= new Order(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),getOrderPrice(),getOrderPackage(),getStreet(),getCity(),getState(),getPostcode(),getDeliveryStatus());
                orderAL.add(o);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            pw = new PrintWriter(new File("txtFile/Order.txt"));
            for (int i=0;i<orderAL.size();i++){
                Order o= orderAL.get(i);
                pw.println(o.getOrderID()+";"+o.getCustomerID()+";"+o.getOrderDate().getDayOfMonth()+";"
                        +(o.getOrderDate().getMonthValue())+";"+o.getOrderDate().getYear()+";"
                        +o.getRiderID()+";"+o.getExpectedDelivery().getDayOfMonth()+";"+
                        (o.getExpectedDelivery().getMonthValue())+";"+o.getExpectedDelivery().getYear()+
                        ";"+o.getOrderPrice()+";"+o.getStreet()+";"+o.getCity()+";"+o.getState()+";"
                        +o.getPostcode()+";"+o.getDeliveryStatus()+";"+o.getOrderPackage().getPackageID());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.close();

        }
    }

    //todo should be added to file access






    @Override
    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Order.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(getOrderID()+";"+getCustomerID()+";"+getOrderDate().getDayOfMonth()+";"
                    +(getOrderDate().getMonthValue())+";"+getOrderDate().getYear()+";"
                    +getRiderID()+";"+getExpectedDelivery().getDayOfMonth()+";"+
                    (getExpectedDelivery().getMonthValue() )+";"+getExpectedDelivery().getYear()+
                    ";"+getOrderPrice()+";"+getStreet()+";"+getCity()+";"+getState()+";"
                            +getPostcode()+";"+getDeliveryStatus()+";"+getOrderPackage().getPackageID());

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


    public static double priceCal(String state,String size, Double weight){
        boolean pass=false;
        double price=0;

        if (size.toLowerCase().equals("small")){
                price= (Double.parseDouble(DF.format(weight*0.1+3)));
                pass=true;
            }else if (size.toLowerCase().equals("medium")){
                price= (Double.parseDouble(DF.format(weight*0.3+4)));
                pass=true;
            }else {
                price= (Double.parseDouble(DF.format(weight*0.5+4)));;
                pass=true;
            }
            if (pass==true){
                if (ArrayUtils.contains(Order.LOW_PRICE_STATE,state)){
                    price=price+0;
                }else if (ArrayUtils.contains(Order.MEDIUM_PRICE_STATE,state)){
                    price=price+3;
                }else {
                    price=price+5;
                }
            }
        return Double.parseDouble(DF.format(price));
    }





    public static void main(String[] args){
//        Order o= new Order();
//        o.readFile();
//        System.out.println(Order.getOrderAl().get(0).getStreet());
//        LocalDate g= new LocalDate();
//        System.out.println(g.get(LocalDate.MONTH)+1);
        LocalDate g1= LocalDate.now();
        LocalDate g2= LocalDate.now();
        g2.plusDays(100);
        System.out.println(g1.compareTo(g1));
    }

    @Override
    public String generateID() {
        orderCount=orderCount+1;
        return ("O"+orderCount);
    }
}
