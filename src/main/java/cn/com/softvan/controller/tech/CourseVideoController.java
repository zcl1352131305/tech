package cn.com.softvan.controller.tech;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.CourseVideo;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.data.DataFileService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseWorkService;
import cn.com.softvan.service.tech.CourseWorkStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@RequestMapping(value = "/admin/tech/courseVideo")
public class CourseVideoController extends BaseController<CourseVideo, Integer>{

}
