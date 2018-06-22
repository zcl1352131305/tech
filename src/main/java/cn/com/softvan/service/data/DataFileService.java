package cn.com.softvan.service.data;

import cn.com.softvan.base.Service;
import cn.com.softvan.entity.data.DataFile;

import java.util.List;


public interface DataFileService extends Service<DataFile> {
    void save(DataFile dataFile);
    List<DataFile> findbyInfoid(String infoId);
    List<DataFile> findbyInfoidAndKeyword(String infoId,String keyword);
}
