package com.demo.dao;

import com.demo.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wanghj
 * @description 商品mapper层
 * @createTime 2021/12/24 10:32
 */
@Mapper
public interface GoodsMapper {
	/**
	 * description 查询所有商品信息
	 *
	 * @return java.util.List<com.demo.model.Goods>
	 **/
	List<Goods> getGoodsList();

	/**
	 * description 根据id删除商品信息
	 *
	 * @param id 商品id
	 * @return int
	 **/
	int deleteGoodsById(Long id);

	/**
	 * description 新增商品信息
	 *
	 * @param record 商品实体类
	 * @return int
	 **/
	int addGoods(Goods record);

	/**
	 * description 选择性新增商品信息
	 *
	 * @param record 商品实体类
	 * @return int
	 **/
	int insertSelective(Goods record);

	/**
	 * description 根据商品类型查找商品信息
	 *
	 * @param goods 商品类型信息
	 * @return java.util.List<com.demo.model.Goods>
	 **/
	List<Goods> searchGoods(Goods goods);

	/**
	 * description 选择性更新商品信息
	 *
	 * @param record 商品实体类
	 * @return int
	 **/
	int updateGoods(Goods record);

	/**
	 * description 根据id更新商品信息
	 *
	 * @param record 商品实体类
	 * @return int
	 **/
	int updateByPrimaryKey(Goods record);
}
