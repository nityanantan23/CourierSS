package courier;

import courier.InvalidLocationException;

import java.text.DecimalFormat;

public interface PriceCal {
    DecimalFormat df = new DecimalFormat("#.##");
    public double priceCal() throws InvalidLocationException;
}
