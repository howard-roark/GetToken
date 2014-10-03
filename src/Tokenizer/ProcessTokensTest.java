package Tokenizer;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class ProcessTokensTest {

    /* Data files to test Tokenizer*/
    File file;
    File noData;
    File oneLine;

    /* Create ProcessTokens instance to call non-static methods for testing*/
    ProcessTokens pt;

    /**
     * Setup data file to use in test cases.
     */
    @Before
    public void setUp() {
        pt = new ProcessTokens();
        file = new File("/Users/matthewmcguire/Documents/MSUD/Fall_14/CS_3210/GetToken/src/Tokenizer/data.txt");
        noData = new File("/Users/matthewmcguire/Documents/MSUD/Fall_14/CS_3210/GetToken/src/Tokenizer/noData.txt");
        oneLine = new File("/Users/matthewmcguire/Documents/MSUD/Fall_14/CS_3210/GetToken/src/Tokenizer/oneLine.txt");
    }

    /**
     * Test that the file is being read in properly.
     *
     * @throws IOException
     */
    @Test
    public void testFileRead() throws IOException {
        assertEquals((Integer) 25, (Integer)pt.readFile(file));
        assertEquals((Integer) 1, (Integer) pt.readFile(oneLine));
        assertEquals((Integer) 0, (Integer) pt.readFile(noData));
        pt.p("Files Read Correctly");
    }
}