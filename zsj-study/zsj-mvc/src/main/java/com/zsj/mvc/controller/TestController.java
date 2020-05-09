package com.zsj.mvc.controller;

import com.zsj.mvc.bean.MyBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller("")
public class TestController {

	@RequestMapping("/s")
	@ResponseBody
	public String sayHello() {
		ModelAndView mav = new ModelAndView();
		MyBean bean = new MyBean();
		mav.addObject("myBean", bean);
		mav.setViewName("Hello");
		System.out.println(bean.toString());
		return mav.toString();
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		ModelAndView mav = new ModelAndView();
		MyBean bean = new MyBean();
		mav.addObject("myBean", bean);
		mav.setViewName("Hello");
		System.out.println(bean.toString());
		return mav.toString();
	}
}
