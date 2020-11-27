package courier;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person{
    private String ic;
    private static ArrayList<Customer> customerAl= new ArrayList<>();
    private static int cusCount = 100;

    public Customer(){}
    public Customer(String id,String name,  String phone ,String ic){
        super(id,name, phone);
        setIc(ic);
        generateID();
    }

    public String getIc() {
        return ic;
    }
    public void setIc(String ic) {
        this.ic = ic;
    }
    public static ArrayList<Customer> getCustomerAL(){
        return customerAl;
    }

    @Override
    public void readFile() {
        String line;
        String[] lineV;
        try {
            Scanner s= new Scanner(new File("txtFile/Customer.txt"));
            while (s.hasNext()){
                //read single line first
                line=s.nextLine();
                //split the line and store it as array
                lineV= line.split(",");
                //assigning the read variable to the object.
                setId(lineV[0]);
                setName(lineV[1]);
                setPhone(lineV[2]);
                setIc(lineV[3]);
                Customer c= new Customer(getId(),getName(),getPhone(),getIc());
                customerAl.add(c);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Customer.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(getId()+","+getName()+","+getPhone()+","+getIc());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
                bw.close();
                fw.close();

            } catch (IOException e) { //instances where the i/o cannot be close
                e.printStackTrace();
            }
        }
    }

    @Override
    public String generateID() {
        cusCount=cusCount+1;
        return ("C"+cusCount);
    }

    @Override
    public void writeFile() {

    }




}
