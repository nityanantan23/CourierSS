package courier;

import javax.swing.*;

public class InvalidValueException extends Exception{
    public InvalidValueException(int val,String item){
        JOptionPane.showMessageDialog(null,item+ " has exceded the max value which is "+val +". Please insert a value that is less than "+val+" ",     "Invalid Value",2);
    }

}
