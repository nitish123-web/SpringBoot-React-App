package com.example.demo.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.JobPost;

@Repository
public class JobRepo {
	
	List<JobPost> jobs=new ArrayList<>(Arrays.asList(

			new JobPost(101,"Java Developer","Must have a good DSA skills ",2,List.of("Core Java","J2EE" ,"SpringBoot","Hibernate")),
			new JobPost(102,"Dot Net Developer","Must have ASP.NET knowlwdge",3,List.of(".NET","C#","FRONTEND","Azure")),
			new JobPost(103,"NodeJs Developer","Must have express js knowledge",4,List.of("JavaScript","VueJs","ReactJS")),
			new JobPost(104,"Oracle plsql developer","Must know SQL and PLSQL developer",2,List.of("Oracle Sql","Oracle PLSQL","Oracle Apex"))
			
			));
	
	public List<JobPost> getalljobs(){
		
		return jobs;
		
	}
	
	public void addjob(JobPost job) {
		jobs.add(job);
		System.out.println(jobs);
		
	}

	public JobPost getJob(int postid) {
		
		for(JobPost job: jobs) {
			if(job.getPostId()==postid) {
				return job;
			}
		}
		
		
		return null;
	}

	public void updatejob(JobPost job) {

		for(JobPost jobz : jobs) {
			
			if(jobz.getPostId() == job.getPostId()) {
				
				jobz.setPostProfile(job.getPostProfile());
				jobz.setPostDesc(job.getPostDesc());
				jobz.setReqExperience(job.getReqExperience());
				jobz.setPostTechStack(job.getPostTechStack());
				
				
				
			}
			
		}
		
	}

	public void deletejob(int PostId) {

		for(JobPost jobss : jobs) {
			if(jobss.getPostId() == PostId) {
				
				jobs.remove(jobss);
				
			}
		}
		
	}

}
