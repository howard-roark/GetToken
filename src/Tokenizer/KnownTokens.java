package Tokenizer;

/**
 * Enum KnownTokens will be the object that holds values of the Tokens we are looking to parse, the regular expressions
 * needed to parse those tokens and the id's of the tokens.
 *
 * Created by matthewmcguire on 10/4/14.
 */
public enum KnownTokens {
    IF("^(IF)", "IF", 1),
    THEN("^(THEN)", "THEN", 2),
    ELSE("^(ELSE)", "ELSE", 3),
    FI("^(FI)", "FI", 4),
    LOOP("^(LOOP)", "LOOP", 5),
    BREAK("^(BREAK)", "BREAK", 6),
    READ("^(READ)", "READ", 7),
    PRINT("^(PRINT)", "PRINT", 8),
    AND("^(AND)", "AND", 9),
    OR("^(OR)", "OR", 10),
    PERIOD("^(\\.)", "PERIOD", 11),
    OPEN_PAREN("^(\\()", "(", 12),
    CLOSE_PAREN("^(\\))", ")", 13),
    BACK_SLASH("^(\\/)", "/", 14),
    STAR("^(\\*)", "*", 15),
    DASH("^(\\-)", "-", 16),
    PLUS("^(\\+)", "+", 17),
    NOT_EQUAL("^(\\<\\>)", "<>", 18),
    GREAT_THAN("^(\\>)", ">", 19),
    GREAT_EQUAL("^(\\>\\=)", ">=", 20),
    EQUAL("^(\\=)", "=", 21),
    LT_EQUAL("^(\\<\\=)", "<=", 22),
    LESS_THAN("^(\\<)", "<", 23),
    ASSIGN("^(\\:\\=)", ":=", 24),
    SEMI_COLON("^(\\;)", ";", 25),
    SPACE("^([\\s])", "SPACE", 26),
    EOLN("^(\\n)", "EOLN", 27),
    END_DOC("^(END)", "END", 31),
    NUMS_WITH_BOTH("^([0-9]+\\.[0-9]+)", "numbers", 29),
    NUMS_WITH_LEFT("^([0-9]+\\.)", "numbers", 29),
    NUMS_WITH_RIGHT("^(\\.[0-9]+)", "numbers", 29),
    NUMS("^([0-9]+)", "numbers", 29),
    STRING("(\"(.*?)\")", "string", 30),
    IDS("^([A-Z]+)", "identifiers", 28);

    /* Instance Variables needed when constructing each KnowToken */
    private String regex, token;
    private int tokenId;

    /**
     * Build enum so that when called from ProcessTokens the proper data will be available.
     *
     * @param regex
     * @param token
     * @param tokenId
     */
    private KnownTokens(String regex, String token, int tokenId) {
        this.regex = regex;
        this.token = token;
        this.tokenId = tokenId;
    }

    /**
     * Return the REGEXP needed to parse token from data file line.
     *
     * @return
     */
    public String getRegex() {
        return regex.trim();
    }

    /**
     * Return the token and token id so that it can be printed to the console appropriately.
     *
     * @return
     */
    public String getTokenAndId() {
        return token + " " + tokenId;
    }

    /**
     * Return the value of tokenId.
     *
     * @return
     */
    public int getTokenId() { return tokenId; }
}
