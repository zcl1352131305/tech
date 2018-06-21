package cn.com.softvan.controller.tech;

import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseWorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/tech/student")
public class StudentController {

    @Resource
    private CourseService courseService;
    @Resource
    private SystemUserService systemUserService;

    @Autowired
    private CourseWorkService courseWorkService;


    private String getTemplatePath(){
        return "student/";
    }

    @GetMapping(value = "/course/list/{page}")
    public ModelAndView list(@PathVariable(value = "page")Integer page, @RequestParam(value = "size", defaultValue = "15")Integer size, Map<String, Object> map){
        PageHelper.startPage(page, size);
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        List<Course> list = courseService.findStudentCourses(user.getId());
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);
        return new ModelAndView("student/".concat("course_list"), map);
    }

    @GetMapping(value = "/courseWork/workList/{page}")
    public ModelAndView list(HttpServletRequest request, @PathVariable(value = "page")Integer page,
                             @RequestParam(value = "size", defaultValue = "15")Integer size,
                             String courseId,
                             Map<String, Object> map){

        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("studentWorkCourseId");
        }
        else{
            request.getSession().setAttribute("studentWorkCourseId",courseId);
        }
        Integer courseIdI = Integer.parseInt(courseId);

        PageHelper.startPage(page, size);
        List<CourseWork> list = courseWorkService.findList(courseIdI);
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);

        map.put("courseId", courseId);
        return new ModelAndView(getTemplatePath().concat("courseWork_list"), map);
    }

}
