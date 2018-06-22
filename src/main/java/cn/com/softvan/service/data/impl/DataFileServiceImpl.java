package cn.com.softvan.service.data.impl;

import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.mapper.data.DataFileMapper;
import cn.com.softvan.service.data.DataFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件信息服务
 */
@Service
@Transactional
public class DataFileServiceImpl extends AbstractService<DataFile> implements DataFileService {
    @Resource
    private DataFileMapper dataFileMapper;
    @Override
    public String getTemplatePath() {
        return "data/file";
    }

    @Override
    public void save(DataFile dataFile){
        if(StringUtils.isEmpty(dataFile.getId())){
            dataFileMapper.insert(dataFile);
        }else {
            dataFileMapper.updateByPrimaryKey(dataFile);
        }
    }

    @Override
    public List<DataFile> findbyInfoid(String infoId) {
        return dataFileMapper.findbyInfoid(infoId);
    }

    public List<DataFile> findbyInfoidAndKeyword(String infoId,String keyword) {
        DataFile dataFile = new DataFile();
        dataFile.setInfoId(infoId);
        dataFile.setKeyword(keyword);
        return dataFileMapper.findbyInfoidAndKeyword(dataFile);
    }
}
