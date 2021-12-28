package org.yossy.task;

import org.yossy.framework.job.constant.TaskStatus;
import org.yossy.framework.job.task.Task;

public class HiroakiTask implements Task {

    @Override
    public TaskStatus execute() {
        return TaskStatus.OK;
    }
    
}
