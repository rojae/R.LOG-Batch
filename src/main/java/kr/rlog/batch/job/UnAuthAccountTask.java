package kr.rlog.batch.job;

import kr.rlog.batch.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UnAuthAccountTask implements Tasklet, StepExecutionListener {

    private final AccountService accountService;

    @Autowired
    public UnAuthAccountTask(AccountService accountService) {
        this.accountService = accountService;
    }

    // before task
    @Override
    public void beforeStep(StepExecution stepExecution) {
        accountService.printAll();
    }

    // execute task
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        accountService.deleteUnAuthAccount();
        return RepeatStatus.FINISHED;
    }

    // after task
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        accountService.printAll();
        return ExitStatus.COMPLETED;
    }
}