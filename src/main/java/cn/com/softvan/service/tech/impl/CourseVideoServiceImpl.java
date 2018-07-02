package cn.com.softvan.service.tech.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.*;
import cn.com.softvan.mapper.data.DataFileMapper;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.mapper.tech.CourseStudentMapper;
import cn.com.softvan.mapper.tech.CourseVideoQuestionMapper;
import cn.com.softvan.mapper.tech.CourseWorkMapper;
import cn.com.softvan.mapper.tech.CourseWorkStudentMapper;
import cn.com.softvan.service.tech.CourseVideoService;
import cn.com.softvan.service.tech.CourseWorkService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class CourseVideoServiceImpl extends AbstractService<CourseVideo> implements CourseVideoService {

    @Override
    public String getTemplatePath() {
        return "tech/courseVideo";
    }

    @Autowired
    private DataFileMapper dataFileMapper;

    @Autowired
    private CourseVideoQuestionMapper questionMapper;


    /**
     * 查询视频列表（教师查看）
     * @param courseId
     * @return
     */
    public List<CourseVideo> findList(Integer courseId){
        Condition condition = new Condition(Course.class);
        condition.createCriteria().andCondition("course_id = '" + courseId+ "'");
        List<CourseVideo> list = findByCondition(condition);
        for(CourseVideo courseVideo:list){
            DataFile videoFile = dataFileMapper.selectByPrimaryKey(courseVideo.getFileId());
            if(null != videoFile){
                courseVideo.setVideoFile(videoFile);
            }
        }
        if(null == list) list = new ArrayList<>();
        return list;
    }


    /**
     * 查询作业列表（学生查看）
     * @param courseId
     * @return
     */
    public List<CourseVideo> findStudentVideoList(Integer courseId){
        Condition condition = new Condition(Course.class);
        condition.createCriteria().andCondition("course_id = '" + courseId+ "'");
        SystemUser student = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        List<CourseVideo> list = findByCondition(condition);
        for(CourseVideo courseVideo:list){
            /*DataFile file = dataFileMapper.selectByPrimaryKey(courseVideo.getFileId());
            if(null != file){
                courseVideo.setVideoFile(file);
            }*/
            DataFile file = dataFileMapper.selectByPrimaryKey(courseVideo.getHeadImgFileId());
            if(null != file){
                courseVideo.setHeadImgFile(file);
            }

        }
        return list;
    }


    /**
     * 查询视频问题
     * @param videoId
     * @return
     */
    public List<CourseVideoQuestion> getVideoQuestions(Integer videoId){
        Condition condition = new Condition(CourseVideoQuestion.class);
        condition.createCriteria().andCondition("video_id = '" + videoId+ "'");
        List<CourseVideoQuestion> questions = questionMapper.selectByCondition(condition);
        if(null == questions){
            questions = new ArrayList<>();
        }
        return questions;
    }

    /**
     * 保存视频问题
     * @param videoId
     * @param questions
     */
    public void saveVideoQuestions(Integer videoId, List<CourseVideoQuestion> questions){
        questionMapper.deleteByVideoId(videoId);
        for(CourseVideoQuestion question:questions){
            question.setVideoId(videoId);
            questionMapper.insert(question);
        }
    }

}
