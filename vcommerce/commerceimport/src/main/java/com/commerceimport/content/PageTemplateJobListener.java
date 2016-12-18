package com.commerceimport.content;

import java.util.Date;
import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
public class PageTemplateJobListener implements JobExecutionListener
{

	public void afterJob(JobExecution jobExecution) 
	{

		if(jobExecution.getStatus()== BatchStatus.COMPLETED)
		{
			Date startTime= new Date();
			System.out.println("Page Template job ends at "+startTime);
		}
		
		if(jobExecution.getStatus()== BatchStatus.FAILED)
		{
			Date startTime= new Date();
			System.out.println("Page Template job Failed at "+startTime);
			
			 List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
	            for(Throwable th : exceptionList){
	                System.err.println("exception :" +th.getLocalizedMessage());
	            }
		}
	
	}

	public void beforeJob(JobExecution jobExecution) 
	{
		Date startTime= new Date();
		System.out.println("Page Template job starts at "+startTime);
	}
}
