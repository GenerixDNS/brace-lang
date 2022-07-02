package lang.brace.compiler.common;

import lang.brace.compiler.BraceHandler;
import lang.brace.compiler.IBraceComponent;
import lang.brace.compiler.ICompiler;
import lang.brace.compiler.IHandlerPipeline;

import java.util.LinkedList;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public class HandlerPipelineImpl implements IHandlerPipeline {
    private final ICompiler compiler;
    private final LinkedList<BraceHandler> handlers = new LinkedList<>();

    public HandlerPipelineImpl(ICompiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public IHandlerPipeline addLast(BraceHandler handler) {
        this.handlers.addLast(handler);
        return this;
    }

    @Override
    public IHandlerPipeline run() {
        synchronized (this) {
            for (IBraceComponent component : this.compiler.getComponents()) {
                for (BraceHandler handler : this.handlers) {
                    handler.handle(component.source(), component, this);
                }
            }
        }
        return this;
    }

    @Override
    public ICompiler getCompiler() {
        return this.compiler;
    }
}
