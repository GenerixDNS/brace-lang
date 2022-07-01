package lang.brace.compiler.common;

import lang.brace.compiler.common.raw.*;

/**
 * this doc was created on 01.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public final class ConstCompilerRawPool {
    private final ClassBraceRawClusterImpl classRawCluster = new ClassBraceRawClusterImpl();
    private final ConstBraceRawClusterImpl constRawCluster = new ConstBraceRawClusterImpl();
    private final FunBraceRawClusterImpl funRawCluster = new FunBraceRawClusterImpl();
    private final ImportBraceRawClusterImpl importRawCluster = new ImportBraceRawClusterImpl();
    private final RepoBraceRawClusterImpl repoRawCluster = new RepoBraceRawClusterImpl();

    public ConstCompilerRawPool() {
    }

    public ClassBraceRawClusterImpl getClassRawCluster() {
        return classRawCluster;
    }

    public ConstBraceRawClusterImpl getConstRawCluster() {
        return constRawCluster;
    }

    public FunBraceRawClusterImpl getFunRawCluster() {
        return funRawCluster;
    }

    public ImportBraceRawClusterImpl getImportRawCluster() {
        return importRawCluster;
    }

    public RepoBraceRawClusterImpl getRepoRawCluster() {
        return repoRawCluster;
    }
}
