import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnsortedCallDB {
    private List<Call> List_of_calls;
    private boolean use_arrayList;


    public UnsortedCallDB(boolean use_arrayList){
        this.use_arrayList = use_arrayList;
        if(use_arrayList){
            this.List_of_calls = new ArrayList<>();
        }else {
            this.List_of_calls = new LinkedList<>(); {
            }
        }
    }
    public int size(){
        return this.List_of_calls.size();
    }
    public void index_call(Call x){
        this.List_of_calls.add(x);
    }
    public List<Call> search_calls(String source_number){

        List<Call> relevant_calls;

        if (this.use_arrayList){
            relevant_calls = new ArrayList<>();
        }else {
            relevant_calls = new LinkedList<>();
        }

        for (Call c : this.List_of_calls){
            if(c.getSourceNumber().equals(source_number)){
                relevant_calls.add(c);
            }

        }
        return relevant_calls;
    }
}
