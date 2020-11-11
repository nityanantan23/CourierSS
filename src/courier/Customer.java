package courier;
import java.util.ArrayList;

public class Customer extends Person{


    //customer class creation
    public Customer(String name,Integer age, String phone ) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(name,age, phone);
    }

    @Override
    public void readfile() {

    }
}
