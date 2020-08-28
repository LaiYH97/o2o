package com.imooc.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

public class ProductCategoryServiceTest extends BaseTest {

	@Autowired
	ProductCategoryService productCategoryService;
	
	@Test
	public void testGetProductCategoryList() {
		long shopId = 1;
		List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList(shopId);
		for(ProductCategory pc:productCategoryList) {
			System.out.printf("%s的权重：%s    ",pc.getProductCategoryName(),pc.getPriority());
		}
	}
}
