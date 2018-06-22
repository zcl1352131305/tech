package cn.com.softvan.controller.data;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.service.data.DataFileService;
import cn.com.softvan.utils.ResultUtil;
import cn.com.softvan.vo.CommonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/data/file")
@RestController
public class DataFileController extends BaseController<DataFile,Integer> {

    @Autowired
    private DataFileService dataFileService;

    /**
     * 根据信息id查询相关文件
     * @return
     */
    @GetMapping(value = "/list/{keyword}/{infoId}")
    public CommonResultVO findFileByInfoId(@PathVariable(value = "keyword")String keyword,
                                           @PathVariable(value = "infoId")String infoId){
        DataFile dataFile = new DataFile();
        dataFile.setInfoId(infoId);
        dataFile.setKeyword(keyword);
        //List<DataFile> files = dataFileService.findbyInfoid(infoId);
        List<DataFile> files = dataFileService.findbyInfoidAndKeyword(infoId,keyword);
        return ResultUtil.success("查询成功", files);
    }


    @DeleteMapping(value = "/{id}")
    public CommonResultVO delete(@PathVariable(value = "id")Integer id){
        dataFileService.deleteById(id);
        return ResultUtil.success("删除成功", null);
    }

}
