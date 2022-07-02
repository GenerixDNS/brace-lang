package lang.brace.compiler.common.handlers;

import lang.brace.compiler.BraceHandler;
import lang.brace.compiler.IBraceComponent;
import lang.brace.compiler.IHandlerPipeline;
import lang.brace.compiler.Keyword;

/**
 * this doc was created on 02.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public class HeadHandler implements BraceHandler {

    @Override
    public void handle(String[] words, IBraceComponent component, IHandlerPipeline pipeline) {
        int i = 0;
        int locI = -1;
        int first = -1;
        for (String word : words) {
            if (word.equals(Keyword.LOCATION.toString())) {
                if (first == -1) {
                    if (Keyword.isIn(words[i+1])) {
                        if (words[i+1] != null) {
                            throw new UnsupportedOperationException("A syntax error has occurred! | " + words[i + 1]);
                        } else {
                            throw new UnsupportedOperationException("A syntax error has occurred!");
                        }
                    }
                    locI = i;
                    pipeline.getCompiler()
                            .getDataCluster()
                            .getLocations()
                            .put(component, words[i+1]);
                }
            } else if (word.equals(Keyword.IMPORT.toString())) {
                if (locI != -1) {
                    if (Keyword.isIn(words[i+1])) {
                        if (words[i+1] != null) {
                            throw new UnsupportedOperationException("A syntax error has occurred! | " + words[i + 1]);
                        } else {
                            throw new UnsupportedOperationException("A syntax error has occurred!");
                        }
                    }
                    pipeline.getCompiler()
                            .getDataCluster()
                            .addLastImport(component, words[i+1]);
                }
            }
            if (first == -1) first = i;
            i++;
        }
    }

}
