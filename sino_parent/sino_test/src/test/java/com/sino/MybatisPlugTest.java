package com.sino;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sino.dao.ProductDao;
import com.sino.vo.Product;


@SpringBootTest
@AutoConfigureMockMvc
class MybatisPlugTest {
	
	@Autowired
	private ProductDao productDao;
	
	@Test
	void test() {
		
		
		System.out.println("selectById返回结果： "+productDao.selectById(2));
		
		
		LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Product::getPdIndex, 0);
		queryWrapper.eq(Product::getPdIndex, 1);
		
		Page<Product> page = new Page<Product>();
		page.setCurrent(3);//当前页
		page.setSize(10);//单页数量
		Page<Product> rp =  productDao.selectPage(page, queryWrapper);
		System.out.println("selectPage返回结果： "+rp.getRecords());
		System.out.println("selectPage返回结果： "+rp.getTotal());
	}

}
