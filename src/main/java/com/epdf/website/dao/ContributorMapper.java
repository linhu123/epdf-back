package com.epdf.website.dao;

import com.epdf.website.model.Contributor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
