package kr.rlog.batch.config;

import kr.rlog.batch.account.AccountService;
import kr.rlog.batch.common.MessageUtils;
import kr.rlog.batch.job.UnAuthAccountTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@Slf4j
public class BatchConfig {

	// Batch의 큰 단위
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	// Batch의 Job의 작은 단위
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private AccountService accountService;

	@Bean
	public Tasklet unAuthAccountTask(AccountService accountService) {
		log.info(MessageUtils.getMessage("batch.start"));
		return new UnAuthAccountTask(accountService);
	}

	@Bean
	public Job job() {
		return jobBuilderFactory
				.get("job")
				.start(step())
				.build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.tasklet(unAuthAccountTask(accountService))
				.build();
	}


}
