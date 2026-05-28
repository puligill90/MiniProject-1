import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
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
        System.out.println(" Pick the type of list to use (ArrayList or LinkedList (You need to type 1 or 2)): ");
        String type_of_list = in.nextLine();
        System.out.println("Pick the main data structure to use (UnsortedCallDB or SortedCallDB (You need to type 1 or 2)): ");
        String the_main_structure = in.nextLine();
        System.out.println("Specify the path to the text file containing the calls that will be loaded : ");
        String In_file_name = in.nextLine();



        if (type_of_list.equals("1")){
            if(the_main_structure.equals("1")){
                UnsortedCallDB unsorted = new UnsortedCallDB(true);
                long start = System.nanoTime();
                try {
                    readFile(In_file_name, unsorted);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                long finish = System.nanoTime();
                double elapsed_time = (finish - start) / 1_000_000_000.0;
                System.out.printf("The time to index whole file : %.5f \n", elapsed_time);
                System.out.println("What do you want to do ((1) List all calls from number or (2) exit)? : ");
                String num = in.nextLine();
                while (!num.equals("2")){
                    System.out.println("What is a phone number you want to find?: ");
                    String number = in.nextLine();
                    System.out.println(unsorted.search_calls(number));
                    System.out.println("What do you want to do next ((1) List all calls from number or (2) exit)? : ");
                    num = in.nextLine();

                }

            }else {
                SortedCallDB sorted = new SortedCallDB(true);

            }
        }else {
            if (the_main_structure.equals("2")) {
                UnsortedCallDB unsorted = new UnsortedCallDB(false);
                long start = System.nanoTime();
                try {
                    readFile(In_file_name, unsorted);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                long finish = System.nanoTime();
                double elapsed_time = (finish - start) / 1_000_000_000.0;
                System.out.printf("The time to index whole file : %.5f \n", elapsed_time);
                System.out.println("What do you want to do ((1) List all calls from number or (2) exit)? : ");
                String num = in.nextLine();
                while (!num.equals("2")){
                    System.out.println("What is a phone number you want to find?: ");
                    String number = in.nextLine();
                    System.out.println(unsorted.search_calls(number));
                    System.out.println("What do you want to do next ((1) List all calls from number or (2) exit)? : ");
                    num = in.nextLine();

                }
            }else {
                SortedCallDB sorted = new SortedCallDB(false);
            }

            }
        }
    }
