package Tokenizer;

import java.util.HashMap;

/**
 * Created by matthewmcguire on 10/2/14.
 */
public class KnownTokens {
    private static final HashMap<Integer, String> TOKENS = new HashMap<Integer, String>();

    /**
     * Builds a map of tokens using key value pairs.  Key is the number that the token is, and the value is the
     * token itself.
     */
    protected static void buildTokenMap() {
        TOKENS.put(1, "IF");
        TOKENS.put(2, "THEN");
        TOKENS.put(4, "FI");
        TOKENS.put(5, "LOOP");
        TOKENS.put(6, "BREAK");
        TOKENS.put(7, "READ");
        TOKENS.put(8, "PRINT");
        TOKENS.put(9, "AND");
        TOKENS.put(10, "OR");
        TOKENS.put(11, ".");
        TOKENS.put(12, ")");
        TOKENS.put(13, "(");
        TOKENS.put(14, "/");
        TOKENS.put(15, "*");
        TOKENS.put(16, "-");
        TOKENS.put(17, "+");
        TOKENS.put(18, "<>");
        TOKENS.put(19, ">");
        TOKENS.put(20, ">=");
        TOKENS.put(21, "=");
        TOKENS.put(22, "<=");
        TOKENS.put(23, "<");
        TOKENS.put(24, ":=");
        TOKENS.put(25, ";");
        TOKENS.put(26, "SPACE");
        TOKENS.put(27, "EOLN");
        TOKENS.put(28, "identifiers");
        TOKENS.put(29, "numbers");
        TOKENS.put(30, "END");
    }

    /**
     * When called will return the value of the token based on the key passed in.
     *
     * @param key
     * @return
     */
    protected String printTokenKV (int key) {
        return TOKENS.get(key) + " : " + key;
    }
}
