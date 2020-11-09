package courier;

public class Customer extends Person{
    //customer class creation
    public Customer(Integer age, Integer phone, String name) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
    }
}
