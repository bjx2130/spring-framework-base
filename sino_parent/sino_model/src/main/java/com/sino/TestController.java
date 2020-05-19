package com.sino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sino.dao.ProductDao;
import com.sino.vo.Product;

@Controller
public class TestController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductDao productDao;
	
	@ResponseBody
	@RequestMapping(value="test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String g() {
		
		String url = "http://localhost:9090/getProduct/928137";
		String prodJson =  restTemplate.getForObject(url, String.class);
		System.out.println(prodJson);
		
		return prodJson;
	}
	
	
	/**
	 * 测试分页地址 http://localhost:9091/page?page=0&size=10&sort=pd_Type,desc&sort=pd_Title,desc
	 * 
	 * 
	 * 参考SortHandlerMethodArgumentResolver源码实现。
	 * 	默认参数规则为 sort=name,DESC
	 * 	name： 表示要排序的字段名称
	 * 	DESC 、 ASC: 正序和倒序
	 * 	排序默认为ASC
   	 * 	sort=name
	 * 	sort=name,DESC
	 * 	sort=name1,DESC&sort=name2 表示同时排序多个字段
	 * 
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="page",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object page(Page<Product> page) {
		
		LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
//		queryWrapper.allEq(null, true);
		queryWrapper.eq(Product::getPdCode, "612001");
		queryWrapper.eq(Product::getPdType, 1);
		
		
		page.addOrder(new OrderItem().ascs("pd_code"));
		return productDao.selectPage(page, queryWrapper);
	}
	
	
}
