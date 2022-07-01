package lang.brace.compiler;

import java.io.File;

/**
 *
 * This class belongs to the brace-lang project
 *
 * <p>
 *     This is where the source code is compressed.
 * </p>
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public interface IBraceBuffer {

    /**
     *
     * sets the source
     *
     * @param directory source dir
     */
    void loadIn(File directory);

    /**
     *
     * load project to string
     *
     * @return this
     */
    IBraceBuffer getOutput();

    /**
     *
     * compiled output
     *
     * @return compiled project
     */
    String getRawOutput();

    /**
     *
     * name of this source directory
     *
     * @return header
     */
    String getHeader();

}
