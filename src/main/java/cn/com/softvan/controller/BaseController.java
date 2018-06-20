package cn.com.softvan.controller;

import cn.com.softvan.base.Service;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.utils.ResultUtil;
import cn.com.softvan.vo.CommonResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/15
 * Time: 10:14
 */
public class BaseController<B, IDType>{
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private Service<B> service;
    private Class<B> modelClass;
    public BaseController() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<B>) pt.getActualTypeArguments()[0];
    }
    @GetMapping(value = "/list/{page}")
    public ModelAndView list(@PathVariable(value = "page")Integer page,
                             @RequestParam(value = "size", defaultValue = "15")Integer size,
                             Map<String, Object> map){
        PageHelper.startPage(page, size);
        List<B> list = service.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);
        return new ModelAndView(service.getTemplatePath().concat("_list"), map);
    }


    @GetMapping(value = {"/{id}", ""})
    public ModelAndView edit(@PathVariable(value = "id", required = false)IDType id,
                             Map<String, Object> map) throws IllegalAccessException, InstantiationException {
        B bean = null;
        if(id == null || (bean = service.findById(id))==null){
            bean = modelClass.newInstance();
        }
        map.put("bean", bean);
        return new ModelAndView(service.getTemplatePath().concat("_edit"), map);
    }

/*    @GetMapping()
    public ModelAndView add(Map<String, Object> map) throws IllegalAccessException, InstantiationException {
        map.put("bean", modelClass.newInstance());
        return new ModelAndView(service.getTemplatePath().concat("_edit"), map);
    }*/


    @PostMapping()
    public ModelAndView save(B bean, RedirectAttributes attributes){
        service.save(bean);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(service.getTemplatePath()).concat("/list/1"));
    }

    @PutMapping()
    public ModelAndView update(B bean, RedirectAttributes attributes){
        service.update(bean);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(service.getTemplatePath()).concat("/list/1"));
    }


    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public CommonResultVO delete(@PathVariable()IDType id){
        service.deleteById(id);
        return ResultUtil.success(null,null);
    }


}
