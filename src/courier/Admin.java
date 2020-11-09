package courier;

public class Admin extends Staff{


    public Admin(Integer age, String phone, String name, String username, String password, String credentialfilelocation) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name, username, password, credentialfilelocation);
    }
}
