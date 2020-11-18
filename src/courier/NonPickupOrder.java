package courier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class NonPickupOrder extends Order implements PriceCal {
    public static ArrayList<NonPickupOrder> nonPickupOrdersAl= new ArrayList<>();
    private String line;
    public static String[] lineV;
    public NonPickupOrder(){};


    public NonPickupOrder(String orderID, String customerID, GregorianCalendar orderDate, String riderID, GregorianCalendar expectedDelivery, double orderPrice, ArrayList<courier.orderPackage> orderPackage, String street, String city, String state, Integer postcode,String status) {
        super(orderID, customerID, orderDate, riderID, expectedDelivery, orderPrice, orderPackage, street, city, state, postcode,status);
    }

    //getter and setter



    @Override
    public double priceCal() {
        return 0;
    }

    @Override
    public void readFile() {
        String line;
        ArrayList<orderPackage> orderPackageArrayList=new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("txtFile/noPickupOrder.txt"));
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
                //do a for loop to get array from 14 onwards
                for (int i=15;i<lineV.length;i++){
                    for (int i2 =0;i2< courier.orderPackage.getOrderPackagesAl().size();i2++){
                        if (courier.orderPackage.getOrderPackagesAl().get(i2).getPackageID().equals(lineV[i])){
                            orderPackageArrayList.add(courier.orderPackage.getOrderPackagesAl().get(i2));
                            break;
                        }
                    }
                }

                setOrderPackage(orderPackageArrayList);
                NonPickupOrder np= new NonPickupOrder(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),getOrderPrice(),getOrderPackage(),getStreet(),getCity(),getState(),getPostcode(),getDeliveryStatus());
                nonPickupOrdersAl.add(np);
                orderCounter();
                if (scanner.hasNext()){
                    scanner.nextLine();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //class validator
    public static void main(String[] args){
        orderPackage op= new orderPackage();
        op.readFile();
        NonPickupOrder np= new NonPickupOrder();
        np.readFile();
        PickupOrder po= new PickupOrder();
        po.readFile();
//        for (int i=0;i<nonPickupOrdersAl.size();i++){
//            System.out.println(nonPickupOrdersAl.get(i).getOrderID()+" "+nonPickupOrdersAl.get(i).getState()+" ");
//            orderPackage test= (courier.orderPackage) nonPickupOrdersAl.get(i).getOrderPackage().get(0);
//            System.out.println(test.getPackagePrice());
//        }
//        for (int i =0; i<NonPickupOrder.lineV.length;i++){
//            System.out.println(i+" "+lineV[i]);
//        }
        System.out.println(getOrderCount());

    }


}
