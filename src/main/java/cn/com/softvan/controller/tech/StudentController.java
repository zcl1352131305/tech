package cn.com.softvan.controller.tech;

import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseVideo;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.data.DataFileService;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseVideoService;
import cn.com.softvan.service.tech.CourseWorkService;
import com.alibaba.fastjson.JSONObject;
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

@Controller
@RequestMapping(value = "/admin/tech/student")
public class StudentController {

    @Resource
    private CourseService courseService;
    @Resource
    private SystemUserService systemUserService;

    @Autowired
    private CourseWorkService courseWorkService;

    @Autowired
    private CourseVideoService courseVideoService;

    @Autowired
    private DataFileService dataFileService;



    private String getTemplatePath(){
        return "student/";
    }

    /**
     * 学生课程列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping(value = "/course/list/{page}")
    public ModelAndView list(@PathVariable(value = "page")Integer page, @RequestParam(value = "size", defaultValue = "15")Integer size, Map<String, Object> map){
        PageHelper.startPage(page, size);
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        List<Course> list = courseService.findStudentCourses(user.getId());
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);
        return new ModelAndView("student/".concat("course_list"), map);
    }

    /**
     * 学生作业列表
     * @param request
     * @param page
     * @param size
     * @param courseId
     * @param map
     * @return
     */
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
        List<CourseWork> list = courseWorkService.findStudentWorkList(courseIdI);
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);

        map.put("courseId", courseId);
        return new ModelAndView(getTemplatePath().concat("courseWork_list"), map);
    }


    /**
     * 学生作业提交编辑
     * @param request
     * @param workId
     * @param courseId
     * @param map
     * @return
     */
    @GetMapping(value = "/courseWork/submitEdit/{workId}")
    public ModelAndView submitEdit(HttpServletRequest request, @PathVariable Integer workId,
                             String courseId,
                             Map<String, Object> map){

        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("studentWorkCourseId");
        }
        else{
            request.getSession().setAttribute("studentWorkCourseId",courseId);
        }

        CourseWork work = courseWorkService.findById(workId);

        CourseWorkStudent studentWork = courseWorkService.getStudentWork(workId);
        if(null == studentWork){
            studentWork = new CourseWorkStudent();
            studentWork.setWorkId(workId);
        }

        map.put("bean",studentWork);
        map.put("work",work);
        map.put("courseId", courseId);
        return new ModelAndView(getTemplatePath().concat("courseWork_submit"), map);
    }


    /**
     * 学生作业提交保存或更新
     * @param workId
     * @param courseId
     * @param courseWorkStudentSubmitFiles
     * @param attributes
     * @return
     */
    @PostMapping(value = "/courseWork/submitWork")
    public ModelAndView saveUpdateSave(Integer workId, Integer courseId,String[] courseWorkStudentSubmitFiles, RedirectAttributes attributes){
        Integer fileId = null;
        if(null != courseWorkStudentSubmitFiles){
            for(int i = 0;i<courseWorkStudentSubmitFiles.length-1;i++){
                dataFileService.deleteById(courseWorkStudentSubmitFiles[i]);
            }
            fileId = Integer.parseInt(courseWorkStudentSubmitFiles[courseWorkStudentSubmitFiles.length-1]);
        }
        courseWorkService.submitWork(workId,fileId);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/tech/".concat(getTemplatePath()).concat("courseWork/workList/1?courseId="+courseId));
    }


    /**
     * 课程视频列表
     * @param request
     * @param page
     * @param size
     * @param courseId
     * @param map
     * @return
     */
    @GetMapping(value = "/courseVideo/videoList/{page}")
    public ModelAndView videoList(HttpServletRequest request, @PathVariable(value = "page")Integer page,
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
        List<CourseVideo> list = courseVideoService.findStudentVideoList(courseIdI);
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);

        map.put("courseId", courseId);
        return new ModelAndView(getTemplatePath().concat("courseVideo_list"), map);
    }


    /**
     * 学生观看视频
     * @param request
     * @param videoId
     * @param courseId
     * @param map
     * @return
     */
    @GetMapping(value = "/courseVideo/view/{videoId}")
    public ModelAndView videoView(HttpServletRequest request, @PathVariable Integer videoId,
                                   String courseId,
                                   Map<String, Object> map){

        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("studentWorkCourseId");
        }
        else{
            request.getSession().setAttribute("studentWorkCourseId",courseId);
        }

        CourseVideo video = courseVideoService.findById(videoId);
        DataFile file = dataFileService.findById(video.getFileId());
        if(null != file){
            video.setVideoFile(file);
        }

        file = dataFileService.findById(video.getHeadImgFileId());
        if(null != file){
            video.setHeadImgFile(file);
        }
        video.setQuestions(courseVideoService.getVideoQuestions(video.getId()));
        video.setStudentWatched(courseVideoService.getStudentWatched(video.getId()));

        List<CourseVideo> list = courseVideoService.findStudentVideoList(Integer.parseInt(courseId));

        map.put("video",video);
        map.put("allVideo",list);
        map.put("courseId", courseId);
        return new ModelAndView(getTemplatePath().concat("courseVideo_view"), map);
    }


    /**
     * 更新视频观看进度
     * @param videoId
     * @param progress
     * @param attributes
     * @return
     */
    @PostMapping(value = "/courseVideo/updateWatchedProgress")
    @ResponseBody
    public JSONObject saveUpdateSave(Integer videoId, String progress,Integer latestWatched, RedirectAttributes attributes){
        String[] pg = progress.split("\\.");
        courseVideoService.updateStudentWatchedProgress(videoId,Integer.parseInt(pg[0]),latestWatched);
        JSONObject json = new JSONObject();
        json.put("msg", ResultEnum.SUCCESS.getMsg());
        return json;
    }


}
