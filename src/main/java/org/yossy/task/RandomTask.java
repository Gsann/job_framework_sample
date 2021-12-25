package org.yossy.task;

import java.util.Random;

import org.yossy.framework.job.constant.TaskStatus;
import org.yossy.framework.job.task.Task;

/**
 * Randomな結果を出力するTask.
 */
public class RandomTask implements Task {

    @Override
    public TaskStatus execute() {
        if (50 < (new Random().nextInt(100))) return fail();
        System.out.println("RandomTask is success!");
        return TaskStatus.OK;
    }
    
    /**
     * 失敗時の処理です.
     * @return TaskStatus.NG
     */
    private TaskStatus fail() {
        System.out.println("RandomTask is failed!");
        return TaskStatus.FAILD;
    }
}
