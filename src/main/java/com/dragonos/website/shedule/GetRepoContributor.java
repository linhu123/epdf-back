package com.dragonos.website.shedule;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dragonos.website.model.Contributor;
import com.dragonos.website.model.JsonResult;
import com.dragonos.website.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * 定时获取仓库的贡献者数据
 */

@Component
public class GetRepoContributor {

    @Autowired
    private ContributorService contributorService;


    @Value("${github.header.accept}")
    private String accept;

    @Value("${github.auth.token}")
    private String token;

    @Value("${github.params.owner}")
    private String owner;

    @Value("${github.params.repo}")
    private String repo;


    /**
     * 定时任务 每1小时运行一次
     * @return
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public Object listContributor() {
        String path = "https://api.github.com/repos/" + owner + "/" + repo + "/contributors";
        System.out.println(path);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", accept);
        headers.set("auth", token);
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<JSONArray> exchange = restTemplate.exchange(path, HttpMethod.GET, objectHttpEntity, JSONArray.class);
        System.out.println(exchange);
        int statusCodeValue = exchange.getStatusCodeValue();
        if (statusCodeValue == 200){
            JSONArray body = exchange.getBody();
            Contributor contributor = new Contributor();
            contributor.setCreateTime(LocalDateTime.now());
            contributor.setInfor(body.toJSONString());
            contributorService.save(contributor);

        }
        return exchange;
    }
}


/**
 * Parameters
 * Headers
 * Name, Type, Description
 * acceptstring
 * Setting to application/vnd.github+json is recommended.
 * <p>
 * Path parameters
 * Name, Type, Description
 * ownerstringRequired
 * The account owner of the repository. The name is not case sensitive.
 * <p>
 * repostringRequired
 * The name of the repository. The name is not case sensitive.
 * <p>
 * Query parameters
 * Name, Type, Description
 * anonstring
 * Set to 1 or true to include anonymous contributors in results.
 * <p>
 * per_pageinteger
 * The number of results per page (max 100).
 * <p>
 * Default: 30
 * <p>
 * pageinteger
 * Page number of the results to fetch.
 * <p>
 * Default: 1
 **/
