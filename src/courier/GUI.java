package courier;

import javax.swing.*;
import java.awt.event.KeyEvent;
import org.apache.commons.lang3.ArrayUtils;


abstract public class GUI {
    protected static final Character[] splChr = {'!','-','?','@','#','$','%','^','&','_','+','=','(',')','|','{',
            '}','~','[',']','|',';',':','<','>'};
    protected static final Character[] splChr2 = {'!','-','?','@','#','$','%','^','&','_','+','=','(',')','|','{',
            '}','~','[',']','|',';',':','<','>',',','.','/'};

    public GUI(){}
    public void spCharCheck(KeyEvent e,JTextField inputItem){
        if ((e.getKeyCode()>=48&&e.getKeyCode()<=57||ArrayUtils.contains(splChr2,e.getKeyChar()))){
            JOptionPane.showMessageDialog(null,"No number and special character is allowed.");
            if(inputItem.getText().length()==1){
                inputItem.setText("");
            }else {
                inputItem.setText(inputItem.getText().substring(0,inputItem.getText().length()-1));
                e.consume();
            }
        }
    }

    public void spCharCheck(KeyEvent e,JTextArea inputItem){
        if (ArrayUtils.contains(splChr,e.getKeyChar()) ){
            JOptionPane.showMessageDialog(null,inputItem.getText() +
                    "No special character other than comma" +" , "+ " period"+" . "
                    + "and forward slash"+" / "+" is allowed.");
            if(inputItem.getText().length()==1){
                inputItem.setText("");
            }else {
                inputItem.setText(inputItem.getText().substring(0,inputItem.getText().length()-1));
                e.consume();
            }
        }
    }

      public void numCheck(KeyEvent e,String inputName,JTextField inputItem) {
        if(!((e.getKeyCode()>=48&&e.getKeyCode()<=57)||(e.getKeyCode()>=0 &&e.getKeyCode()<=32)
                ||e.getKeyCode()==127||e.isActionKey()||e.isControlDown()||e.isShiftDown())
                ||ArrayUtils.contains(splChr,e.getKeyChar())){
            JOptionPane.showMessageDialog(null,
                    inputName+" can only contain Number.",
                    "Invalid "+inputName,2);
            //remove  the last input
            if(inputItem.getText().length()==1){
                inputItem.setText("");
            }else {
                inputItem.setText(inputItem.getText().substring(0,inputItem.getText().length()-1));
                e.consume();
            }
            e.consume();
        }
    }
    public void lengthChecker(KeyEvent e,String name,JTextField inputItem,int maxLength) {
        if (inputItem.getText().length()>maxLength){
            JOptionPane.showMessageDialog(null,name+" can only have "
                    +(maxLength+1)+ " digits only","Invalid "+name,2);
            e.consume();
        }
    }

}
