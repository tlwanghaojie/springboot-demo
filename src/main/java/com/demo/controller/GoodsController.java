package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.advice.ResponseInfo;
import com.demo.model.Goods;
import com.demo.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanghj
 * @description 商品控制层
 * @createTime 2021/12/24 16:27
 */
@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {
	@Resource
	private GoodsService goodsService;

	@RequestMapping(value = "/goodsList", method = RequestMethod.GET)
	public ResponseInfo getGoodList(int pageNum, int pageSize) {
		return goodsService.goodsList(pageNum, pageSize);
	}

	@RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
	public ResponseInfo updateGoods(@RequestBody JSONObject goods) {
		return goodsService.updateGoods(goods);
	}

	@RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	public ResponseInfo addGoods(@RequestBody JSONObject goods) {
		return goodsService.addGoods(goods);
	}

	@RequestMapping(value = "/searchGoods", method = RequestMethod.POST)
	public ResponseInfo searchPerson(@RequestBody JSONObject goods) {
		return goodsService.searchGoods(goods);
	}

	@RequestMapping(value = "/deleteGoodsById", method = RequestMethod.GET)
	public ResponseInfo deletePersonById(@Param("id") Long id) {
		return goodsService.deleteGoodsById(id);
	}
}
