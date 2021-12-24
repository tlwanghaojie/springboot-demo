package com.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.advice.BusinessErrorException;
import com.demo.advice.BusinessMsgEnum;
import com.demo.advice.ResponseInfo;
import com.demo.annotation.ParamCheckAnnotation;
import com.demo.dao.PersonsMapper;
import com.demo.model.Persons;
import com.demo.service.PersonsService;
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
 * @description
 * @createTime 2021/12/24 12:30
 */
@Service
@Slf4j
public class PersonsServiceImpl implements PersonsService {
	@Resource
	private PersonsMapper personsMapper;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public ResponseInfo personsList(int pageNum, int pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Persons> personsList = personsMapper.getPersonsList();
			PageInfo<Persons> pageInfo = new PageInfo<>(personsList);
			log.info("查询武侠列表成功--------->,{}", pageInfo.getList());
			return new ResponseInfo(pageInfo.getList(), pageInfo.getTotal());
		} catch (Exception e) {
			log.error("获取武侠列表失败------>()", e.getMessage());
			throw new BusinessErrorException(BusinessMsgEnum.ERROR_EXCEPTION);
		}
	}

	@Override
	@ParamCheckAnnotation()
	public ResponseInfo updatePerson(JSONObject person) {
		try {
			String personStr = JSONObject.toJSONString(person);
			Persons persons = JSONObject.parseObject(personStr, Persons.class);
			persons.setModifytime(dateFormat.format(new Date()));
			personsMapper.updatePersons(persons);
			log.info("武侠信息更新成功---->{}", persons);
			return new ResponseInfo(0, "success");
		} catch (Exception e) {
			log.error("更新武侠信息失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "异常异常！");
		}
	}

	@Override
	@ParamCheckAnnotation
	public ResponseInfo addPerson(JSONObject person) {
		try {
			String personStr = JSONObject.toJSONString(person);
			Persons persons = JSONObject.parseObject(personStr, Persons.class);
			Date date = new Date();
			persons.setId(IdUtils.getLongId());
			persons.setCreatetime(dateFormat.format(date));
			persons.setModifytime(dateFormat.format(date));
			personsMapper.addPersons(persons);
			log.info("武侠信息新增成功---->{}", persons);
			return new ResponseInfo(0, "success");
		} catch (Exception e) {
			log.info("武侠信息新增失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "新增武侠异常！");
		}
	}

	@Override
	public JSONObject updatePersonBatch(JSONArray personArray) {
		JSONObject result = new JSONObject();
		try {
			result.put("code", "0");
			result.put("msg", "success");
			String personsStr = JSONObject.toJSONString(personArray);
			List<Persons> personsList = JSONArray.parseArray(personsStr, Persons.class);
			personsMapper.updatePersonsBatch(personsList);
			log.info("武侠信息更新成功---->{}", personsList);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", "500");
			result.put("msg", "error");
			log.error("更新武侠信息失败--------->{}", e.getMessage());
		}
		return result;
	}

	@Override
	public ResponseInfo searchPerson(JSONObject person) {
		int pageNum = person.getInteger("pageNum");
		int pageSize = person.getInteger("pageSize");
		try {
			PageHelper.startPage(pageNum, pageSize);
			String personsStr = JSONObject.toJSONString(person);
			Persons persons = JSONObject.parseObject(personsStr, Persons.class);
			List<Persons> personsList = personsMapper.searchPersons(persons);
			PageInfo<Persons> pageInfo = new PageInfo<>(personsList);
			log.info("武侠信息查询成功---->{}", personsList);
			return new ResponseInfo(pageInfo.getList(), pageInfo.getTotal());
		} catch (Exception e) {
			log.error("武侠信息查询失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "查询武侠信息异常！");
		}
	}

	@Override
	public ResponseInfo deletePersonById(Long id) {
		try {
			personsMapper.deletePersonsById(id);
			log.info("武侠信息删除成功---->{}", id);
			return new ResponseInfo(0, "删除武侠成功！");
		} catch (Exception e) {
			log.error("武侠信息删除失败--------->{}", e.getMessage());
			return new ResponseInfo(500, "删除武侠异常！");
		}
	}
}
