package courier;

public class Rider extends Staff{
    //rider class creation
    public Rider(Integer age, Integer phone, String name) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
    }
}
