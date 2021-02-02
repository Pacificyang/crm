package cn.pacificy.crm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pacificy.crm.pojo.BaseDict;
import cn.pacificy.crm.pojo.Customer;
import cn.pacificy.crm.pojo.QueryVo;
import cn.pacificy.crm.service.BaseDictService;
import cn.pacificy.crm.service.CustomerService;
import cn.pacificy.crm.utils.Page;
import sun.tools.tree.NewArrayExpression;

@Controller
public class CustomerController {
	//客户来源
	@Value("${customer_source}")
	private String customerSource;
	//客户行业
	@Value("${customer_industry}")
	private String customerIndustry;
	//客户级别
	@Value("${customer_level}")
	private String customerLevel;
	
	//引用我们service层的对象
	@Autowired
	private BaseDictService baseDictService;
	
	
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * 显示我们customer.jsp页面出来
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/customer/list")
	public ModelAndView getCustomerList(QueryVo queryVo) throws UnsupportedEncodingException{
		if(StringUtils.isNotBlank(queryVo.getCustName())){
			
			String custName = new String(queryVo.getCustName().getBytes("iso-8859-1"), "utf-8");
			queryVo.setCustName(custName);
		}
		
		
		
		ModelAndView view = new ModelAndView();
		//查询我们下拉框的数出来到页面上进行展示
		List<BaseDict> customerSourceList = baseDictService.getCustomerSourceList(customerSource);
		List<BaseDict> customerIndustryList = baseDictService.getCustomerSourceList(customerIndustry);
		List<BaseDict> customerLevelList = baseDictService.getCustomerSourceList(customerLevel);
		
		Page<Customer> customerPage = customerService.getCustomerPage(queryVo);
		System.out.println(customerPage.getRows());
		
		view.addObject("page", customerPage);
		
		
		view.addObject("fromType", customerSourceList);
		view.addObject("industryType", customerIndustryList);
		view.addObject("levelType", customerLevelList);
		//把我们的查询条件全部带到页面上去进行回显
		view.addObject("custName", queryVo.getCustName());
		view.addObject("custSource", queryVo.getCustSource());
		view.addObject("custIndustry", queryVo.getCustIndustry());
		view.addObject("custLevel", queryVo.getCustLevel());
		view.setViewName("customer");
		return view;
	}
	
	@RequestMapping("/customer/edit.action")
	@ResponseBody
	public Customer editCustomer(Integer id){
		Customer customer  = customerService.getCustomerById(id);
		return customer;
	}
	
	
	
	
	@RequestMapping("/customer/update.action")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return "success";
	}
	
	
	@RequestMapping("/customer/delete.action")
	@ResponseBody
	public String deleteCustomer(Integer id){
		customerService.deleteById(id);
		
		return "success";
	}
	
	
	
	

}
