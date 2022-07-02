package lang.brace.compiler;

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

public interface ICompiler {

    /**
     *
     * info of the project that is compiled.
     *
     * @return info
     */
    public Info getInfo();

    /**
     *
     * info of the project that is compiled.
     *
     * @return file as directory
     */
    public File getDirectory();

    /**
     *
     * in this pipeline there are several handlers which allow the reading of the code.
     *
     * @return current handler pipeline
     */
    public IHandlerPipeline getHandlerPipeline();

    /**
     *
     * components are a part of the project and are there for object-organized programming.
     *
     * @return component list
     */
    public LinkedList<IBraceComponent> getComponents();

    /**
     *
     * @return
     */
    public IDataCluster getDataCluster();

}
