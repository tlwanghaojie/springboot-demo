package com.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.advice.BusinessErrorException;
import com.demo.advice.BusinessMsgEnum;
import com.demo.advice.ResponseInfo;
import com.demo.dao.GoodsMapper;
import com.demo.model.Goods;
import com.demo.service.GoodsService;
import com.demo.utils.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wanghj
 * @description 商品服务层实现类
 * @createTime 2021/12/24 16:33
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
	@Resource
	private GoodsMapper goodsMapper;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public ResponseInfo goodsList(int pageNum, int pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Goods> goodsList = goodsMapper.getGoodsList();
			PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
			log.info("查询商品成功--------->,{}", pageInfo.getList());
			return new ResponseInfo(pageInfo.getList(), pageInfo.getTotal());
		} catch (Exception e) {
			log.error("获取商品列表失败--------->{}", e.getMessage());
			throw new BusinessErrorException(BusinessMsgEnum.ERROR_EXCEPTION);
		}
	}

	@Override
	public ResponseInfo updateGoods(JSONObject goods) {
		try {
			String goodsStr = JSONObject.toJSONString(goods);
			Goods good = JSONObject.parseObject(goodsStr, Goods.class);
			good.setModifytime(dateFormat.format(new Date()));
			goodsMapper.updateGoods(good);
			log.info("商品更新成功---->{}", good);
			return new ResponseInfo(0, "success");
		} catch (Exception e) {
			log.error("更新商品信息失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "异常异常！");
		}
	}

	@Override
	public ResponseInfo addGoods(JSONObject goods) {
		try {
			String goodStr = JSONObject.toJSONString(goods);
			Goods good = JSONObject.parseObject(goodStr, Goods.class);
			Date date = new Date();
			good.setId(IdUtils.getLongId());
			good.setCreatetime(dateFormat.format(date));
			good.setModifytime(dateFormat.format(date));
			goodsMapper.addGoods(good);
			log.info("商品新增成功---->{}", good);
			return new ResponseInfo(0, "success");
		} catch (Exception e) {
			log.info("商品新增失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "异常异常！");
		}
	}

	@Override
	public ResponseInfo searchGoods(JSONObject goods) {
		int pageNum = goods.getInteger("pageNum");
		int pageSize = goods.getInteger("pageSize");
		try {
			PageHelper.startPage(pageNum, pageSize);
			String goodsStr = JSONObject.toJSONString(goods);
			Goods good = JSONObject.parseObject(goodsStr, Goods.class);
			List<Goods> goodsList = goodsMapper.searchGoods(good);
			PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
			log.info("商品信息查询成功---->{}", goodsList);
			return new ResponseInfo(pageInfo.getList(), pageInfo.getTotal());
		} catch (Exception e) {
			log.error("商品信息查询失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "查询商品信息异常！");
		}
	}

	@Override
	public ResponseInfo deleteGoodsById(Long id) {
		try {
			goodsMapper.deleteGoodsById(id);
			log.info("商品信息删除成功---->{}", id);
			return new ResponseInfo(0, "删除商品成功！");
		} catch (Exception e) {
			log.error("商品信息删除失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "删除商品异常！");
		}
	}
}
