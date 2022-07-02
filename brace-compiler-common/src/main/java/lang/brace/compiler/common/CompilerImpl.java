package lang.brace.compiler.common;

import lang.brace.compiler.IBraceComponent;
import lang.brace.compiler.ICompiler;
import lang.brace.compiler.IDataCluster;
import lang.brace.compiler.IHandlerPipeline;
import lang.brace.compiler.tools.Info;

import java.io.File;
import java.util.LinkedList;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public class CompilerImpl implements ICompiler {
    private final File directory;
    private final Info info;
    private final IHandlerPipeline handlerPipeline = new HandlerPipelineImpl(this);
    private final LinkedList<IBraceComponent> components = new LinkedList<>();
    private final IDataCluster dataCluster = new DataClusterImpl();

    public CompilerImpl(File directory, Info info) {
        this.directory = directory;
        this.info = info;
    }

    @Override
    public LinkedList<IBraceComponent> getComponents() {
        return components;
    }

    @Override
    public IDataCluster getDataCluster() {
        return this.dataCluster;
    }

    @Override
    public Info getInfo() {
        return info;
    }

    @Override
    public File getDirectory() {
        return directory;
    }

    @Override
    public IHandlerPipeline getHandlerPipeline() {
        return this.handlerPipeline;
    }

}
