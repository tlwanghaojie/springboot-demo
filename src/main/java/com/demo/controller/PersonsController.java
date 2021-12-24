package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.advice.ResponseInfo;
import com.demo.annotation.ParamCheckAnnotation;
import com.demo.service.PersonsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanghj
 * @description 武侠控制层
 * @createTime 2021/12/24 12:36
 */
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonsController {
	@Resource
	private PersonsService personsService;

	@RequestMapping(value = "/personsList", method = RequestMethod.GET)
	public ResponseInfo getPersonList(int pageNum, int pageSize) {
		return personsService.personsList(pageNum, pageSize);
	}

	@RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
	@ParamCheckAnnotation()
	public ResponseInfo updatePerson(@RequestBody JSONObject person) {
		return personsService.updatePerson(person);
	}

	@RequestMapping(value = "/updatePersonBatch", method = RequestMethod.POST)
	public JSONObject updatePersonBatch(@RequestBody JSONArray personArray) {
		return personsService.updatePersonBatch(personArray);
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	@ParamCheckAnnotation()
	public ResponseInfo addPerson(@RequestBody JSONObject person) {
		return personsService.addPerson(person);
	}

	@RequestMapping(value = "/searchPerson", method = RequestMethod.POST)
	public ResponseInfo searchPerson(@RequestBody JSONObject person) {
		return personsService.searchPerson(person);
	}

	@RequestMapping(value = "/deletePersonById", method = RequestMethod.GET)
	public ResponseInfo deletePersonById(@Param("id") Long id) {
		return personsService.deletePersonById(id);
	}
}
