package courier.RecycleBin;

import courier.orderPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class NonPickupOrder{
    public static ArrayList<NonPickupOrder> nonPickupOrdersAl= new ArrayList<>();
    private String line;
    public static String[] lineV;
    public NonPickupOrder(){};


    public NonPickupOrder(String orderID, String customerID, GregorianCalendar orderDate, String riderID, GregorianCalendar expectedDelivery, double orderPrice, orderPackage orderPackage, String street, String city, String state, Integer postcode, String status) {
        super(orderID, customerID, orderDate, riderID, expectedDelivery, orderPrice, orderPackage, street, city, state, postcode,status);
    }

    //getter and setter




    public double priceCal() {return 2;}

//            //set the package price
//            if (ArrayUtils.contains(getLowPriceState(),location)){
//                setOrderPrice(Double.parseDouble(df.format(getPackageWeight()*0.3+3)));
//            }else if (ArrayUtils.contains(mediumPriceState,location)){
//                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.5+4)));
//            }else {
//                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.8+4)));;



    @Override
    public void readFile() {
        String line;
        ArrayList<orderPackage> orderPackageArrayList=new ArrayList<>();
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
                NonPickupOrder np= new NonPickupOrder(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),getOrderPrice(),getOrderPackage(),getStreet(),getCity(),getState(),getPostcode(),getDeliveryStatus());
                nonPickupOrdersAl.add(np);
                orderCounter();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //class validator
//    public static void main(String[] args){
//        orderPackage op= new orderPackage();
//        op.readFile();
//        System.out.println(orderPackage.getOrderPackagesAl().get(0).getPackageID());
//        System.out.println(orderPackage.getOrderPackagesAl().get(1).getPackageID());
//        NonPickupOrder np= new NonPickupOrder();
//        np.readFile();
//        PickupOrder po= new PickupOrder();
//        po.readFile();
//
//        System.out. println(PickupOrder.pickupOrdersAl.get(0).getOrderPackage().getPackageWeight());
//        System.out. println(nonPickupOrdersAl.get(0).getOrderPackage().getPackageWeight());
//
//    }


}
