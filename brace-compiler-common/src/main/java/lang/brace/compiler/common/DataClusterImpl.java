package lang.brace.compiler.common;

import lang.brace.compiler.IBraceComponent;
import lang.brace.compiler.IDataCluster;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * this doc was created on 02.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public class DataClusterImpl implements IDataCluster {
    private final LinkedHashMap<IBraceComponent, String> locations = new LinkedHashMap<>();
    private final LinkedHashMap<IBraceComponent, LinkedList<String>> imports = new LinkedHashMap<>();

    @Override
    public LinkedHashMap<IBraceComponent, String> getLocations() {
        return locations;
    }

    @Override
    public LinkedHashMap<IBraceComponent, LinkedList<String>> getImports() {
        return imports;
    }

    @Override
    public IDataCluster addLastImport(IBraceComponent component, String importT) {
        if (this.imports.containsKey(component)) {
            this.imports.get(component).addLast(importT);
        } else {
            this.imports.put(component, new LinkedList<>(Collections.singletonList(importT)));
        }
        return this;
    }

}

