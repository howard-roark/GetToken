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

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                getToken(line);
                if (!line.equals("END")) {//Do not print EOL when it is the END statement.
                    p(KnownTokens.EOLN.getTokenAndId());
                }
                count++;
            }
            /* File is at End of Document */
            p(KnownTokens.END_DOC.getTokenAndId());

            /*Close the stream and reader */
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException ioe) {
            System.err.println("Problem Reading File: " + ioe);
        }
        return count;
    }

    /**
     * Recursive method to parse each data file line for individual tokens.
     *
     * @param line
     */
    private String getToken(String line) {
        String token = "";
        if (line.length() != 0) {
            for (KnownTokens kt : KnownTokens.values()) {
                token = getTextByPattern(kt.getRegex(), line);
                if (!token.equals("")) {

                    if ((kt.getTokenId() != 27) && (kt.getTokenId() != 31)) {//EOL and EOD handled in readFile
                        p(kt.getTokenAndId());
                    }

                    if ((kt.getTokenId() == 29) || (kt.getTokenId() == 30)) {//Print the actual string and numbers
                        p("\t|__VALUE IS: " + token);
                    }
                    getToken(line.substring(token.length()));
                    break;
                }
            }
        }
        return line;
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
     * Method to avoid using System.out for every call to print to console.
     *
     * @param item The token that was found
     */
    protected void p(Object item) {
        System.out.println(item);
    }
}