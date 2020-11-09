package courier;

public class Manager extends Staff{
    //manager class creation
    public Manager(Integer age, Integer phone, String name) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
    }
}
