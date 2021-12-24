package com.demo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@description 商品信息表
 *@author wanghj
 *@createTime 2021/12/24 10:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    /**
    * 商品id
    */
    private Long id;

    /**
    * 商品名称
    */
    private String name;

    /**
    * 商品类型
    */
    private String type;

    /**
    * 商品价格
    */
    private Double price;

    /**
    * 商品数量
    */
    private Integer size;

    /**
    * 商品状态
    */
    private String status;

    /**
    * 商品描述
    */
    private String description;

    /**
    * 修改时间
    */
    private String modifytime;

    /**
    * 创建时间
    */
    private String createtime;

    private static final long serialVersionUID = 1L;
}
