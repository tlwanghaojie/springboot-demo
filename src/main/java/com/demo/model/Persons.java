package com.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanghj
 * @description 武侠信息表
 * @createTime 2021/12/24 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persons implements Serializable {
	/**
	 * 武侠id
	 */
	private Long id;

	/**
	 * 武侠姓名
	 */
	private String name;

	/**
	 * 武侠年龄
	 */
	private Long age;

	/**
	 * 武侠性别
	 */
	private String sex;

	/**
	 * 武侠住址
	 */
	private String address;

	/**
	 * 武侠门派
	 */
	private String sect;

	/**
	 * 武侠绝技
	 */
	private String skill;

	/**
	 * 战力值
	 */
	private Integer power;

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
