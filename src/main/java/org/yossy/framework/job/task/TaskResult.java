package org.yossy.framework.job.task;

import org.yossy.framework.job.constant.TaskStatus;

/**
 * Taskの実行結果レコード.
 */
public record TaskResult(TaskStatus status, String taskName, int sequence) {
    
}
