package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.JobTitle;
import com.emmanueltech.springbootcompleteapplication.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;


    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    public void addJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public Optional<JobTitle> getSingleJobTitle(Integer id) {
        Optional<JobTitle> JobTitle = jobTitleRepository.findById(id);
        return JobTitle;

    }



    public void deleteJobTitle(Integer id){
        jobTitleRepository.deleteById(id);
    }
}
