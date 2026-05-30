import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main2 {

    public static void readFile(String filename,
                                UnsortedCallDB db)
            throws FileNotFoundException {



        Scanner in = new Scanner(new File(filename));

        while(in.hasNextLine()){

            String line = in.nextLine();

            String[] parts = line.split(",");

            Call c = new Call(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3],
                    Integer.parseInt(parts[4])
            );

            db.index_call(c);


        }

        in.close();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count_0f_errors = 0;

        System.out.println("Pick the main data structure to use (UnsortedCallDB or SortedCallDB (You need to type 1 or 2)): ");
        String the_main_structure = in.nextLine();
        while (!the_main_structure.equals("1") && !the_main_structure.equals("2")) {
            System.out.println("Wrong number of a structure was picked!!!");
            count_0f_errors++;
            System.out.println("Pick the main data structure to use (UnsortedCallDB or SortedCallDB (You need to type 1 or 2)): ");
            the_main_structure = in.nextLine();
        }

        System.out.println("Pick the type of list to use (ArrayList or LinkedList (You need to type 1 or 2)): ");
        String type_of_list = in.nextLine();
        while (!type_of_list.equals("1") && !type_of_list.equals("2")) {
            System.out.println("Wrong number of a type was picked");
            count_0f_errors++;
            System.out.println("Pick the type of list to use (ArrayList or LinkedList (You need to type 1 or 2)): ");
            type_of_list = in.nextLine();
        }

        System.out.println("Choose a mode ( 1 - a single file or 2 - automated data collection )  ");
        String mode = in.nextLine();
        while (!mode.equals("1") && !mode.equals("2")) {
            System.out.println("Wrong number of a mode was picked");
            count_0f_errors++;
            System.out.println("Choose a mode ( 1 - a single file or 2 - automated data collection )  ");
            mode = in.nextLine();
        }


        System.out.println("Specify the path to the text file containing the calls that will be loaded : ");
        String In_file_name = in.nextLine();




        if (mode.equals("1")) {
            if (the_main_structure.equals("1")) {
                UnsortedCallDB unsorted;
                if (type_of_list.equals("1")) {

                    unsorted = new UnsortedCallDB(true);
                } else {
                    unsorted = new UnsortedCallDB(false);
                }

                boolean switch_loop = false;
                while (!switch_loop) {
                    try {
                        long start = System.nanoTime();
                        readFile(In_file_name, unsorted);
                        long finish = System.nanoTime();
                        double elapsed_time = (finish - start) / 1_000_000_000.0;
                        System.out.printf("The time to index whole file : %.5f \n", elapsed_time);
                        switch_loop = true;


                    } catch (FileNotFoundException e) {
                        System.out.println("File does not exist");
                        count_0f_errors++;
                        System.out.println("Specify the path to the text file containing the calls that will be loaded : ");
                        In_file_name = in.nextLine();

                    }
                }

                System.out.println("What do you want to do ((1) List all calls from number or (2) exit)? : ");
                String num = in.nextLine();

                while (!num.equals("2")) {
                    while (!num.equals("1") && !num.equals("2")) {
                        System.out.println("Your choice does not exist!!");
                        count_0f_errors++;
                        System.out.println("What do you want to do ((1) List all calls from number or (2) exit)? : ");
                        num = in.nextLine();
                    }
                    if (num.equals("1")) {
                        System.out.println("What is a phone number you want to find?: ");
                        String number = in.nextLine();
                        System.out.println(unsorted.search_calls(number));
                        System.out.println("What do you want to do next ((1) List all calls from number or (2) exit)? : ");
                        num = in.nextLine();
                    }

                }
            }
            //Test part
        }else {


            double[] times = new double[5];
            double the_whole_time = 0;
            int size = 0;
            for (int i = 0; i<5; i++){
                if (the_main_structure.equals("1")) {
                    UnsortedCallDB unsorted;
                    if (type_of_list.equals("1")) {

                        unsorted = new UnsortedCallDB(true);
                    } else {
                        unsorted = new UnsortedCallDB(false);
                    }

                    boolean switch_loop = false;
                    while (!switch_loop) {
                        try {
                            long start = System.nanoTime();
                            readFile(In_file_name, unsorted);
                            long finish = System.nanoTime();
                            double elapsed_time = (finish - start) / 1_000_000_000.0;
                            switch_loop = true;
                            size = unsorted.size();
                            times[i] = elapsed_time;
                            the_whole_time += times[i];



                        } catch (FileNotFoundException e) {
                            System.out.println("File does not exist");
                            count_0f_errors++;
                            System.out.println("Specify the path to the text file containing the calls that will be loaded : ");
                            In_file_name = in.nextLine();

                        }
                    }
                }

            }
            Arrays.sort(times);
            if(the_main_structure.equals("1")){
                if(type_of_list.equals("1")){
                    System.out.println("Index: UnsortedCallDB"+", "+"List: ArrayList"+", "+"Size: "+size+", "+"Min: "+ times[0]+", "+"Max: "+ times[4]+", "+"Mean: "+the_whole_time/ times.length+", "+"Median: "+ times[2]);

                }else {
                    System.out.println("Index: UnsortedCallDB"+", "+"List: LinkedList"+", "+"Size: "+size+", "+"Min: "+ times[0]+", "+"Max: "+ times[4]+", "+"Mean: "+the_whole_time/ times.length+", "+"Median: "+ times[2]);
                }



            }


        }



        if (count_0f_errors <= 5) {
            System.out.println("The number of errors are not exceed the limit, good job! ");
        } else if (count_0f_errors <= 10) {
            System.out.println("The number of errors are exceed the limit, be more mindful!");
        } else {
            System.out.println("So many errors have been made, you need to talk with supervisor! ");
        }
    }

}
