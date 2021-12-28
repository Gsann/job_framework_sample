package org.yossy.framework.chunk.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yossy.framework.chunk.file.FileController;
import org.yossy.framework.chunk.reader.param.ReaderParameter;

public abstract class InputFileReader extends FileController {

    private BufferedReader reader;
    private InputStream stream;

    public InputFileReader(String uri, Charset charset) {
        super(Paths.get(uri), charset);
        setReader();
        setStream();
    }

    public InputFileReader(String uri) {
        this(uri, StandardCharsets.UTF_8);
    }

    private void setReader() {
        try {
            this.reader = Files.newBufferedReader(getPath(), getCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setStream() {
        try {
            this.stream = Files.newInputStream(getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedReader getReader() {
        return this.reader;
    }

    protected InputStream getStream() {
        return this.stream;
    }

    public abstract boolean isNextLine() throws IOException;

    public abstract ReaderParameter getParam();

}
