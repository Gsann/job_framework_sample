package org.yossy.task;

import org.yossy.framework.job.constant.TaskStatus;
import org.yossy.framework.job.task.Task;

/**
 * Hello World Task.
 * @author yossy
 * @version 1.0
 */
public class HelloTask implements Task {

    @Override
    public TaskStatus execute() {
        System.out.println("Hello World!");
        return TaskStatus.OK;
    }
    
}
