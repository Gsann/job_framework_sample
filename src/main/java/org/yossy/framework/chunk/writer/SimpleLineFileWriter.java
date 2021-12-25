package org.yossy.framework.chunk.writer;

import java.nio.charset.Charset;

public class SimpleLineFileWriter extends OutputFileWriter {

    public SimpleLineFileWriter(String uri, Charset charset) {
        super(uri, charset);
    }

    public SimpleLineFileWriter(String uri) {
        super(uri);
    }
}
