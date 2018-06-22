package cn.com.softvan.service.tech.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import cn.com.softvan.mapper.data.DataFileMapper;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.mapper.tech.CourseStudentMapper;
import cn.com.softvan.mapper.tech.CourseWorkMapper;
import cn.com.softvan.mapper.tech.CourseWorkStudentMapper;
import cn.com.softvan.service.tech.CourseWorkService;
import cn.com.softvan.service.tech.CourseWorkStudentService;
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
public class CourseWorkStudentServiceImpl extends AbstractService<CourseWorkStudent> implements CourseWorkStudentService {


    @Override
    public String getTemplatePath() {
        return "tech/courseWork";
    }


}
