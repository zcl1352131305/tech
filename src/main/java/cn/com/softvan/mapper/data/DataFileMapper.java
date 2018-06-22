package cn.com.softvan.mapper.data;

import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.data.DataFile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DataFileMapper extends Mapper<DataFile>{
    List<DataFile> findbyInfoid(String infoId);

    List<DataFile> findbyInfoidAndKeyword(DataFile entity);
}
