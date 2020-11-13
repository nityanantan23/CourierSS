package courier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PickupOrder extends Order implements PriceCal {
    String OriginStreet,originCity,originState;
    Integer originPostcode;
    boolean pickupStatus;
    public static ArrayList<PickupOrder> pickupOrdersAl=new ArrayList<>();

    public PickupOrder(){};

    public PickupOrder(String orderID, String customerID, GregorianCalendar orderDate, String riderID, GregorianCalendar expectedDelivery,
                       double orderPrice, String street, String city, String state, Integer postcode, String originStreet,String originCity,String originState,
                       Integer originPostcode,boolean pickupStatus, String status,ArrayList<courier.orderPackage> orderPackage) {
        super(orderID, customerID, orderDate, riderID, expectedDelivery, orderPrice, orderPackage, street, city, state, postcode,status);
        setOriginStreet(originStreet);
        setOriginCity(originCity);
        setOriginState(originState);
        setOriginPostcode(originPostcode);
        setPickupStatus(pickupStatus);
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }
    public void setOriginStreet(String originStreet) {
        OriginStreet = originStreet;
    }
    public void setOriginState(String originState) {
        this.originState = originState;
    }
    public void setOriginPostcode(Integer originPostcode) {
        this.originPostcode = originPostcode;
    }
    public void setPickupStatus(boolean pickupStatus) {
        this.pickupStatus = pickupStatus;
    }

    public String getOriginCity() {return originCity;}
    public static ArrayList<PickupOrder> getPickupOrdersAl() { return pickupOrdersAl;}
    public Integer getOriginPostcode() {return originPostcode;}
    public String getOriginState() {return originState;}
    public String getOriginStreet() {return OriginStreet;}
    public boolean getPickupStatus(){return pickupStatus;}
    public static void setPickupOrdersAl(ArrayList<PickupOrder> pickupOrdersAl) { PickupOrder.pickupOrdersAl = pickupOrdersAl;}

    @Override
    public double priceCal() {
        return 0;
    }

    @Override
    public void readOrderFile(String fileLocation) {
        String line;
        ArrayList<orderPackage> orderPackageArrayList=new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileLocation));
            while (scanner.hasNext()){
                setOrderID(scanner.nextLine());
                setCustomerID(scanner.nextLine());
                int day= Integer.parseInt(scanner.nextLine());
                int month= Integer.parseInt(scanner.nextLine());
                int year= Integer.parseInt(scanner.nextLine());
                GregorianCalendar Date= new GregorianCalendar();
                Date.set(year,month,day);
                setOrderDate(Date);
                setRiderID(scanner.nextLine());
                day= Integer.parseInt(scanner.nextLine());
                month=Integer.parseInt(scanner.nextLine());
                year=Integer.parseInt(scanner.nextLine());
                Date.set(year,month,day);
                setExpectedDelivery(Date);
                setOrderPrice( Double.parseDouble(scanner.nextLine()));
                setStreet(scanner.nextLine());
                setCity(scanner.nextLine());
                setState(scanner.nextLine());
                setPostcode(Integer.parseInt(scanner.nextLine()));
                setOriginStreet(scanner.nextLine());
                setOriginCity(scanner.nextLine());
                setOriginState(scanner.nextLine());
                setOriginPostcode(Integer.parseInt(scanner.nextLine()));
                setPickupStatus(Boolean.parseBoolean(scanner.nextLine()));
                setDeliveryStatus(scanner.nextLine());
                while ( scanner.hasNext()&&!(line=scanner.nextLine()).isEmpty()){
                    //build a arraylist searcher for package
                    for (int i =0;i< courier.orderPackage.getOrderPackagesAl().size();i++){
                        if (courier.orderPackage.getOrderPackagesAl().get(i).getPackageID().equals(line)){
                            orderPackageArrayList.add(courier.orderPackage.getOrderPackagesAl().get(i));
                            break;
                        }
                    }
                }
                setOrderPackage(orderPackageArrayList);
                PickupOrder po= new PickupOrder(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),
                        getOrderPrice(),getStreet(),getCity(),getState(),getPostcode(),getOriginStreet(),getOriginCity(),
                        getOriginState(),getOriginPostcode(),getPickupStatus(),getDeliveryStatus(),getOrderPackage());
                pickupOrdersAl.add(po);
                if (scanner.hasNext()){
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args){
//        orderPackage op= new orderPackage();
//        op.loadPackages("txtFile/Packages.txt");
//        PickupOrder po= new PickupOrder();
//        po.readOrderFile("txtFile/PickupOrder.txt");
//        for (int i=0;i<pickupOrdersAl.size();i++){
//            System.out.println(pickupOrdersAl.get(i).getOrderID()+" "+pickupOrdersAl.get(i).getOriginStreet()+" "+
//                    " "+pickupOrdersAl.get(i).getStreet()+" "+pickupOrdersAl.get(i).getOrderPackage().get(i)+" "+
//                    pickupOrdersAl.get(i).getPickupStatus()+" ");
//        }
//    }



}
