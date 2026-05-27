import org.w3c.dom.NameList;

import java.util.*;


public class PhoneCalls {
    private String source_number;  //defining the number for this bucket
    private List<Call> call_list; //list that holds call

    public PhoneCalls(String phone_number, Boolean use_arraylist) {

        this.source_number = phone_number;

        //if user picked array list, or if user picked linkedlist
        if (use_arraylist) {
            this.call_list = new ArrayList<Call>();

        } else {
            this.call_list = new LinkedList<Call>();
        }
    }


    public List<Call> getCalls() {
        return this.call_list;
    }

    //check if call source number matches the bucket's phone number
    public void add(Call x) {
        if (x.getSourceNumber().equals(this.source_number)) {
            //if so, add it to the list
            this.call_list.add(x);
        } else {
            //or, throw an error
            throw new IllegalArgumentException("call source number does not match");

        }
    }

}

