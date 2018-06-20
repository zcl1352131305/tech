package cn.com.softvan.controller.comment;

import cn.com.softvan.config.UploadConfig;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.service.data.DataFileService;
import cn.com.softvan.utils.ResultUtil;
import cn.com.softvan.vo.CommonResultVO;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Calendar;

/**
 * 文件上传控制器
 */
@RequestMapping(value = "/common/file")
@RestController
public class FileUploadController {

    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private DataFileService dataFileService;
    @PostMapping(value = "/upload/{type}")
    @ResponseBody
    public CommonResultVO uploadSingle(@RequestParam("file") MultipartFile file,
                                       @PathVariable(value = "type")String type,
                                       @RequestParam(value = "keyword")String keyword) {
        String msg = "上传成功";
        String relativelyPath = filePath(file.getOriginalFilename(), type);
        String systemPath = uploadConfig.getRootPath().concat("/").concat(relativelyPath);
        String webPath = uploadConfig.getWebPath().concat("/").concat(relativelyPath);

        //保存文件信息
        DataFile dataFile = new DataFile();
        dataFile.setName(file.getOriginalFilename());
        dataFile.setPath(webPath);
        dataFile.setType(type);
        dataFile.setSize(file.getSize());
        dataFile.setKeyword(keyword);


        JSONObject result = new JSONObject();
        result.put("webPath", webPath);
        //写入文件
        try {
            file.transferTo(new File(systemPath));
            dataFileService.save(dataFile);
            result.put("id", dataFile.getId());
            } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(e.getMessage(), null);
        }


        return ResultUtil.success(msg, result);

    }


    /**
     * 生成完成文件路径<br>
     *     文件路径命名规则：/{rootPath}/{fileType}/{yyyy}/{MM}/{dd}/{fileName}
     * @param oldName
     * @return
     */
    private String filePath(String oldName, String type){
        String suffix = "";
        if(oldName != null && oldName.lastIndexOf(".")!=-1){
            suffix = oldName.substring(oldName.lastIndexOf("."));

        }
        if(StringUtils.isEmpty(type)){
            type = "f";
        }
        //年月日
        Calendar calendar = Calendar.getInstance();
        String path = type.concat("/").concat(String.valueOf(calendar.get(Calendar.YEAR)))
                .concat("/").concat(String.valueOf(calendar.get(Calendar.MONTH)+1)).concat("/")
                .concat(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        File file = new File(uploadConfig.getRootPath().concat("/").concat(path));
        if(!file.exists()||!file.isDirectory()){
            //文件夹不存在，创建该文件夹
            file.mkdirs();
        }

        return path.concat("/").concat(String.valueOf(System.currentTimeMillis()).concat(RandomStringUtils.randomAlphabetic(5))).concat(suffix);
    }




}
