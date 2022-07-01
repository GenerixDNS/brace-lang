package lang.brace.compiler.common.tools;

/**
 * this doc was created on 01.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public class Pair<R, V> {
    private final R first;
    private final V second;

    public Pair(R first, V second) {
        this.first = first;
        this.second = second;
    }

    public R getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
