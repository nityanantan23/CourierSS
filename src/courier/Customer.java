package courier;

public class Customer extends Person{
    //customer class creation
    public Customer(Integer age, String phone, String name) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
    }
}
