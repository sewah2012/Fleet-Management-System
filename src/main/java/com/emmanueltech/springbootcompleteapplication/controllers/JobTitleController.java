package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.JobTitle;
import com.emmanueltech.springbootcompleteapplication.services.JobTitleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {
    @Autowired
    JobTitleService jobTitleService;

    @GetMapping("/job_title")
    public String getJobTitle(Model model){
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles",jobTitleList);

        return "job_title";
    }

    @GetMapping("/job_title/find")
    @ResponseBody
    public Optional<JobTitle> getSingleJobTitle(@PathParam("id") Integer id){
        Optional<JobTitle> job_title = jobTitleService.getSingleJobTitle(id);
        return job_title;
    }


    @PostMapping("/job_title/add_job_title")
    public String addJobTitle(JobTitle job_title){
        jobTitleService.addJobTitle(job_title);
        return "redirect:/job_title";
    }

    @RequestMapping(value = "/job_title/edit_job_title",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editJobTitle(JobTitle JobTitle) throws NotFoundException {
        jobTitleService.addJobTitle(JobTitle);
        return "redirect:/job_title";
    }

    @RequestMapping(value = "/job_title/delete_job_title",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteJobTitle(Integer id){
        jobTitleService.deleteJobTitle(id);
        return "redirect:/job_title";
    }
}
