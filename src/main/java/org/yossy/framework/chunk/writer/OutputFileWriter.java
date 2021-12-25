package org.yossy.framework.chunk.writer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import org.yossy.framework.chunk.file.FileController;

public abstract class OutputFileWriter extends FileController {

    public OutputFileWriter(String uri, Charset charset) {
        super(Paths.get(uri), charset);
    }

    public OutputFileWriter(String uri) {
        this(uri, StandardCharsets.UTF_8);
    }

}
