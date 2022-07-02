package lang.brace.compiler.common;

/**
 * this doc was created on 01.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public class Compiler {
    private static final Compiler instance = new Compiler();
    private String[] source;
    private final ConstCompilerRawPool rawPool = new ConstCompilerRawPool();

    public Compiler() {
    }

    public ConstCompilerRawPool getRawPool() {
        return rawPool;
    }

    public static Compiler getInstance() {
        return instance;
    }

    public String[] getSource() {
        return source;
    }

    public void setSource(String[] source) {
        this.source = source;
    }
}
