package courier;

public abstract class Person implements fileReader,IDGenerator{
    protected String id;
    protected String phone;
    protected String name;

    public Person(){}
    public Person(String id,String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
    }
    public void setId(String id){this.id=id;}
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getId(){
        return id;
    }


}


