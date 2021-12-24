package com.demo.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.model.Persons;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanghj
 * @description 武侠mapper类
 * @createTime 2021/12/24 10:30
 */
@Mapper
public interface PersonsMapper {
	/**
	 * description 获取武侠列表信息
	 *
	 * @return java.util.List<com.demo.model.Persons>
	 **/
	List<Persons> getPersonsList();

	/**
	 * description 根据武侠姓名模糊查询武侠信息
	 *
	 * @param person 武侠实体类
	 * @return java.util.List<com.demo.model.Persons>
	 **/
	List<Persons> searchPersons(Persons person);

	/**
	 * description 根据id更新武侠信息
	 *
	 * @param person 武侠类
	 * @return int 是否更新成功
	 **/
	int updatePersons(Persons person);

	/**
	 * description 批量更新武侠信息
	 *
	 * @param persons 武侠list列表
	 * @return int是否更新成功
	 **/
	int updatePersonsBatch(List<Persons> persons);

	/**
	 * description 添加武侠信息
	 *
	 * @param person 武侠实体类
	 * @return int 是否添加成功
	 **/
	int addPersons(Persons person);

	/**
	 * description 根据id删除武侠信息
	 *
	 * @param id 武侠id
	 * @return int 是否删除成功
	 **/
	int deletePersonsById(@Param("id") Long id);
}
