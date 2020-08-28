package com.imooc.o2o.web.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Product;
import com.imooc.o2o.service.ProductService;
import com.imooc.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping(value="/frontend")
public class ProductDetailController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/listproductdetailpageinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> showProductDetail(HttpServletRequest request){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		//获取前台传过来的productId
		long productId = HttpServletRequestUtil.getLong(request, "productId");
		Product product = null;
		if(productId != -1) {
			product = productService.getProductById(productId);
			modelMap.put("product", product);
			modelMap.put("success", true);
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty productId");
		}
		return modelMap;
	}
}
