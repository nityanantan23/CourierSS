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
    private String line;
    private String[] lineV;

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
    public void readFile() {
        String line;
        ArrayList<orderPackage> orderPackageArrayList=new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("txtFile/PickupOrder.txt"));
            while (scanner.hasNext()){
                line=scanner.nextLine();
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
                setOriginStreet(lineV[14]);
                setOriginCity(lineV[15]);
                setOriginState(lineV[16]);
                setOriginPostcode(Integer.parseInt(lineV[17]));
                setPickupStatus(Boolean.parseBoolean(lineV[18]));
                setDeliveryStatus(lineV[19]);
                for (int i=20;i< lineV.length;i++){
                    for (int i2 =0;i2< courier.orderPackage.getOrderPackagesAl().size();i2++){
                        if (courier.orderPackage.getOrderPackagesAl().get(i2).getPackageID().equals(lineV[i])){
                            orderPackageArrayList.add(courier.orderPackage.getOrderPackagesAl().get(i2));
                            break;
                        }
                    }
                }



                setOrderPackage(orderPackageArrayList);
                PickupOrder po= new PickupOrder(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),
                        getOrderPrice(),getStreet(),getCity(),getState(),getPostcode(),getOriginStreet(),getOriginCity(),
                        getOriginState(),getOriginPostcode(),getPickupStatus(),getDeliveryStatus(),getOrderPackage());
                pickupOrdersAl.add(po);
                orderCounter();
                if (scanner.hasNext()){
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //class checker
//    public static void main(String[] args){
//        orderPackage op= new orderPackage();
//        op.readFile();
//        PickupOrder po= new PickupOrder();
//        po.readFile();
//        courier.orderPackage o= new orderPackage();
//        for (int i=0;i<pickupOrdersAl.size();i++){
//            System.out.println(pickupOrdersAl.get(i).getOrderID()+" "+pickupOrdersAl.get(i).getOriginStreet()+" "+
//                    " "+pickupOrdersAl.get(i).getStreet()+" "+pickupOrdersAl.get(i).getOrderPackage().get(i)+" "+
//                    pickupOrdersAl.get(i).getPickupStatus()+" ");
//            o=(orderPackage)pickupOrdersAl.get(i).getOrderPackage().get(i);
//        }
//        System.out.println(o.getOrderID()+" "+o.getPackageID()+" "+o.getPackagePrice()+" "+o.getPackageWeight());
//    }



}
