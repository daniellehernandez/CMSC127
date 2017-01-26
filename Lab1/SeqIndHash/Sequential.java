/**
 * Created by DanielleHernandez on 1/26/2017.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Sequential {

    public static void main(String[] args) {
        BufferedReader br = null;
        List<String> DataBase = new ArrayList<String>();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("OriginalSequence.txt")); //Adds data to arraylist for accessing later
            while ((sCurrentLine = br.readLine()) != null) {
                DataBase.add(sCurrentLine);
            }

            Scanner sc = new Scanner(System.in); // Get input from user
            System.out.println("Add to List: ");
            String addThis = sc.next();

            DataBase.add(addThis); //Adds the input name

            List<String> sortedNames = DataBase.stream().sorted().collect(Collectors.toList()); //Sorter

                try {

                    File file = new File("SequentialOutput.txt");
                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    int z = 0;
                    for (String print : sortedNames) {
                        bw.write(print+""); //Output the sorted list
                        bw.newLine();
                    }

                    bw.close();
                    System.out.println("Done");

                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
