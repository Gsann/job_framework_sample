package org.yossy.framework.chunk.reader;

import java.io.IOException;
import java.nio.charset.Charset;

import org.yossy.framework.chunk.reader.param.ReaderParameter;

public class SimpleLineFileReader extends InputFileReader {

    private String line;
    
    public SimpleLineFileReader(String uri, Charset charset) {
        super(uri, charset);
    }

    public SimpleLineFileReader(String uri) {
        super(uri);
    }

    public boolean isNextLine() {
        try {
            this.line = getReader().readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if (this.line == null) return false;
        return true;
    }

    public ReaderParameter getParam() {
        return new ReaderParameter.Builder().of(this.line).build();
    }
}
