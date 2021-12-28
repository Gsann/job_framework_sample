package org.yossy.framework.chunk.reader;

import java.io.IOException;

import org.yossy.framework.chunk.reader.param.ReaderParameter;

public class CsvFileReader extends InputFileReader {

    private ReaderParameter param;

    public CsvFileReader(String uri) {
        super(uri);
    }

    public boolean isNextLine() {
        try {
            this.param = getReader().readLine() == null ?
                                            null : 
                                            new ReaderParameter.Builder().of(getReader().readLine()).setValues().build();
            if (this.param == null) return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ReaderParameter getParam() {
        return this.param;
    }
    
}
