package org.yossy.framework.chunk.file;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileController {
    
    private Path path;
    private Charset charset;
    
    public FileController(Path path, Charset charset) {
        this.path = path;
        this.charset = charset;
    }

    public FileController(Path path) {
        this(path, StandardCharsets.UTF_8);
    }

    public FileController(String uri, Charset charset) {
        this(Paths.get(uri), charset);
    }

    public FileController(String uri) {
        this(Paths.get(uri), StandardCharsets.UTF_8);
    }

    public Path getPath() {
        return this.path;
    }

    public Charset getCharset() {
        return this.charset;
    }
}
