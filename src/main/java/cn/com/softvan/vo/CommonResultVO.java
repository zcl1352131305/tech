package cn.com.softvan.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/09/19
 * Time: 11:25
 */
@Data
public class CommonResultVO {
    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    public CommonResultVO(){}
    public CommonResultVO(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}