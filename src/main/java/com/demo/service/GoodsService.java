package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.advice.ResponseInfo;
import com.demo.model.Goods;

/**
 * @author wanghj
 * @description 商品服务层
 * @createTime 2021/12/24 16:29
 */
public interface GoodsService {
	/**
	 * description 分页查询商品信息
	 *
	 * @param pageNum  页数
	 * @param pageSize 每页数据条数
	 * @return ResponseInfo
	 **/
	ResponseInfo goodsList(int pageNum, int pageSize);

	/**
	 * description 更新商品信息
	 *
	 * @param goods 商品信息
	 * @return com.alibaba.fastjson.JSONObject
	 **/
	ResponseInfo updateGoods(JSONObject goods);

	/**
	 * description 增加商品信息
	 *
	 * @param goods 商品信息
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo addGoods(JSONObject goods);

	/**
	 * description 根据门派进行模糊查询武侠信息
	 *
	 * @param goods 商品类型
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo searchGoods(JSONObject goods);

	/**
	 * description 根据id删除商品信息
	 *
	 * @param id 商品id
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo deleteGoodsById(Long id);
}
