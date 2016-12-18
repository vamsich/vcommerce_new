package com.commercestorefront.content.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commercebase.content.data.PageTemplateData;
import com.commercefacades.facades.PageTemplateFacade;
import com.commercestorefront.controllers.pages.AbstractPageController;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

@Controller
@RequestMapping("/template")
public class PageTemplateController extends AbstractPageController
{
	@Resource(name="pageTemplateFacade")
	PageTemplateFacade pageTemplateFacade;
	
	@Resource(name="jobLauncher")
	JobLauncher jobLauncher;
	
	@Resource(name="pageTemplateImportJob")
	Job job;
	
	public PageTemplateFacade getPageTemplateFacade() {
		return pageTemplateFacade;
	}

	public void setPageTemplateFacade(PageTemplateFacade pageTemplateFacade) {
		this.pageTemplateFacade = pageTemplateFacade;
	}

	@RequestMapping(method= RequestMethod.GET)
	public String createTemplate(Model model)
	{
		return "forms/createTemplate";
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public String saveTemplate(PageTemplateData pageTemplateData)
	{
		pageTemplateFacade.saveModel(pageTemplateData);
		return "success";
	}
	
	@RequestMapping(value="/import",method= RequestMethod.GET)
	@ResponseBody
	public String importPageTemplate()
	{
		try
		{
			JobParameters jobParameters =
					  new JobParametersBuilder()
					  .addLong("time",System.currentTimeMillis()).toJobParameters();
			JobExecution execution= jobLauncher.run(job, jobParameters);
			System.out.println("Job Exit Status : "+ execution.getStatus());
		}
		catch(JobExecutionException e)
		{
			 System.out.println("Job ExamResult failed");
	            e.printStackTrace();
	         return "fail";
		}
		return "success";
	}
}
