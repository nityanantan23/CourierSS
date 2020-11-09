package courier;

public abstract class Person {
    private Integer age;
    private Integer phone;
    private String name;
    private String spChr = "-/@#$%^&_+=()" ;

    public Person(Integer age, Integer phone, String name) throws InvalidNameException, InvalidPhoneException,InvalidAgeException {
        setAge(age);
        setName(name);
        setPhone(phone);

    }

    public void setName(String name) throws InvalidNameException{

        if (name.matches("[" + spChr + "]+")|| name.matches("[0-9]+")){
            throw new InvalidNameException(name +" is not a valid name. Name cannot contain number and special character");
        }else {
            this.name = name;
        }
    }

    public void setAge(Integer age) throws InvalidAgeException{
        if (age>12&&age<99){
            this.age = age;
        }else {
            throw new InvalidAgeException(age+" is not a valid age. Age should be greater than 12 and lesser than 99.");
        }
    }

    public void setPhone(Integer phone) throws InvalidPhoneException{
        if(String.valueOf(age).length()> 9&&String.valueOf(age).length()< 11){
            this.phone = phone;
        }else{
            throw new InvalidPhoneException(phone +" is not a valid phone number.A phone number can only have a minimum of 9 digits and maximum of 11 digits.");
        }

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getPhone() {
        return phone;
    }
}
