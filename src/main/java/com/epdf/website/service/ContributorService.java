package com.epdf.website.service;

import com.epdf.website.model.Contributor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linhu
 * @since 2022-10-12
 */
public interface ContributorService extends IService<Contributor> {

    Contributor findLaste();
}
