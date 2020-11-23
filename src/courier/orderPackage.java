package courier;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;


public class orderPackage implements fileReader,IDGenerator {
    private String packageID;
    private String orderID;
    private double packageWeight;
    private String packageSize;
    private static final String[] packageSizeSel={"small","medium","large"};
    private static ArrayList<orderPackage> orderPackagesAl= new ArrayList<>();
    private String line;
    private String[] lineV;
    private static int packageCount=100;
    private static final NumberFormat df = new DecimalFormat("#0.00");

    public orderPackage(){}
    public orderPackage(String packageID,String orderID,double packageWeight,String packageSize){
        setPackageID(packageID);
        setOrderID(orderID);
        setPackageWeight(packageWeight);
        setPackageSize(packageSize);
    }

    //##############
    //setter and getter
    public void setPackageID(String packageID) {this.packageID = packageID;}
    public void setOrderID(String orderID) { this.orderID = orderID; }
    public void setPackageWeight(double packageWeight) { this.packageWeight = packageWeight;}
    public void setPackageSize(String packageSize) { this.packageSize = packageSize;}
    public static String[] getPackageSizeSel(){return packageSizeSel;}
    public String getPackageID() {return packageID; }
    public double getPackageWeight() {return packageWeight;}
    public String getOrderID() {return orderID;}
    public String getPackageSize() {return packageSize;}
    public static ArrayList<orderPackage> getOrderPackagesAl() { return orderPackagesAl; }
    //###############

    //reading and initialising objects
    //delim for packages and order is semi colon
    @Override
    public void readFile() {
        Scanner sc= null;
        try {
            sc = new Scanner(new File("txtFile/Packages.txt"));
            while(sc.hasNext()){
                line=sc.nextLine();
                lineV=line.split(";");
                setPackageID(lineV[0]);
                setOrderID(lineV[1]);
                setPackageSize(lineV[2]);
                setPackageWeight(Double.parseDouble(lineV[3]));
                orderPackage o= new orderPackage(getPackageID(),getOrderID(),getPackageWeight(),getPackageSize());
                orderPackagesAl.add(o);
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

            pw.println(getPackageID()+";"+getOrderID()+";"+getPackageWeight()+";"+getPackageSize());

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


    public static void addPkgCount(){
        packageCount=packageCount+1;
    }

    @Override
    public String generateID(int itemCounter) {
        addPkgCount();
        return ("P"+packageCount);
    }

    //todo revise the function
    public double priceCal(Order o) throws InvalidLocationException{
        boolean pass=false;
        String location =null;
        //#check if location is valid
        if (o.getCity()==null){
            throw new InvalidLocationException();
        }else {
            //set the package price
            if (ArrayUtils.contains(packageSizeSel,o.getOrderPackage().getPackageSize())){
                o.setOrderPrice(Double.parseDouble(df.format(o.getOrderPackage().getPackageWeight()*0.3+3)));
                pass=true;
            }else if (ArrayUtils.contains(packageSizeSel,o.getOrderPackage().getPackageSize())){
                o.setOrderPrice(Double.parseDouble(df.format(o.getOrderPackage().getPackageWeight()*0.5+4)));
                pass=true;
            }else {
                o.setOrderPrice(Double.parseDouble(df.format(o.getOrderPackage().getPackageWeight()*0.8+4)));;
                pass=true;
            }
            if (pass==true){
                if (ArrayUtils.contains(Order.getLowPriceState(),o.getState())){
                    o.setOrderPrice(o.getOrderPrice()+0);
                }else if (ArrayUtils.contains(Order.getMediumPriceState(),o.getState())){
                    o.setOrderPrice(o.getOrderPrice()+3);
                }else {
                    o.setOrderPrice(o.getOrderPrice()+5);
                }
            }


        }
        return 0;
    };






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

}
