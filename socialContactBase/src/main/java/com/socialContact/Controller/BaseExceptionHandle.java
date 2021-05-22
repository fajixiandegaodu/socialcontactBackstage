package com.socialContact.Controller;

import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: BaseExceptionHandle
 * @Author: 86151
 * @Date: 2021/4/21 21:00
 * @Description: TODO
 */
/*同一异常处理类*/
@ControllerAdvice

public class BaseExceptionHandle {
    /*可指定对对于的报错进行特点的全局处理*/
    @ExceptionHandler
    @ResponseBody
    public Result err(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage(),"出错了");
    }

}
