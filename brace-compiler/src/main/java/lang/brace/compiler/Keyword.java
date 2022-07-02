package lang.brace.compiler;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public enum Keyword {

    /**
     *
     */
    INT("int"),

    /**
     *
     */
    STRING("string"),

    /**
     *
     */
    FINAL("final"),

    /**
     *
     */
    CLASS("class"),

    /**
     *
     */
    INTERFACE("interface"),

    /**
     *
     */
    PRIVATE("private"),

    /**
     *
     */
    PUBLIC("public"),

    /**
     *
     */
    FUN("fun"),

    /**
     *
     */
    VAR("var"),

    /**
     *
     */
    REMOVE("remove"),

    /**
     *
     */
    BOOLEAN("bool"),

    /**
     *
     */
    NATIVE("native"),

    /**
     *
     */
    COMPILER("compiler"),

    /**
     *
     */
    STATIC("static"),

    /**
     *
     */
    LOCATION("loc"),

    /**
     *
     */
    IMPORT("import");

    private final String word;
    private static final LinkedList<Keyword> words = new LinkedList<>(Arrays.asList(Keyword.values()));

    Keyword(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static LinkedList<Keyword> worlds() {
        return Keyword.words;
    }

    public static boolean isIn(String s) {
        for (Keyword value : Keyword.values()) {
            if (value.word.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
