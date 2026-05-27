import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class SortedCallDB {

    private List<PhoneCalls> PhoneList;
    private Boolean usingArraylist;



    public SortedCallDB(Boolean usingArraylist){
        this.usingArraylist = usingArraylist;
        if(usingArraylist) {
            this.PhoneList = new ArrayList<PhoneCalls>();
        }
        else{
            this.PhoneList = new LinkedList<PhoneCalls>();
        }
    }

    //public List<Call> searchCalls(String source_number){}


}
