package com.dragonos.website.dao;

import com.dragonos.website.model.Contributor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragonos.website.service.ContributorService;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linhu
 * @since 2022-10-12
 */
public interface ContributorMapper extends BaseMapper<Contributor> {

    Contributor findLaste();
}
