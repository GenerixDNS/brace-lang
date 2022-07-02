package lang.brace.compiler;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public interface BraceHandler {

    /**
     *
     * handler to compile code
     *
     * @param words source code
     * @param component source
     */
    void handle(String[] words, IBraceComponent component, IHandlerPipeline pipeline);

}
