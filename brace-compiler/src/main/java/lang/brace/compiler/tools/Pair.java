package lang.brace.compiler.tools;

/**
 * this doc was created on 02.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public record Pair<R, T>(R first, T second) {
    @Override
    public R first() {
        return first;
    }

    @Override
    public T second() {
        return second;
    }
}
