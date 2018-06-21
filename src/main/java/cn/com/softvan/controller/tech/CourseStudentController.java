package cn.com.softvan.controller.tech;

import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/tech/courseStudent")
public class CourseStudentController {

    @Resource
    private CourseService courseService;
    @Resource
    private SystemUserService systemUserService;


    @PutMapping(value = "/updateStudents")
    public ModelAndView updateStudents(Integer courseId, String studentNums) {

        if(null != studentNums){
            studentNums = studentNums.replaceAll("，",",");
            String[] students = studentNums.split(",");
            courseService.deleteCourseStudent(courseId);
            for(String wordId:students){
                SystemUser user = systemUserService.findBy("workid",wordId);
                if(null != user){
                    CourseStudent courseStudent = new CourseStudent();
                    courseStudent.setCourseId(courseId);
                    courseStudent.setStudentId(user.getId());
                    courseService.saveCourseStudent(courseStudent);
                }
            }
        }

        return new ModelAndView("redirect:/admin/".concat(courseService.getTemplatePath()).concat("/list/1"));
    }





}
