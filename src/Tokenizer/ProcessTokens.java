package Tokenizer;

/* Import packages necessary for reading in files */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewmcguire on 10/2/14.
 */
public class ProcessTokens {

    /**
     * Read the data file in from the unit tests and call getToken for each line read in.
     *
     * @param f data.txt being passed in from unit test
     * @return
     * @throws IOException
     */
    protected int readFile(File f) throws IOException {
        int count = 0;
        FileInputStream fileInputStream = new FileInputStream(f);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        /* Add each line in the file to a list of Strings so that we can close the stream / reader ASAP */
        String line = null;
        List<String> fileByLine = new ArrayList<String>();
        while ((line = bufferedReader.readLine()) != null) {
            count++;
            fileByLine.add(line);
        }
        getTokens(fileByLine);

        /*Close the stream and reader */
        fileInputStream.close();
        bufferedReader.close();

        return count;
    }

    private void getTokens(List<String> fbl) {

    }

    /**
     * Method to avoid using System.out for every call to print to console.
     *
     * @param item The token that was found
     */
    protected void p(Object item) {
        System.out.println(item);
    }
}
