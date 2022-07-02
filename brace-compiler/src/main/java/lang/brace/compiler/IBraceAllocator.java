package lang.brace.compiler;

import java.io.File;
import java.util.List;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public interface IBraceAllocator {

    void allocate(String source, List<String> words);

    void run();

}
