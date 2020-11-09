package courier;

public class Admin extends Staff{


    public Admin(Integer age, Integer phone, String name, String username, String password) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name, username, password);
    }


}
