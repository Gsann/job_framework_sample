package org.yossy.work;

import org.yossy.framework.chunk.reader.InputFileReader;
import org.yossy.framework.chunk.reader.param.ReaderParameter;
import org.yossy.framework.chunk.work.Worker;

public class CsvWorker implements Worker {

    @Override
    public String execute(InputFileReader reader) {
        ReaderParameter param = reader.getParam();
        String[] values = param.values();
        StringBuffer buf = new StringBuffer();
        for (String value : values) {
            buf.append(value + value + ",");
        }
        return buf.toString();
    }
    
}
