package courier;

public class InvalidLocationException extends Exception{
    public  InvalidLocationException(){
        super("The state contain non west Malaysia state value. Please contact admin.");

    }

}
