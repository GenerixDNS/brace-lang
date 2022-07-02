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

public interface IBraceComponent {

    /**
     * @return the file of the component.
     */
    File getFile();

    /**
     * @return unique location of this component
     */
    String getLocation();

    /**
     * @return name of this file
     */
    String name();

    /**
     * @return source code of this file
     */
    String[] source();

}
