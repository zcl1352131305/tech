package cn.com.softvan.controller.tech;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.data.DataFileService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseWorkService;
import cn.com.softvan.service.tech.CourseWorkStudentService;
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
import java.util.Date;
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

    @Autowired
    private CourseWorkStudentService courseWorkStudentService;

    @Autowired
    private DataFileService dataFileService;



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
    public ModelAndView saveUpdateSave(CourseWork bean,String[] courseWorkFiles, RedirectAttributes attributes){
        if(null != courseWorkFiles){
            bean.setFileId(Integer.parseInt(courseWorkFiles[courseWorkFiles.length-1]));
        }
        courseWorkService.save(bean);

        if(null != courseWorkFiles){
            for(int i = 0;i<courseWorkFiles.length-1;i++){
                dataFileService.deleteById(courseWorkFiles[i]);
            }
            DataFile file = dataFileService.findById(courseWorkFiles[courseWorkFiles.length-1]);
            file.setInfoId(bean.getId()+"");
            dataFileService.update(file);
        }
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseWorkService.getTemplatePath()).concat("/workList/1?courseId="+bean.getCourseId()));
    }

    @PutMapping(value = "/saveUpdate")
    public ModelAndView saveUpdateUpdate(CourseWork bean, String[] courseWorkFiles, RedirectAttributes attributes){
        if(null != courseWorkFiles){
            bean.setFileId(Integer.parseInt(courseWorkFiles[courseWorkFiles.length-1]));
        }
        courseWorkService.update(bean);
        if(null != courseWorkFiles){
            for(int i = 0;i<courseWorkFiles.length-1;i++){
                dataFileService.deleteById(courseWorkFiles[i]);
            }
            DataFile file = dataFileService.findById(courseWorkFiles[courseWorkFiles.length-1]);
            file.setInfoId(bean.getId()+"");
            dataFileService.update(file);
        }
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseWorkService.getTemplatePath()).concat("/workList/1?courseId="+bean.getCourseId()));
    }

    @PutMapping(value = "/ajaxUpdate")
    @ResponseBody
    public void saveUpdateUpdate(CourseWork bean, RedirectAttributes attributes){
        courseWorkService.update(bean);
    }


    /**
     * 学生作业提交列表
     * @param request
     * @param workId
     * @param courseId
     * @param map
     * @return
     */
    @GetMapping(value = "/workSubmitStudentList/{workId}")
    public ModelAndView list(HttpServletRequest request,
                             @PathVariable Integer workId,
                             String courseId,
                             Map<String, Object> map){

        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        else{
            request.getSession().setAttribute("workCourseId",courseId);
        }
        List<SystemUser> list = courseWorkService.getWorkSubmitStudentsDetailList(workId);
        map.put("dataList", list);
        map.put("courseId", courseId);
        return new ModelAndView(courseWorkService.getTemplatePath().concat("_submit_list"), map);
    }


    /**
     * 批改作业编辑
     * @param id
     * @param courseId
     * @param map
     * @return
     */
    @GetMapping(value = "/checkedEdit/{id}")
    public ModelAndView saveUpdateUpdate(@PathVariable(value = "id", required = false)Integer id,
                                         String courseId,
                                         Map<String, Object> map){
        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        else{
            request.getSession().setAttribute("workCourseId",courseId);
        }
        CourseWorkStudent bean =  courseWorkStudentService.findById(id);
        CourseWork work = courseWorkService.findById(bean.getWorkId());
        map.put("bean", bean);
        map.put("work", work);
        map.put("courseId", courseId);
        return new ModelAndView(courseWorkService.getTemplatePath().concat("_submit_checked"), map);
    }

    @PutMapping(value = "/checkedWork")
    public ModelAndView saveUpdateUpdate(CourseWorkStudent bean,
                                         String courseId,
                                         String[] courseWorkStudentCheckedFiles ,
                                         RedirectAttributes attributes){
        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        else{
            request.getSession().setAttribute("workCourseId",courseId);
        }
        if(null != courseWorkStudentCheckedFiles){
            for(int i = 0;i<courseWorkStudentCheckedFiles.length-1;i++){
                dataFileService.deleteById(courseWorkStudentCheckedFiles[i]);
            }
            bean.setCheckedFileId(Integer.parseInt(courseWorkStudentCheckedFiles[courseWorkStudentCheckedFiles.length-1]));
            bean.setDateChecked(new Date());
        }
        courseWorkStudentService.update(bean);

        if(null != courseWorkStudentCheckedFiles){
            DataFile file = dataFileService.findById(courseWorkStudentCheckedFiles[courseWorkStudentCheckedFiles.length-1]);
            file.setInfoId(bean.getId()+"");
            dataFileService.update(file);
        }
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseWorkService.getTemplatePath()).concat("/workSubmitStudentList/"+bean.getWorkId()+"?courseId="+courseId));
    }

}
