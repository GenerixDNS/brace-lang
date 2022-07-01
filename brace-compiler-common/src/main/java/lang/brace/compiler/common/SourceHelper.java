package lang.brace.compiler.common;

import lang.brace.compiler.common.tools.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public class SourceHelper {

    /**
     *
     * outputs all issues with their beginning and end index.
     *
     * @param source raw source
     * @param ch target chars
     * @return a list that contains pairs, with the start and end indexes.
     */
    public static List<Pair<Integer, Integer>> indexes(String source, String ch) {
        List<Pair<Integer, Integer>> catcher = new LinkedList<>();
        char[] chars = source.toCharArray();
        char[] chChars = ch.toCharArray();
        int i = 0;
        StringBuilder helper = new StringBuilder("");
        int r = 0;
        int begin = 0;
        boolean b = false;
        for (char c : chars) {
            if (b) {
                if (chChars[r] == c) {
                    helper.append(c);
                    r++;
                    if (helper.toString().equals(ch)) {
                        catcher.add(new Pair<>(begin, i));
                        helper = new StringBuilder("");
                        r = 0;
                        begin = 0;
                        b = false;
                    }
                } else {
                    helper = new StringBuilder("");
                    r = 0;
                    begin = 0;
                    b = false;
                }
            } else {
                if (chChars[0] == c) {
                    if (chChars.length != 1) {
                        helper.append(c);
                        b = true;
                        begin = i;
                        r++;
                    } else {
                        catcher.add(new Pair<>(i, i));
                    }
                }
            }
            i++;
        }
        return catcher;
    }

    /**
     *
     * deletes from one part of the sources to the other
     *
     * @param source raw source
     * @param start string
     * @param end string
     * @return the edited string
     */
    public static String removePeriod(String source, String start, String end) {
        StringBuilder stringBuilder = new StringBuilder(source);
        List<Pair<Integer, Integer>> starts = indexes(source, start);
        List<Pair<Integer, Integer>> ends = indexes(source, end);
        for (int i = 0; i <= starts.size(); i++) {
            if (starts.get(i) != null && ends.get(i) != null) {
                stringBuilder.delete(
                        starts.get(i).getFirst(),
                        ends.get(i).getFirst());
            } else return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    /**
     *
     * makes a cluster from one character to one.
     *
     * @param source raw source
     * @param ch target char
     * @return the edited string
     */
    public static String clusterOne(String source, char ch) {
        char[] chars = source.toCharArray();
        String[] edit = source.split("");
        boolean b = false;
        int i = 0;
        for (char c : chars) {
            if (b) {
                if (c == ch) {
                    edit[i] = "";
                } else {
                    b = false;
                }
            } else {
                if (c == ch) {
                    b = true;
                }
            }
            i++;
        }
        return toString(edit);
    }

    /**
     *
     * transform array to string
     *
     * @param array string array
     * @return string out of array
     */
    public static String toString(String[] array) {
        StringBuilder s = new StringBuilder();
        for (String s1 : array) {
            s.append(s1);
        }
        return s.toString();
    }

    public static String after(String source, String target) {
        String[] f = clusterOne(source, ' ').split(" ");
        int i = 0;
        for (String s : f) {
            if (s.equals(target)) {
                if (f[i+1] != null) {
                    return f[i+1];
                }
            }
            i++;
        }
        return null;
    }

    public static String afterIgnoreCase(String source, String target) {
        String[] f = clusterOne(source, ' ').split(" ");
        int i = 0;
        for (String s : f) {
            if (s.equalsIgnoreCase(target)) {
                if (f[i+1] != null) {
                    return f[i+1];
                }
            }
            i++;
        }
        return null;
    }

    public static void main(String[] args) {

        String t = "public  static void";
        System.out.println(afterIgnoreCase(t, "public"));

    }

}
