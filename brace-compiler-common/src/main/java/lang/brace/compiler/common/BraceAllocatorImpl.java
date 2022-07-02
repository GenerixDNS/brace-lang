package lang.brace.compiler.common;

import lang.brace.compiler.IBraceAllocator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * this java doc created on 02.07.2022
 * this file belongs to the brace-lang project
 *
 * @author Generix030
 */

public class BraceAllocatorImpl implements IBraceAllocator {

    @Override
    public void allocate(String source, List<String> words) {
    }

    private List<String> allocateImports(String source, List<String> words) {
        List<String> imports = new ArrayList<>();
        int i = 0;
        for (String word : words) {
            if (word.equals("import")) {
                imports.add(words.get(i+1));
            }
            i++;
        }
        return imports;
    }

    @Override
    public void run() {
        for (String source : Compiler.getInstance().getSource()) {
            allocate(source, Arrays.asList(
                    SourceHelper.clusterOne(source, ' ').split(" ")
            ));
        }
    }
}
