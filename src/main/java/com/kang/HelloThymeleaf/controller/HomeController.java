package com.kang.HelloThymeleaf.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kang.HelloThymeleaf.dao.UserDao;
import com.kang.HelloThymeleaf.model.User;
import com.kang.HelloThymeleaf.test.MessageInput;
import com.kang.HelloThymeleaf.test.Passwords;
import com.kang.HelloThymeleaf.test.Result;
import com.kang.HelloThymeleaf.test.custom_model;



@Controller
public class HomeController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	 private SimpMessagingTemplate template;

	    
	   

	@RequestMapping(value="/authenticate.html")
	public ModelAndView authenticate() {
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("mytest/authenticate");
		return modelAndView;
	}
	
	@RequestMapping(value="/chart.html")
	public ModelAndView chart() {
		ModelAndView modelAndView =new ModelAndView();
		ArrayList<String> arrayList =new ArrayList<String>();
		arrayList.add("Apple");
		arrayList.add("Watermelon");
		arrayList.add("Strawberry");
		modelAndView.addObject("fruits",arrayList);
		modelAndView.setViewName("mytest/chart");
		modelAndView.addObject("test","Hi....");
		return modelAndView;
	}
	

	@RequestMapping(value="/administrator.html")
	
	public ModelAndView bootstrap() {
		ArrayList<User> users =userDao.getAllUser();
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.addObject("users",users);
		modelAndView.setViewName("administrator");
		return modelAndView;
	}
	
	@RequestMapping(value="/")
	public ModelAndView test( custom_model custom_model,final BindingResult bindingResult) {
		System.out.println(bindingResult);
		System.out.println(custom_model.getEmail());
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.addObject("hello","hello Thymeleaf");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	@RequestMapping(value="/login.html")
	public ModelAndView login() {
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@RequestMapping(value="/register.html")
	public ModelAndView register() {
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}
	@RequestMapping(value="/deviceList.html")
	public ModelAndView deviceList(HttpServletRequest httpServletRequest,@RequestParam(value="account", required=false) String account) {
		System.out.println("account:"+httpServletRequest.getParameter("account"));
		System.out.println("account:"+account);
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("deviceList");
		return modelAndView;
	}
	
	@RequestMapping(value="/example.html",method=RequestMethod.GET)
	public ModelAndView example(Passwords passwords) {
		passwords.setPassword("213");
		ModelAndView modelAndView =new ModelAndView();
		 HashMap<String, String> map =new HashMap<String, String>();
		 map.put("firstName","YuHao");
		 map.put("lastName","Kang");
		 modelAndView.addObject("map", map);
		 modelAndView.addObject("title", "Yu Hao Kang");
		 modelAndView.setViewName("mytest/example");
		return modelAndView;
	}
		@RequestMapping(value="/example.html",method=RequestMethod.POST)
		public ModelAndView checkpassword(@Valid Passwords passwords,BindingResult bindingResult) {
			ModelAndView model =new ModelAndView();
			if (bindingResult.hasErrors()) {
				System.out.println("bindingResult:"+bindingResult);
				 HashMap<String, String> map =new HashMap<String, String>();
				 map.put("firstName","YuHao");
				 map.put("lastName","Kang");
				 model.addObject("map", map);
				 model.addObject("title", "Yu Hao Kang");
				 //------------------------
				model.setViewName("mytest/example");
				
				return model;
			}else {
				model.setViewName("redirect:/");
				return model;
			}	
	}

		//7.這裡會自動Binding 放進 叫做 input 的 instance，將結果做一些處理，最後使用SimpMessagingTemplate廣播給各個訂閱/topic/showResult的Client。
		@MessageMapping("/add")
		// @SendTo("/topic/showResult")
		public void addNum(MessageInput input) throws Exception {
			Result result = new Result(input.getName() + "：" + input.getMessage());
			this.template.convertAndSend("/topic/showResult", result);
			// return result;
		}
		//11.這裡會廣播訂閱/queue/search的Client
		@MessageMapping("/search")
		@SendToUser("/queue/search") // <- maps to "/user/queue/search"，其實括弧內的destination其實也可以省略
		public String search(MessageInput input) {
			return "(System)Hi " + input.getName() + " , This message only for you.";
		}
}
