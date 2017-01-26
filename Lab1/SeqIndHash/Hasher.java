/**
 * Created by DanielleHernandez on 1/26/2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Hasher {

    public static void main(String[] args) {

        BufferedReader br = null;
        List<Integer> hashed = new ArrayList<Integer>();

        try {

            String sCurrentLine;
            br = new BufferedReader(new FileReader("Names.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                int n = 0;
                int prev = 0;
                int a = 0;

                while(n != sCurrentLine.length()){
                    prev = sCurrentLine.charAt(n) * 7; //HASH METHOD: Multiply ASCII per char by 7 (Prime number for randomness) then add all characters.
                    a += prev;
                    n++;
                }
                hashed.add(a); //Add to array
            }

                    try {

                        File file = new File("HashedNames.txt");
                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        int z = 0;
                        for (Integer print : hashed) {
                            bw.write(print+"");
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
