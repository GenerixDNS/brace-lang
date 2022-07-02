package lang.brace.compiler;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * this doc was created on 02.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public interface IDataCluster {

    public LinkedHashMap<IBraceComponent, String> getLocations();

    public LinkedHashMap<IBraceComponent, LinkedList<String>> getImports();

    public IDataCluster addLastImport(IBraceComponent component, String importT);

}
