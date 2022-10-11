package com.dragonos.website.controller;


import com.dragonos.website.model.JsonResult;
import com.dragonos.website.service.AbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author linhu
 * @since 2022-10-11
 */
@RestController
@RequestMapping("/abc")
public class AbcController {

    @Autowired
    private AbcService abcService;

    @GetMapping("/selectFirst")
    public JsonResult selectFirst() {
        return abcService.selectFisrt();
    }
}
