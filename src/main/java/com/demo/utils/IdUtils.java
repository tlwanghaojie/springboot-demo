package com.demo.utils;

import java.util.Random;

/**
 * @author wanghj
 * @description 各种id生成策略
 * @createTime 2021/12/24 14:14
 */
public class IdUtils {
	/**
	 * description 图片名生成
	 *
	 * @return java.lang.String
	 **/
	public static String genImageName() {
		// 取当前时间的长整型值包含毫秒
		long mills = System.currentTimeMillis();
		// 加上随机三位数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 不足两位前面补0
		return mills + String.format("%03d", end3);
	}

	/**
	 * description 商品id生成
	 *
	 * @return java.lang.String
	 **/
	public static String genStringId() {
		// 取当前时间的长整型值包含毫秒
		long mills = System.currentTimeMillis();
		// 加上随机两位数
		Random random = new Random();
		int end2 = random.nextInt(99);
		return mills + String.format("%02d", end2);
	}

	/**
	 * description long型id生成
	 *
	 * @return Long
	 **/
	public static Long getLongId() {
		// 取当前时间的长整型值包含毫秒
		long mills = System.currentTimeMillis();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 不足两位前面补0
		String str = mills + String.format("%02d", end2);
		return new Long(str);
	}
}
