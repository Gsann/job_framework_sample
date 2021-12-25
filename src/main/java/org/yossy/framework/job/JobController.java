package org.yossy.framework.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yossy.framework.job.constant.CheckFlg;
import org.yossy.framework.job.constant.JobStatus;
import org.yossy.framework.job.constant.TaskStatus;
import org.yossy.framework.job.exception.JobException;
import org.yossy.framework.job.task.Task;
import org.yossy.framework.job.task.TaskResult;

/**
 * Jobコントローラー.
 * @author yossy
 * @version 1.0
 */
public class JobController {

    // Singleton
    private static JobController instance = new JobController();

    // Task実行前のチェックフラグ. デフォルトはOFF
    private CheckFlg flg = CheckFlg.OFF;

    // Jobのステータス. デフォルトはIDEL
    private JobStatus status = JobStatus.IDEL;

    // JobのSequence. Taskの実行数をカウント
    private int sequence = 0;

    // JobのStep情報を格納.
    private Map<Integer, Task> steps = new HashMap<Integer, Task>();

    // Taskの実行結果を保存.
    private List<TaskResult> taskResult = new ArrayList<TaskResult>();

    /**
     * Singleton Instanceを取得します.
     * @return instance Singleton
     */
    public static JobController getInstance() {
        return instance;
    }

    /**
     * Jobをスタートします.
     * @return this Singleton
     * @throws JobException
     */
    public JobController start() throws JobException {
        if (this.status.equals(JobStatus.RUNNING)) throw new JobException("Failed to start the job.");
        this.status = JobStatus.RUNNING;
        this.flg = CheckFlg.OFF;
        return this;
    }

    /**
     * Job StepにTaskを追加します.
     * @param task タスク
     * @return this Singleton
     * @throws JobException
     */
    public JobController step(Task task) throws JobException {
        if (this.status.equals(JobStatus.IDEL)) throw new JobException("Failed to add task to the job.");
        this.sequence++;
        this.steps.put(sequence, task);
        return this;
    }

    /**
     * Taskを実行します.
     * @param task タスク
     * @return this Singleton
     * @throws JobException
     */
    public JobController run() throws JobException {
        if (this.status.equals(JobStatus.IDEL)) throw new JobException("Failed to run the job.");
        for (Integer sequence: this.steps.keySet()) {
            TaskStatus wkTaskStatus = steps.get(sequence).execute();
            this.taskResult.add(new TaskResult(wkTaskStatus, steps.get(sequence).getClass().getCanonicalName(), sequence));
            if (this.flg.equals(CheckFlg.ON) && wkTaskStatus.equals(TaskStatus.FAILD)) break;
        }
        return this;
    }

    /**
     * Jobを停止します.
     * @return this Singleton
     * @throws JobException
     */
    public JobController stop() throws JobException {
        if (this.status.equals(JobStatus.IDEL)) throw new JobException("Failed to stop the job.");
        this.status = JobStatus.IDEL;
        getResults().stream()
                    .forEach(x -> System.out.printf("step:%d, task:%s, status:%s \n", x.sequence(), x.taskName(), x.status()));
        return this;
    }

    /**
     * Taskの実行結果一覧を取得します.
     * @return this Singleton
     * @throws JobException
     */
    private List<TaskResult> getResults() throws JobException {
        if (this.status.equals(JobStatus.RUNNING)) throw new JobException("Could not get job results.");
        return taskResult;
    }

    /**
     * フラグをONにします.
     * @return this Singleton
     * @throws JobException
     */
    public JobController flgOn() throws JobException {
        if (this.flg.equals(CheckFlg.ON)) throw new JobException("Failed to switch the flag.");
        this.flg = CheckFlg.ON;
        return this;
    }

    /**
     * フラグをOFFにします.
     * @return this Singleton
     * @throws JobException
     */
    public JobController flgOff() throws JobException {
        if (this.flg.equals(CheckFlg.OFF)) throw new JobException("Failed to switch the flag.");
        this.flg = CheckFlg.OFF;
        return this;
    }
}
