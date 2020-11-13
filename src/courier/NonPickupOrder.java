package courier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class NonPickupOrder extends Order implements PriceCal {
    public static ArrayList<NonPickupOrder> nonPickupOrdersAl= new ArrayList<>();
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
                NonPickupOrder np= new NonPickupOrder(getOrderID(),getCustomerID(),getOrderDate(),getRiderID(),getExpectedDelivery(),getOrderPrice(),getOrderPackage(),getStreet(),getCity(),getState(),getPostcode(),getDeliveryStatus());
                nonPickupOrdersAl.add(np);
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
//        NonPickupOrder np= new NonPickupOrder();
//        np.readOrderFile("txtFile/noPickupOrder.txt");
//        for (int i=0;i<nonPickupOrdersAl.size();i++){
//            System.out.println(nonPickupOrdersAl.get(i).getOrderID()+" "+nonPickupOrdersAl.get(i).getState()+" "+
//                    nonPickupOrdersAl.get(i).getOrderPackage().get(i));
//        }
//
//    }


}
