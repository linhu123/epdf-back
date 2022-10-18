package com.epdf.website.controller;

import com.epdf.website.model.JsonResult;
import com.epdf.website.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/repo")
public class RepoController {

    @Autowired
    private RepoService repoService;

    @GetMapping("/info")
    public JsonResult info(){
        return repoService.info();
    }
}
