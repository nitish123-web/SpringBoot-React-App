package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JobPost;
import com.example.demo.service.JobService;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {
	
	@Autowired
	JobService js;

//	
//	If you only wish to create the API the json responce then use produce
//	@GetMapping(path="JobPosts" produce={"application/json"}) 
//  This is to produce a JSON format data
	
	
	@GetMapping("JobPosts")
	public List<JobPost> getalljobs() {
		
		return js.viewalljobs();
		
	}
	
	@GetMapping("JobPost/{postid}")
	public JobPost getjob(@PathVariable int postid) {
		
		return js.GetJob(postid);
		
	}
	
	
//	
//	If you wish to post the data only in XML format then use consumes
//	@GetMapping(path="JobPosts" consumes={"application/XML"}) 
//  This is to Consume a XML format data
	
	
	@PostMapping("JobPost")
	public JobPost addjob(@RequestBody JobPost jb) {
		js.addjob(jb);
		return js.GetJob(jb.getPostId());
	}
	
	
	@PutMapping("JobPost")
	public JobPost updatejob(@RequestBody JobPost job) {
		
		js.updateJob(job);
		return js.GetJob(job.getPostId());
		
	}
	
	@DeleteMapping("JobPost/{postid}")
	public String deletejob(@PathVariable int  postid) {
		
		js.deletejob(postid);
		return "deleted";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
