import org.w3c.dom.NameList;

import java.util.*;


public class PhoneCalls { //declaring phonecalls
    private String sourceNumber;  //defining the number for this bucket
    private List<Call> call_list; //stores all calls made from that phone number, typed as a list

    public PhoneCalls(String phone_number, Boolean use_arraylist) {
        //Constructor takes the phone numbers and a boolean for list type

        this.sourceNumber = phone_number;

        //saves the phone number into the field

        //if user picked array list, or if user picked linkedlist
        if (use_arraylist) { // checking which list type the user picks
            this.call_list = new ArrayList<Call>();

            //either creating an arraylist or linkedlist
        } else {
            this.call_list = new LinkedList<Call>();
        }
    }

    public String getSourceNumber(){

        //so that other classes can read the phone number
        return this.sourceNumber;
    }


    public List<Call> getCalls() {

        //so that other classes can read the call list
        return this.call_list;
    }

    //check if call source number matches the bucket's phone number
    public void add(Call x) {
        if (x.getSourceNumber().equals(this.sourceNumber)) {
            //if so, add it to the list
            this.call_list.add(x);
        } else {
            //or, throw an error
            throw new IllegalArgumentException("call source number does not match");

        }
    }

}

