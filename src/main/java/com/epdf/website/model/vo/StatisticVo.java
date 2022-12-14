package com.epdf.website.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * "statistics": {
 *         "pr": "123",
 *         "star": "66",
 *         "fork": "11",
 *         "contributors": "23",
 *         "releases": "0",
 *         "updated_time": "2022-10-08"
 *     },
 */
@Data
public class StatisticVo {

    private String pr;

    private String star;

    private String fork;

    private String contributors;

    private String releases;

    private String updatedTime;

    public StatisticVo(){
        this.pr = "123";
        this.star = "55";
        this.fork = "66";
        this.contributors = "23";
        this.releases ="0";
        this.updatedTime = LocalDateTime.now().toString();
    }


}
