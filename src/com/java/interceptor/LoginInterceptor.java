package com.java.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpAccount;


public class LoginInterceptor implements HandlerInterceptor{



	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
			System.out.println("===========执行3 after");
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
			System.out.println("===========执行2 post");
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
			System.out.println("===========执行1 pre");
		
		String uri = request.getRequestURI();
		boolean flag = false;
		if(uri.indexOf("public")>-1){
			flag = true;
			System.out.println("##################### 有public");
		}else if(uri.indexOf("login")>-1||uri.indexOf("Login")>-1){
					flag = true;
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@y有登录的动作执行");
			  }else {
					ErpAccount erpAccount = (ErpAccount) request.getSession().getAttribute("erpAccount");
					List<String>  doPathList = (List<String>)request.getSession().getAttribute("myDoPathList");
					System.out.println(erpAccount.getUsername()+"<><><><><><><><><><><><>");
					if(erpAccount!=null){
						System.out.println("！！！！！！！！！！！！！！进行过登录  有数据");
						System.out.println(uri);
						for(String path:doPathList){
							if(uri.indexOf(path)>-1){
								flag = true;
							}
						}
						
					}else{
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~未进行登录 无数据");
						request.getRequestDispatcher("/WEB-INF/jsp/public/bigdatalogin.jsp").forward(request, response);
			}
		}
		
		
		return true;
	}

}
