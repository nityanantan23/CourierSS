package courier;

public abstract class Person implements fileReader{
    protected String id;
    protected Integer age;
   protected String phone;
   protected String name;
   protected static final String spChr = "-/@#$%^&_+=()" ;

    public Person(){}


    public Person(String id,String name,Integer age, String phone) {
        setId(id);
        setAge(age);
        setName(name);
        setPhone(phone);
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getId(){
        return id;
    }

    @Override
    public void readFile() {}
    //public void setName(String name) throws InvalidNameException{
//
//        if (name.matches("[" + spChr + "]+")|| name.matches("[0-9]+")){
//            throw new InvalidNameException(name +" is not a valid name. Name cannot contain number and special character");
//        }else {
//            this.name = name;
//        }
//    }




//    public void setAge(Integer age) throws InvalidAgeException{
//        if (age>12&&age<99){
//            this.age = age;
//        }else {
//            throw new InvalidAgeException(age+" is not a valid age. Age should be greater than 12 and lesser than 99.");
//        }
//    }

//    public void setPhone(String phone) throws InvalidPhoneException{
//        if(phone.length()>9&&phone.length()<12&&phone.matches("[0-9]+")){
//            this.phone = phone;
//        }else{
//            throw new InvalidPhoneException(phone +" is not a valid phone number.A phone number can only have a minimum of 9 digits and maximum of 11 digits.");
//        }
//
//    }



}
