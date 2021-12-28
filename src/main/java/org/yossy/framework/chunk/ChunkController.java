package org.yossy.framework.chunk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import org.yossy.framework.chunk.reader.InputFileReader;
import org.yossy.framework.chunk.work.Worker;
import org.yossy.framework.chunk.writer.OutputFileWriter;

public class ChunkController {

    // Singleton
    private static ChunkController instance = new ChunkController();

    private InputFileReader reader;
    private OutputFileWriter writer;
    private Worker worker;

    /**
     * Singleton Instanceを取得します.
     * @return instance Singleton
     */
    public static ChunkController getInstance() {
        return instance;
    }

    public ChunkController setReader(InputFileReader reader) {
        this.reader = reader;
        return this;
    }

    public ChunkController setWriter(OutputFileWriter writer) {
        this.writer = writer;
        return this;
    }

    public ChunkController setWork(Worker worker) {
        this.worker = worker;
        return this;
    }

    public ChunkController run() throws Exception {
        if (this.reader == null || this.writer == null || this.worker == null) throw new Exception();
        try (BufferedWriter localWriter = Files.newBufferedWriter(this.writer.getPath(), this.writer.getCharset())) {
            while (this.reader.isNextLine()) {
                localWriter.append(this.worker.execute(this.reader));
                localWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return this;
    }

}
