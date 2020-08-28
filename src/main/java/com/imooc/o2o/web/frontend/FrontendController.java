package com.imooc.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/frontend")
public class FrontendController {

	/**
	 * 建立路由转发到前台首页
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	private String index() {
		return "frontend/index";
	}
	
	/**
	 * 建立路由转发到商品列表页
	 * @return
	 */
	@RequestMapping(value="/shoplist",method=RequestMethod.GET)
	private String shopList() {
		return "frontend/shoplist";
	}
	
	/**
	 * 建立路由转发到商店详情页
	 * @return
	 */
	@RequestMapping(value="/shopdetail",method=RequestMethod.GET)
	private String shopDetail() {
		return "frontend/shopdetail";
	}
	
	/**
	 * 建立路由转发到商品详情页
	 * @return
	 */
	@RequestMapping(value="/productdetail",method=RequestMethod.GET)
	private String productDetail() {
		return "frontend/productdetail";
	}
}
