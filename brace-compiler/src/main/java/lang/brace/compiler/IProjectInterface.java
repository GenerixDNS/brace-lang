package lang.brace.compiler;

import java.io.File;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public interface IProjectInterface {

    /**
     *
     * insert the source in the project
     *
     * @param directory project directory
     * @return this object
     */
    IProjectInterface input(File directory);

    /**
     *
     * starts the compiler
     *
     * @return the corresponding compiler
     */
    ICompiler compile();

}
