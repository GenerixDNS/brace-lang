package lang.brace.compiler.common;

import lang.brace.compiler.ICompiler;
import lang.brace.compiler.IProjectInterface;
import lang.brace.compiler.tools.Info;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 * @since BDK 1.0
 *
 */

public class ProjectInterfaceImpl implements IProjectInterface {
    private File directory;
    private Info info;

    @Override
    public IProjectInterface input(File directory) {
        if (directory.isDirectory()) {
            if (this.directory.listFiles((dir, name) -> name.equals("info.xml")) != null) {
                try {
                    JAXBContext jaxbContext = JAXBContext.newInstance(Info.class);
                    File file = new File(directory.getAbsolutePath() + "\\" + "info.xml");
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    this.info = (Info) unmarshaller.unmarshal(file);
                    this.directory = directory;
                } catch (JAXBException e) {
                    throw new RuntimeException("An unexpected error has occurred!");
                }
            } else {
                throw new NullPointerException("The info.xml file could not be found!");
            }
        } else {
            throw new UnsupportedOperationException("This file type could not be supported!");
        }
        throw new NullPointerException("An unexpected error has occurred!");
    }

    @Override
    public ICompiler compile() {
        if (this.directory != null && this.info != null) {
            synchronized (this) {
                return new CompilerImpl(directory, this.info);
            }
        } else {
            throw new NullPointerException("An unexpected error has occurred!");
        }
    }

}
