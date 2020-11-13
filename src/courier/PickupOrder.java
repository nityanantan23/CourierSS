package courier;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PickupOrder extends Order implements PriceCal {
    String OriginStreet,originCity,originState,originPostcode;
    boolean pickupStatus;
    public static ArrayList<PickupOrder> pickupOrdersAl=new ArrayList<>();



    public PickupOrder(String orderID, String customerID, GregorianCalendar orderDate, String riderID, GregorianCalendar expectedDelivery, double orderPrice, ArrayList<courier.orderPackage> orderPackage, String street, String city, String state,
                       Integer postcode, String originStreet,String originCity,String originState,
                       String originPostcode,boolean pickupStatus) {
        super(orderID, customerID, orderDate, riderID, expectedDelivery, orderPrice, orderPackage, street, city, state, postcode);
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

    public void setOriginPostcode(String originPostcode) {
        this.originPostcode = originPostcode;
    }

    public void setPickupStatus(boolean pickupStatus) {
        this.pickupStatus = pickupStatus;
    }

    @Override
    public double priceCal() {
        return 0;
    }

    @Override
    public void readOrderFile(String fileLocation) {


    }


}
