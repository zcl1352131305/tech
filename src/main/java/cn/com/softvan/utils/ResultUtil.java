package cn.com.softvan.utils;


import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.vo.CommonResultVO;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/09/19
 * Time: 11:26
 */
public class ResultUtil {

    /**
     * 返回结果
     * @param resultEnum
     * @param msg
     * @param data
     * @return
     */
    public static CommonResultVO result(ResultEnum resultEnum, String msg, Object data){
        CommonResultVO CommonResultVO = new CommonResultVO();
        CommonResultVO.setCode(resultEnum.getCode());
        CommonResultVO.setMsg(msg!=null?msg:resultEnum.getMsg());
        CommonResultVO.setData(data);
        return CommonResultVO;
    }

    /**
     * 成功结果返回
     * @param msg
     * @param data
     * @return
     */
    public static CommonResultVO success(String msg, Object data){
        CommonResultVO CommonResultVO = new CommonResultVO();
        CommonResultVO.setCode(ResultEnum.SUCCESS.getCode());
        CommonResultVO.setMsg(msg!=null?msg:ResultEnum.SUCCESS.getMsg());
        CommonResultVO.setData(data);
        return CommonResultVO;
    }

    /**
     * 错误结果返回
     * @param msg
     * @param data
     * @return
     */
    public static CommonResultVO error(String msg, Object data){
        CommonResultVO CommonResultVO = new CommonResultVO();
        CommonResultVO.setCode(ResultEnum.ERROR.getCode());
        CommonResultVO.setMsg(msg!=null?msg:ResultEnum.ERROR.getMsg());
        CommonResultVO.setData(data);
        return CommonResultVO;
    }

    public static CommonResultVO error(Integer code, String msg){
        CommonResultVO CommonResultVO = new CommonResultVO();
        CommonResultVO.setCode(code);
        CommonResultVO.setMsg(msg);
        return CommonResultVO;
    }
}
