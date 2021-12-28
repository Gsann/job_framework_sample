package org.yossy.framework.chunk.work;

import org.yossy.framework.chunk.reader.InputFileReader;

public interface Worker {
    public String execute(InputFileReader reader);
}
