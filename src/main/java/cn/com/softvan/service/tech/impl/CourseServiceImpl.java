package cn.com.softvan.service.tech.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.vo.system.SystemUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {

    @Override
    public String getTemplatePath() {
        return "tech/course";
    }


}
