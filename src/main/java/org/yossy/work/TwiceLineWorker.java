package org.yossy.work;

import org.yossy.framework.chunk.reader.InputFileReader;
import org.yossy.framework.chunk.reader.param.ReaderParameter;
import org.yossy.framework.chunk.work.Worker;

public class TwiceLineWorker implements Worker {

    @Override
    public String execute(InputFileReader reader) {
        ReaderParameter param = reader.getParam();
        return param.line() + param.line();
    }    
}
