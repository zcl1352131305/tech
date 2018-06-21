package cn.com.softvan.controller.tech;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseWorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/15
 * Time: 10:03
 */
@Controller
@RequestMapping(value = "/admin/tech/courseWork")
public class CourseWorkController extends BaseController<CourseWork, Integer>{

    @Resource
    private CourseService courseService;

    @Autowired
    private CourseWorkService courseWorkService;


    @GetMapping(value = "/workList/{page}")
    public ModelAndView list(HttpServletRequest request, @PathVariable(value = "page")Integer page,
                             @RequestParam(value = "size", defaultValue = "15")Integer size,
                             String courseId,
                             Map<String, Object> map){

        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        else{
            request.getSession().setAttribute("workCourseId",courseId);
        }
        Integer courseIdI = Integer.parseInt(courseId);

        PageHelper.startPage(page, size);
        List<CourseWork> list = courseWorkService.findList(courseIdI);
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);

        map.put("courseId", courseId);
        return new ModelAndView(courseWorkService.getTemplatePath().concat("_list"), map);
    }

    @GetMapping(value = {"/edit/{id}", ""})
    public ModelAndView edit(@PathVariable(value = "id", required = false)Integer id,
                             String courseId,
                             Map<String, Object> map) throws IllegalAccessException, InstantiationException {
        CourseWork bean = null;
        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        Integer courseIdI = Integer.parseInt(courseId);
        if(id == null || (bean = courseWorkService.findById(id))==null){
            bean = new CourseWork();
            bean.setCourseId(courseIdI);
        }
        map.put("bean", bean);
        return new ModelAndView(courseWorkService.getTemplatePath().concat("_edit"), map);
    }


    @PostMapping(value = "/saveUpdate")
    public ModelAndView saveUpdateSave(CourseWork bean,String[] files, RedirectAttributes attributes){
        if(null != files){
            bean.setFileId(files[files.length-1]);
        }
        courseWorkService.save(bean);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseWorkService.getTemplatePath()).concat("/workList/1?courseId="+bean.getCourseId()));
    }

    @PutMapping(value = "/saveUpdate")
    public ModelAndView saveUpdateUpdate(CourseWork bean, String[] files, RedirectAttributes attributes){
        if(null != files){
            bean.setFileId(files[files.length-1]);
        }
        courseWorkService.update(bean);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseWorkService.getTemplatePath()).concat("/workList/1?courseId="+bean.getCourseId()));
    }


}
