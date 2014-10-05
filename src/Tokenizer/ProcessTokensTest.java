package Tokenizer;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class ProcessTokensTest {

    /* Data files to test Tokenizer*/
    File file, noData, oneLine;

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
     * Uncomment one file at a time to view output of that file alone.
     */
    @Test
    public void testFileRead() {
        assertEquals((Integer) 25, (Integer)pt.readFile(file));
//        assertEquals((Integer) 1, (Integer) pt.readFile(oneLine));
//        assertEquals((Integer) 0, (Integer) pt.readFile(noData));
        pt.p("INITIAL UNIT TEST RESULT: Files Read Correctly");
    }

    /**
     * Make sure that the Enum KnowTokens is returning the proper value when called.
     */
    @Test
    public void testKnowTokensReturn() {
        assertEquals("^(IF)", KnownTokens.IF.getRegex());
        assertEquals("<= 22", KnownTokens.LT_EQUAL.getTokenAndId());
        pt.p("INITIAL UNIT TEST RESULT: Known Tokens Enums returned properly");
    }

    /**
     * Test the helper method used to avoid calling Pattern and Matcher for each regex operation.
     */
    @Test
    public void testGetTextByPattern() {
        assertEquals("ABC", pt.getTextByPattern("(.*)", "ABC"));
        assertEquals("\"Hello, World!\"", pt.getTextByPattern("(\"(.*?)\")", "\"Hello, World!\""));
        pt.p("INITIAL UNIT TEST RESULT: REGEX helper method parsing strings properly");
    }
}