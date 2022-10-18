package com.epdf.website.service.impl;

import com.epdf.website.model.Contributor;
import com.epdf.website.dao.ContributorMapper;
import com.epdf.website.service.ContributorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linhu
 * @since 2022-10-12
 */
@Service
public class ContributorServiceImpl extends ServiceImpl<ContributorMapper, Contributor> implements ContributorService {

    @Override
    public Contributor findLaste() {
        return this.getBaseMapper().findLaste();
    }
}
