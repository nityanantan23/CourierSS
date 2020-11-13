package courier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;


public class orderPackage implements PriceCal {
    private String packageID;
    private double packageWeight;
    private double packagePrice;
    private String orderID;
    private static final String[] lowPriceState={"KUL","SGR","NSN","MLK","PJY"};
    private static final String[] mediumPriceState={"JHR","PHG","PRK","PNG"};
    private static final String[] highPriceState={"TRG","KTN","PLS","KDH"};
    private static ArrayList<orderPackage> orderPackagesAl= new ArrayList<>();

    public orderPackage(){}

    public orderPackage(String packageID,String orderID,double packageWeight,double packagePrice){
        setPackageID(packageID);
        setOrderID(orderID);
        setPackagePrice(packagePrice);
        setPackageWeight(packageWeight);
    }

    //##############
    //setter and getter


    public void setPackageID(String packageID) {this.packageID = packageID;}
    public void setOrderID(String orderID) { this.orderID = orderID; }
    public void setPackagePrice(double packagePrice) {   this.packagePrice = packagePrice; }
    public void setPackageWeight(double packageWeight) { this.packageWeight = packageWeight; }
    public String getPackageID() {return packageID; }
    public double getPackagePrice() {return packagePrice; }
    public double getPackageWeight() {return packageWeight;}
    public String getOrderID() {return orderID;}
    public static ArrayList<orderPackage> getOrderPackagesAl() { return orderPackagesAl; }
    //###############

    public void loadPackages(String fileLocation){
        Scanner sc= null;
        try {
            sc = new Scanner(new File(fileLocation));
            while(sc.hasNext()){
                setPackageID(sc.nextLine());
                setOrderID(sc.nextLine());
                setPackagePrice(Double.parseDouble(sc.nextLine()));
                setPackageWeight(Double.parseDouble(sc.nextLine()));
                orderPackage o= new orderPackage(getPackageID(),getOrderID(),getPackageWeight(),getPackagePrice());
                orderPackagesAl.add(o);
                if (sc.hasNext()){
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }


    @Override
    public double priceCal() throws InvalidLocationException {
        boolean pass=false;
        String location =null;
        for (int i=0; i<NonPickupOrder.nonPickupOrdersAl.size();i++){
            if (NonPickupOrder.nonPickupOrdersAl.get(i).getOrderID().equals(getOrderID())){
                location=NonPickupOrder.nonPickupOrdersAl.get(i).getState();
                pass=true;
            }
        }
        if (pass==false){
            for (int i=0; i<PickupOrder.pickupOrdersAl.size();i++){
                if (PickupOrder.pickupOrdersAl.get(i).getOrderID().equals(getOrderID())){
                    location=PickupOrder.pickupOrdersAl.get(i).getState();
                    pass=true;
                }
            }
        }
        //#check if location is valid
        if (location==null){
            throw new InvalidLocationException();
        }else {
            //set the package price
            if (ArrayUtils.contains(lowPriceState,location)){
                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.3+3)));

            }else if (ArrayUtils.contains(mediumPriceState,location)){
                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.5+4)));
            }else {

                setPackagePrice(Double.parseDouble(df.format(getPackageWeight()*0.8+4)));;
            }
        }
        return 0;
    }






}