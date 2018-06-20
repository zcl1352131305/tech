package cn.com.softvan.controller.tech;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.vo.system.SystemUserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;


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


}
