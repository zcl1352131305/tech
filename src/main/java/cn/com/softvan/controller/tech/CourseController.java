package cn.com.softvan.controller.tech;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.Sys;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.vo.system.SystemUserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.mybatis.mapper.entity.Condition;

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
@RequestMapping(value = "/admin/tech/course")
public class CourseController extends BaseController<Course, Integer>{

    @Resource
    private CourseService courseService;

    @GetMapping(value = "/editStudent/{id}")
    public ModelAndView editStudent(@PathVariable Integer id, Map<String, Object> map){

        Course course = courseService.findById(id);
        List<SystemUser> students = courseService.findCourseStudent(id);
        String workIds = "";
        for(int i =0;i<students.size();i++){
            if(i == 0){
                workIds += students.get(i).getWorkid();
            }
            else{
                workIds += ','+students.get(i).getWorkid();
            }
        }
        map.put("studentNums",workIds);
        map.put("students", students);
        map.put("courseId",id);
        map.put("course",course);
        return new ModelAndView(courseService.getTemplatePath().concat("_edit_students"), map);

    }


}
