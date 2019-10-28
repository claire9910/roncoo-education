package com.roncoo.education.system.feign.interfaces;

import com.roncoo.education.system.feign.qo.SysMenuQO;
import com.roncoo.education.system.feign.vo.SysMenuVO;
import com.roncoo.education.util.base.Page;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 菜单信息
 *
 * @author wujing
 */
@FeignClient(value = "roncoo-education-system-service")
public interface IFeignSysMenu {


    @RequestMapping(value = "/feign/system/sysMenu/listForPage")
    Page<SysMenuVO> listForPage(@RequestBody SysMenuQO qo);

    @RequestMapping(value = "/feign/system/sysMenu/save")
    int save(@RequestBody SysMenuQO qo);

    @RequestMapping(value = "/feign/system/sysMenu/deleteById")
    int deleteById(@RequestBody Long id);

    @RequestMapping(value = "/feign/system/sysMenu/updateById")
    int updateById(@RequestBody SysMenuQO qo);

    @RequestMapping(value = "/feign/system/sysMenu/getById")
    SysMenuVO getById(@RequestBody Long id);

    @RequestMapping(value = "/feign/system/sysMenu/listByUserAndMenu")
    List<SysMenuVO> listByUserAndMenu(@RequestBody Long userNo);

}
