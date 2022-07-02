package lang.brace.compiler.common.raw;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * this doc was created on 01.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public class ConstBraceRawClusterImpl {
    private final Map<File, String> i = new HashMap<>();

    public Map<File, String> i() {
        return i;
    }
}
