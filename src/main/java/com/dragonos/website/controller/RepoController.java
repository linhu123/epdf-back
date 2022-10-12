package com.dragonos.website.controller;

import com.dragonos.website.model.JsonResult;
import com.dragonos.website.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

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
