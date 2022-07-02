package lang.brace.compiler.common;

import lang.brace.compiler.IBraceBuffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * this doc was created on 01.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

public class DefaultBraceBufferImpl implements IBraceBuffer {
    private File directory;
    private String name;
    private List<String> output = new LinkedList<>();

    @SuppressWarnings("ConstantConditions")
    public DefaultBraceBufferImpl(File directory) {
        if (directory.isDirectory()) {
            if (directory.listFiles() != null) {
                if (directory.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.equals("meta.xml");
                    }
                })[0] != null) {
                    this.directory = directory;
                    this.name = directory.getName();
                    return;
                }
            }
        }
        throw new UnsupportedOperationException("This filetype has not been recognized as source code");
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void loadIn(File directory) {
        if (directory.isDirectory()) {
            if (directory.listFiles() != null) {
                if (directory.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.equals("meta.xml");
                    }
                })[0] != null) {
                    this.directory = directory;
                    this.name = directory.getName();
                    return;
                }
            }
        }
        throw new UnsupportedOperationException("This filetype has not been recognized as source code");
    }

    @Override
    public IBraceBuffer getOutput() {
        StringBuilder raw = new StringBuilder();
        Path filePath = Paths.get(this.directory.toURI());
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                raw.append(line).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.output.add(raw.substring(0, raw.lastIndexOf("\n")));
        return this;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public String[] getRawOutput() {
        if (this.output != null) {
            Compiler.getInstance().setSource((String[]) this.output.toArray());
            return (String[]) this.output.toArray();
        } else throw new UnsupportedOperationException("An unexpected compiler error has occurred!");
    }

    @Override
    public String getHeader() {
        if (this.name != null)
            return this.name;
        throw new UnsupportedOperationException("An unexpected compiler error has occurred!");
    }

}
