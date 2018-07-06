package cn.com.softvan.controller.tech;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.CourseVideo;
import cn.com.softvan.entity.tech.CourseVideoQuestion;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.data.DataFileService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseVideoService;
import cn.com.softvan.service.tech.CourseWorkService;
import cn.com.softvan.service.tech.CourseWorkStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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


    @Autowired
    private CourseVideoService courseVideoService;

    @Autowired
    private DataFileService dataFileService;


    @GetMapping(value = "/videoList/{page}")
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
        List<CourseVideo> list = courseVideoService.findList(courseIdI);
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);

        map.put("courseId", courseId);
        return new ModelAndView(courseVideoService.getTemplatePath().concat("_list"), map);
    }


    @GetMapping(value = {"/edit/{id}", ""})
    public ModelAndView edit(@PathVariable(value = "id", required = false)Integer id,
                             String courseId,
                             Map<String, Object> map) throws IllegalAccessException, InstantiationException {
        CourseVideo bean = null;
        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        Integer courseIdI = Integer.parseInt(courseId);
        if(id == null || (bean = courseVideoService.findById(id))==null){
            bean = new CourseVideo();
            bean.setCourseId(courseIdI);
            bean.setQuestions(new ArrayList<>());
        }
        else{
            bean.setQuestions(courseVideoService.getVideoQuestions(bean.getId()));
        }
        map.put("bean", bean);
        return new ModelAndView(courseVideoService.getTemplatePath().concat("_edit"), map);
    }

    private void updateSingleFile(List<String > files,String infoId){
        if(null != files && files.size() > 0){
            for(int i = 0;i<files.size()-1;i++){
                dataFileService.deleteById(files.get(i));
            }
            DataFile file = dataFileService.findById(files.get(files.size()-1));
            file.setInfoId(infoId);
            dataFileService.update(file);
        }
    }


    @PostMapping(value = "/saveUpdate")
    public ModelAndView saveUpdateSave(CourseVideo bean,String[] courseVideoFiless, String[] questionVal, String[] answerVal, String[] alertTimeVal, RedirectAttributes attributes){
        saveOrUpdate(bean,courseVideoFiless,questionVal,answerVal,alertTimeVal,"post");
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseVideoService.getTemplatePath()).concat("/videoList/1?courseId="+bean.getCourseId()));
    }

    @PutMapping(value = "/saveUpdate")
    public ModelAndView saveUpdateUpdate(CourseVideo bean, String[] courseVideoFiless, String[] questionVal, String[] answerVal, String[] alertTimeVal,  RedirectAttributes attributes){
        saveOrUpdate(bean,courseVideoFiless,questionVal,answerVal,alertTimeVal,"put");
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(courseVideoService.getTemplatePath()).concat("/videoList/1?courseId="+bean.getCourseId()));
    }

    private void saveOrUpdate(CourseVideo bean,String[] courseVideoFiless, String[] questionVal, String[] answerVal, String[] alertTimeVal, String method){
        List<String > headImgFiles = new ArrayList<>(), videoFiles = new ArrayList<>();
        if(null != courseVideoFiless){
            for(String fileId:courseVideoFiless){
                DataFile file = dataFileService.findById(fileId);
                String name = file.getName();
                String[] str = name.split("\\.");
                String extName = str[str.length-1].trim().toLowerCase();
                if("jpg".equals(extName) || "png".equals(extName) || "gif".equals(extName)){
                    headImgFiles.add(fileId);
                }
                if("mp4".equals(extName) || "webm".equals(extName) || "0gg".equals(extName) || "mpeg4".equals(extName)){
                    videoFiles.add(fileId);
                }
            }
            if(headImgFiles.size() > 0){
                bean.setHeadImgFileId(Integer.parseInt(headImgFiles.get(headImgFiles.size()-1)));
            }
            if(videoFiles.size() > 0){
                bean.setFileId(Integer.parseInt(videoFiles.get(videoFiles.size()-1)));
            }
        }

        if("post".equals(method)){
            courseVideoService.save(bean);
        }
        else{
            courseVideoService.update(bean);
        }

        //保存问题列表
        if(null != questionVal && null != answerVal && null != alertTimeVal){
            List<CourseVideoQuestion> questions = new ArrayList<>();
            for(int i=0; i<questionVal.length;i++){
                if(!StringUtils.isEmpty(alertTimeVal[i])){
                    CourseVideoQuestion question = new CourseVideoQuestion();
                    question.setQuestion(questionVal[i]);
                    question.setAnswer(StringUtils.isEmpty(answerVal[i])?"1":answerVal[i]);
                    question.setAlertTime(Integer.parseInt(alertTimeVal[i]));
                    questions.add(question);
                }
            }
            courseVideoService.saveVideoQuestions(bean.getId(),questions);
        }

        updateSingleFile(headImgFiles,bean.getId()+"");
        updateSingleFile(videoFiles,bean.getId()+"");
    }


    @GetMapping(value = "/videoStudentWatchedList/{videoId}")
    public ModelAndView list(HttpServletRequest request,
                             @PathVariable Integer videoId,
                             String courseId,
                             Map<String, Object> map){

        if(null == courseId || "null".equals(courseId)){
            courseId = (String ) request.getSession().getAttribute("workCourseId");
        }
        else{
            request.getSession().setAttribute("workCourseId",courseId);
        }
        List<SystemUser> list = courseVideoService.findVideoStudentsWatched(videoId);
        map.put("dataList", list);
        map.put("courseId", courseId);
        return new ModelAndView(courseVideoService.getTemplatePath().concat("_watched_list"), map);
    }
}
