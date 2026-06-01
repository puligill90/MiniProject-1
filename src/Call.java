public class Call {
    private String sourceNumber;
    private String targetNumber;
    private String date;
    private String time;
    private int duration;

    //Constructor
    public Call(String sourceNumber, String targetNumber,
                String date, String time, int duration){
        this.sourceNumber = sourceNumber;
        this.targetNumber = targetNumber;
        this.date = date;
        this.time = time;
        this.duration = duration;

    }
    public String toString(){
        StringBuffer result = new StringBuffer();

        result.append("Source: ").append(this.sourceNumber).append(" Target: ").append(this.targetNumber).append(" Date: ").
        append(this.date).append(" Time: ").append(this.time).append(" Duration: ").append(this.duration).append("\n");


        return result.toString();
    }

    public String getSourceNumber(){
        return sourceNumber;
    }

    public String getTargetNumber(){
        return targetNumber;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public int getDuration(){
        return duration;
    }
}
