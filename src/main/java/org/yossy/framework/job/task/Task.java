package org.yossy.framework.job.task;

import org.yossy.framework.job.constant.TaskStatus;

/**
 * Taskインターフェース.
 * @author yossy
 * @version 1.0
 */
public interface Task {

    /**
     * Taskを実行します.
     * @return TaskStatus(enum)
     */
    public TaskStatus execute();
}
