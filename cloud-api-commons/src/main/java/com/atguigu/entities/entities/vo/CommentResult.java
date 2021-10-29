package com.atguigu.entities.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wz
 * @Date 2021/10/28 17:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult <T>{
    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code,String message){
        this.code=code;
        this.message=message;
    }

}
