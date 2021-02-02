package cn.pacificy.crm.service;

import cn.pacificy.crm.pojo.Customer;
import cn.pacificy.crm.pojo.QueryVo;
import cn.pacificy.crm.utils.Page;

public interface CustomerService {

	Page<Customer> getCustomerPage(QueryVo queryVo);
	
	Customer getCustomerById(Integer id);

	void updateCustomer(Customer customer);

	void deleteById(Integer id);

}
