package courier;

public class Staff extends Person{
    //creating a staff
    public Staff(Integer age, Integer phone, String name) throws InvalidNameException, InvalidPhoneException, InvalidAgeException {
        super(age, phone, name);
    }



}
