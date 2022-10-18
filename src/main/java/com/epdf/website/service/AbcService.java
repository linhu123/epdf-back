package com.epdf.website.service;

import com.epdf.website.model.Abc;
import com.baomidou.mybatisplus.extension.service.IService;
import com.epdf.website.model.JsonResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linhu
 * @since 2022-10-11
 */
public interface AbcService extends IService<Abc> {

    JsonResult selectFisrt();

}
