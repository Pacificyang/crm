package cn.pacificy.crm.controller;

import cn.pacificy.crm.pojo.BaseDict;
import cn.pacificy.crm.pojo.Appserver;
import cn.pacificy.crm.pojo.AppserverQueryVo;
import cn.pacificy.crm.service.AppserverService;
import cn.pacificy.crm.service.BaseDictService;
import cn.pacificy.crm.service.CustomerService;
import cn.pacificy.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class AppserverController {
//	//客户来源
//	@Value("${customer_source}")
//	private String customerSource;
//	//客户行业
//	@Value("${customer_industry}")
//	private String customerIndustry;
//	//客户级别
//	@Value("${customer_level}")
//	private String customerLevel;
	
	//引用我们service层的对象
//	@Autowired
//	private BaseDictService baseDictService;
	
	
	@Autowired
	private AppserverService appserverService;
	
	
	/**
	 * 显示我们customer.jsp页面出来
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/appserver/list")
	public ModelAndView getAppserverList(AppserverQueryVo queryVo) throws UnsupportedEncodingException{
if(StringUtils.isNotBlank(queryVo.getAppserverName())){
			
			String appserverName = new String(queryVo.getAppserverName().getBytes("iso-8859-1"), "utf-8");
			queryVo.setAppserverName(appserverName);
		}
		
		
		
		ModelAndView view = new ModelAndView();
//		//查询我们下拉框的数出来到页面上进行展示
//		List<BaseDict> customerSourceList = baseDictService.getCustomerSourceList(customerSource);
//		List<BaseDict> customerIndustryList = baseDictService.getCustomerSourceList(customerIndustry);
//		List<BaseDict> customerLevelList = baseDictService.getCustomerSourceList(customerLevel);
		
		Page<Appserver> appserverPage = appserverService.getAppserverPage(queryVo);
		System.out.println(appserverPage.getRows());
		
		view.addObject("page", appserverPage);
		
		
//		view.addObject("fromType", customerSourceList);
//		view.addObject("industryType", customerIndustryList);
//		view.addObject("levelType", customerLevelList);
		//把我们的查询条件全部带到页面上去进行回显
		view.addObject("appserverName", queryVo.getAppserverName());
//		view.addObject("custSource", queryVo.getCustSource());
//		view.addObject("custIndustry", queryVo.getCustIndustry());
//		view.addObject("custLevel", queryVo.getCustLevel());
		view.setViewName("appserver");
		return view;
	}
	
	@RequestMapping("/appserver/edit.action")
	@ResponseBody
	public Appserver editAppserver(Integer id){
		Appserver appserver  = appserverService.getAppserverById(id);
		return appserver;
	}
	
	
	
	
	@RequestMapping("/appserver/update.action")
	@ResponseBody
	public String updateCustomer(Appserver appserver){
		appserverService.updateAppserver(appserver);
		return "success";
	}
	
	
	@RequestMapping("/appserver/delete.action")
	@ResponseBody
	public String deleteAppserver(Integer id){
		appserverService.deleteById(id);
		
		return "success";
	}
	
	
	
	

}
