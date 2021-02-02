package cn.pacificy.crm.mapper;

import java.util.List;

import cn.pacificy.crm.pojo.BaseDict;
import cn.pacificy.crm.pojo.Customer;
import cn.pacificy.crm.pojo.QueryVo;

public interface CustomerMapper {

	List<Customer> getCustomerListWithCond(QueryVo queryVo);

	int getTotalResult(QueryVo queryVo);

	Customer getCustomerById(Integer id);

	void updateCustomer(Customer customer);

	void deleteCustomerById(Integer id);

	

}
