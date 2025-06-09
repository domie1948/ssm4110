package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ShouzhiEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BaoxiaoEntity;

import com.entity.view.BaoxiaoView;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 报销
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baoxiao")
public class BaoxiaoController {
    private static final Logger logger = LoggerFactory.getLogger(BaoxiaoController.class);

    @Autowired
    private BaoxiaoService baoxiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ShouzhiService shouzhiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = baoxiaoService.queryPage(params);

        //字典表数据转换
        List<BaoxiaoView> list =(List<BaoxiaoView>)page.getList();
        for(BaoxiaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoxiaoEntity baoxiao = baoxiaoService.selectById(id);
        if(baoxiao !=null){
            //entity转view
            BaoxiaoView view = new BaoxiaoView();
            BeanUtils.copyProperties( baoxiao , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(baoxiao.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BaoxiaoEntity baoxiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoxiao:{}",this.getClass().getName(),baoxiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role)){
            baoxiao.setBaoxiaoYesnoTypes(1);
            baoxiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        baoxiao.setInsertTime(new Date());
        baoxiao.setCreateTime(new Date());



        if("管理员".equals(role) && baoxiao.getBaoxiaoYesnoTypes() == 2){
            YonghuEntity yonghuEntity = yonghuService.selectById(baoxiao.getYonghuId());
            if(yonghuEntity == null)
                return R.error(511,"查不到该用户");
            ShouzhiEntity shouzhiEntity = new ShouzhiEntity();
            shouzhiEntity.setCreateTime(new Date());
            shouzhiEntity.setInsertTime(new Date());
            shouzhiEntity.setShouzhiLeixingTypes(4);
            shouzhiEntity.setShouzhiContent(yonghuEntity.getYonghuName()+"的报销支出"+baoxiao.getMoney());
            shouzhiEntity.setShouzhiName(yonghuEntity.getYonghuName()+"的报销支出"+baoxiao.getMoney());
            shouzhiEntity.setShouzhiNewMoney(baoxiao.getMoney());
            shouzhiEntity.setShouzhiYesnoTypes(1);
            shouzhiEntity.setYonghuId(baoxiao.getYonghuId());
            shouzhiService.insert(shouzhiEntity);
        }


        baoxiaoService.insert(baoxiao);
        return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoxiaoEntity baoxiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,baoxiao:{}",this.getClass().getName(),baoxiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            baoxiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        BaoxiaoEntity oldBaoxiaoEntity = baoxiaoService.selectById(baoxiao.getId());
        if(oldBaoxiaoEntity.getBaoxiaoYesnoTypes() == 1 && baoxiao.getBaoxiaoYesnoTypes() == 2){
            YonghuEntity yonghuEntity = yonghuService.selectById(baoxiao.getYonghuId());
            if(yonghuEntity == null)
                return R.error(511,"查不到该用户");
            ShouzhiEntity shouzhiEntity = new ShouzhiEntity();
            shouzhiEntity.setCreateTime(new Date());
            shouzhiEntity.setInsertTime(new Date());
            shouzhiEntity.setShouzhiLeixingTypes(4);
            shouzhiEntity.setShouzhiContent(yonghuEntity.getYonghuName()+"的报销支出"+baoxiao.getMoney());
            shouzhiEntity.setShouzhiName(yonghuEntity.getYonghuName()+"的报销支出"+baoxiao.getMoney());
            shouzhiEntity.setShouzhiNewMoney(baoxiao.getMoney());
            shouzhiEntity.setShouzhiYesnoTypes(1);
            shouzhiEntity.setYonghuId(baoxiao.getYonghuId());
            shouzhiService.insert(shouzhiEntity);
        }
        baoxiaoService.updateById(baoxiao);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        baoxiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

