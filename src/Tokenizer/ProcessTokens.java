package Tokenizer;

/* Import packages necessary for reading in files */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    protected int readFile(File f) {
        int count = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            /* Add each line in the file to a list of Strings so that we can close the stream / reader ASAP */
            String line = null;
            String[] fileByLine = new String[100];
            while ((line = bufferedReader.readLine()) != null) {
                fileByLine[count] = line;
                count++;
            }
            pullLine(fileByLine);

            /*Close the stream and reader */
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException ioe) {
            System.err.println("Problem Reading File: " + ioe);
        }
        return count;
    }

    /**
     * Pull one line at a time out of the array of data file lines and send to recursive method to
     * be parsed for tokens.
     *
     * @param lines
     */
    private void pullLine(String... lines) {
        for (String line : lines) {
            if (line != null) {
                parseLine(line);
            }
        }
    }

    /**
     * Recursive method to parse each data file line for individual tokens.
     *
     * @param line
     */
    private void parseLine(String line) {
        String token = "";
        while (line.length() > 0) {
            for (KnownTokens kt : KnownTokens.values()) {
                token = getTextByPattern(kt.getRegex(), line);
                if (!token.equals("")) {
                    p(kt.getTokenAndId());
                    parseLine(line.substring(token.length()));
                }
            }
            break;
        }
    }

    protected String getTextByPattern(String regex, String string) {
        String found = "";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        if ((m.find()) && (m.groupCount() > 0)) {
            found = m.group(1);
        }
        return found;
    }

    /**
     * Method to split value of enum so that it can be printed to the console properly.
     *
     * @param knownToken
     */
    private void printTokenAndId(String knownToken) {
        String[] tokenByParts = knownToken.split(":");
        if ((tokenByParts[1] != null) && (tokenByParts[2] != null)) {
            p(tokenByParts[1] + " " + tokenByParts[2]);
        } else {
            p("ERROR: TOKEN NOT READ PROPERLY");
        }
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
