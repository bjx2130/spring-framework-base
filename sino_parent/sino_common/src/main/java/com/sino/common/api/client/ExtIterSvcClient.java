package com.sino.common.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sino.common.api.bs.bean.RespQueryCity;
import com.sino.common.api.bs.bean.ResponseWhite;
import com.sino.common.api.bs.bean.TaocanVo;

@Service
@FeignClient(value = "sinoExtIterface") // fallback 错误回滚 断路器功能
public interface ExtIterSvcClient {
	

	
	/**
	 * 查询白名单
	 * @param phone 手机号
	 * @param whiteCode 白名单编码
	 * @param version v1-单列号码    v2-多列
	 * @return
	 */
	@RequestMapping(value = "/existWhiteName")
	public ResponseWhite existWhiteName(@RequestParam(value = "phone")String phone
										,@RequestParam(value = "whiteCode")String whiteCode 
										,@RequestParam(value = "version")String version);
	
	/**
	 * 查询手机套餐
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/taocanCtg")
	public TaocanVo taocanCtg(@RequestParam(value = "name")String phone);
	
	/**
	 * 查询 手机所属城市
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/taocanCtg")
	public RespQueryCity queryCity(@RequestParam(value = "phone")String phone);
	
	
}
