package com.dragonos.website.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dragonos.website.model.Contributor;
import com.dragonos.website.model.JsonResult;
import com.dragonos.website.model.vo.ContributorVo;
import com.dragonos.website.model.vo.InforVo;
import com.dragonos.website.model.vo.StatisticVo;
import com.dragonos.website.service.ContributorService;
import com.dragonos.website.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linhu
 * @since 2022-10-11
 */
@Service
public class RepoServiceImpl implements RepoService {


    @Autowired
    private ContributorService contributorService;

    @Override
    public JsonResult info() {
        Contributor laste = contributorService.findLaste();
        InforVo inforVo = new InforVo();
        inforVo.setStatistic(new StatisticVo());
        String infor = laste.getInfor();
        JSONArray array = JSONArray.parseArray(infor);
        List<ContributorVo > contributorVoList = new ArrayList<>();
        array.stream().forEach(a->{
            ContributorVo contributorVo = new ContributorVo();
            JSONObject json = JSONObject.parseObject(a.toString());
            String name = json.getString("login");
            contributorVo.setName(name);
            String avatar_url = json.getString("avatar_url");
            contributorVo.setAvatar(avatar_url);

            contributorVo.setEmail("112314123@163.com");
            contributorVoList.add(contributorVo);

        });
        inforVo.setContributorList(contributorVoList);
        return new JsonResult(inforVo);
    }
}
