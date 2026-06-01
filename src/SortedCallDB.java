import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class SortedCallDB {


    //the filing cabinet class
    private List<PhoneCalls> phoneList;
    private Boolean usingArraylist;



    public SortedCallDB(Boolean usingArraylist){
        this.usingArraylist = usingArraylist;
        if(usingArraylist) {
            this.phoneList = new ArrayList<PhoneCalls>();
        }
        else{
            this.phoneList = new LinkedList<PhoneCalls>();
        }
    }

    public List<Call> search_calls(String sourceNumber){

        //method that takes a phone number and returns a list of calls

        int low = 0;
        int high = this.phoneList.size()-1;


        while(low <= high){
            //prevents overflow
            int mid = low + (high-low)/2;

            int get = phoneList.get(mid).getSourceNumber().compareTo(sourceNumber);

            if (get == 0){
                return phoneList.get(mid).getCalls();}
            else if (get < 0) {
                low = mid + 1;
            }else{
                high = mid - 1;


            }
        }
        return new ArrayList<Call>();
    }


    public void index_call(Call x){

        String Ph = x.getSourceNumber();


        for (int i = 0; i < phoneList.size(); i++) {
            if (x.getSourceNumber().compareTo(phoneList.get(i).getSourceNumber()) == 0) {
                phoneList.get(i).add(x);
                return;

            } else if ((x.getSourceNumber().compareTo(phoneList.get(i).getSourceNumber()) < 0)) {
                PhoneCalls newDrawer = new PhoneCalls(x.getSourceNumber(), this.usingArraylist);
                newDrawer.add(x);
                phoneList.add(i, newDrawer);
                return;}
            }

        PhoneCalls newDrawer = new PhoneCalls(x.getSourceNumber(), this.usingArraylist);
        newDrawer.add(x);
        phoneList.add(newDrawer);


        }




    }

