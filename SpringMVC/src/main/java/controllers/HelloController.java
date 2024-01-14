package controllers;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello()
	{
		return "hello";
	}
	
	@RequestMapping("/greet")
	public ModelAndView greet(HttpServletRequest request) // To accept the only one req.parameter
	{
		String nm=request.getParameter("name");
		return new ModelAndView("greet","name",nm);	
	}
	
	@RequestMapping("/info")
	public String getInfo(HttpServletRequest request,ModelMap map)
	{
		map.addAttribute("req_url",request.getRequestURI());
		map.addAttribute("req_method",request.getMethod());
		Enumeration <String> names=request.getParameterNames();
		int count=0;
		while(names.hasMoreElements())
		{
			System.out.println(request.getParameter(names.nextElement()));
			count++;
		}
		map.addAttribute("para_count",count);
		map.addAttribute("host",request.getServerName());
		return "info";
	}
	
	@RequestMapping("/findFactors")
	public String  getFactors(HttpServletRequest request,ModelMap map)
	{
		int number=Integer.parseInt(request.getParameter("number"));
		
		Set<Integer>factors=new HashSet();
		for(int i=1;i<=number;i++)
		{
			if(number%i==0)
			{
				factors.add(i);
			}
		}
		return "findFactors";
		
	}
	
}
