package org.yossy;

import org.yossy.framework.chunk.ChunkController;
import org.yossy.framework.chunk.reader.CsvFileReader;
import org.yossy.framework.chunk.writer.SimpleLineFileWriter;
import org.yossy.work.CsvWorker;

/**
 * Main Class
 *
 */
public class App 
{

    public static void main( String... args ) throws Exception
    {
        ChunkController.getInstance()
                        .setReader(new CsvFileReader("/workspaces/job_framework_sample/src/main/resource/file/input_data.txt"))
                        .setWriter(new SimpleLineFileWriter("/workspaces/job_framework_sample/src/main/resource/file/output_data.txt"))
                        .setWork(new CsvWorker())
                        .run();
    }
}
