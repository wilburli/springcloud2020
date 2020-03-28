package org.longhua.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult{

    private Integer status;

    private String msg;

    private Object data;

    public CommonResult(Integer status,String msg){
         this(status,msg,null);
    }

    public static CommonResult ok(){
        return new CommonResult(200,"操作成功",null);
    }

    public static CommonResult ok(String msg){
        return new CommonResult(200,msg,null);
    }

    public static CommonResult ok(Object data){
        return new CommonResult(200,"操作成功",data);
    }

    public static CommonResult err(){
        return new CommonResult(500,"操作失败");
    }



}
