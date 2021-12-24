package com.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.advice.ResponseInfo;

/**
 * @author wanghj
 * @description 武侠service层
 * @createTime 2021/12/24 11:01
 */
public interface PersonsService {
	/**
	 * description 分页查询武侠信息
	 *
	 * @param pageNum  页数
	 * @param pageSize 页面内容数量
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo personsList(int pageNum, int pageSize);

	/**
	 * description 更新武侠信息
	 *
	 * @param person 武侠json字符串
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo updatePerson(JSONObject person);

	/**
	 * description 批量更新武侠信息
	 *
	 * @param personArray 武侠列表json字符串
	 * @return com.alibaba.fastjson.JSONObject
	 **/
	JSONObject updatePersonBatch(JSONArray personArray);

	/**
	 * description 新增武侠信息
	 *
	 * @param person 武侠json字符串
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo addPerson(JSONObject person);

	/**
	 * description 根据门派进行模糊查询武侠信息
	 *
	 * @param person 门派信息
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo searchPerson(JSONObject person);

	/**
	 * description 根据id删除武侠信息
	 *
	 * @param id 武侠id
	 * @return com.demo.advice.ResponseInfo
	 **/
	ResponseInfo deletePersonById(Long id);
}
