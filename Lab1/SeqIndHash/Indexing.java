/**
 * Created by DanielleHernandez on 1/26/2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Indexing {

    public static void main(String[] args) {
        BufferedReader br = null;
        List<String> DataBase = new ArrayList<String>();
        String found = "";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("Data.txt")); //Adds data to arraylist for accessing later
            while ((sCurrentLine = br.readLine()) != null) {
                DataBase.add(sCurrentLine);
            }

            Scanner sc = new Scanner(System.in); // Get input form user (Name Search)
            System.out.println("Name Search(Case Sensitive): ");
            String SearchThis = sc.next();

            br = new BufferedReader(new FileReader("Index.txt")); //Scans Index if first letter exist in database
            while ((sCurrentLine = br.readLine()) != null) {
                if(SearchThis.charAt(0) == sCurrentLine.charAt(0)){
                    found = sCurrentLine.charAt(1)+"";
                }
            }

                try{
                    if(DataBase.get(Integer.parseInt(found)).equals(SearchThis)){ //Gets the positon in database then prints it (Case 1 for Viktor) Skips Directly
                        System.out.println(DataBase.get(Integer.parseInt(found)));
                    } else {
                        int ct = Integer.parseInt(found);
                        while(DataBase.get(ct).charAt(0) == SearchThis.charAt(0)){
                            if(DataBase.get(ct).equals(SearchThis)){ //Only in cases where first letter matches with others ... then a search begins (Case 2 when searching for Steven | S1)
                                System.out.println(DataBase.get(ct));
                            }
                            ct++;
                        }
                    }
                } catch (Exception e){
                    //Do nothing
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
