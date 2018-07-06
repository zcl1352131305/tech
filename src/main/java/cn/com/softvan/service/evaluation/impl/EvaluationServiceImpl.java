package cn.com.softvan.service.evaluation.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.chat.Chat;
import cn.com.softvan.entity.evaluation.Evaluation;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.mapper.chat.ChatMapper;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.service.chat.ChatService;
import cn.com.softvan.service.evaluation.EvaluationService;
import cn.com.softvan.utils.WebUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class EvaluationServiceImpl extends AbstractService<Evaluation> implements EvaluationService {

    @Override
    public String getTemplatePath() {
        return "evaluation/";
    }



}
