package org.yossy.work;

import org.yossy.framework.chunk.work.Worker;

public class TwiceLineWorker implements Worker {

    @Override
    public String execute(String line) {
        return line + line;
    }
    
}
