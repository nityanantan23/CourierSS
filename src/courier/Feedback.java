package courier;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Feedback implements IDGenerator,fileReader{
    private static Integer Feed=100;
    private String feedbackID;
    private String orderID;
    private String name;
    private String subject;
    private String description;
    private String rating;


    private static ArrayList<Feedback> feedbackAL= new ArrayList<Feedback>();
    public static ArrayList<Feedback> getfeedbackAL(){
        return feedbackAL;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }




    public Feedback(){};

    public Feedback(String orderID, String description, String rating){
        //place all setter method here
        setOrderID(orderID);
        setFeedbackID(generateID());
        setName(name);
        setSubject(subject);
        setDescription(description);
        setRating(rating);
    }

    public void readFile() {
        String[] lineV;
        String line;
        try {
            Scanner scanner = new Scanner(new File("txtFile/Feedback.txt"));
            while (scanner.hasNext()){
                line= scanner.nextLine();
                lineV=line.split(",");
                setFeedbackID(lineV[0]);
                setOrderID(lineV[1]);
                setDescription(lineV[2]);
                setRating(lineV[3]);
                //retrieve matching
                Feedback o= new Feedback(getOrderID(),getDescription(),getRating());
                feedbackAL.add(o);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            pw = new PrintWriter(new File("txtFile/Feedback.txt"));
            for (int i=0;i<feedbackAL.size();i++){
                Feedback o= feedbackAL.get(i);
                pw.println(o.getFeedbackID()+","+o.getOrderID()+","+o.getDescription()+","
                        +o.getRating());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.close();

        }
    }


    public void writeLine() {
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try{
            fw = new FileWriter("txtFile/Feedback.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(getFeedbackID()+","+getOrderID()+","+getDescription()+","
                    +getRating());

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
        feedCounter();
        return ("F"+Feed);
    }

    public static void feedCounter(){
        Feed=Feed+1;
    }


    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
