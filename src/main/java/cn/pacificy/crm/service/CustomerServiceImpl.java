package cn.pacificy.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pacificy.crm.mapper.CustomerMapper;
import cn.pacificy.crm.pojo.Customer;
import cn.pacificy.crm.pojo.QueryVo;
import cn.pacificy.crm.utils.Page;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	
	/**
	 * 分页查询的所有的逻辑都在这里封装
	 */
	@Override
	public Page<Customer> getCustomerPage(QueryVo queryVo) {
		Page<Customer> customerPage = new Page<Customer>();
		
		int start = queryVo.getPage()*queryVo.getSize()-queryVo.getSize();
		queryVo.setStart(start);
		//查询我们分页的数据出来
		List<Customer> customerList  = customerMapper.getCustomerListWithCond(queryVo);
		//查询我们分页的总记录数
		
		int totalResult = customerMapper.getTotalResult(queryVo);
		System.out.println(totalResult);
		customerPage.setPage(queryVo.getPage());
		customerPage.setRows(customerList);
		customerPage.setSize(queryVo.getSize());
		customerPage.setTotal(totalResult);
		System.out.println(customerList.size());
		return customerPage;
	}


	@Override
	public Customer getCustomerById(Integer id) {
		Customer customer = customerMapper.getCustomerById(id);
		return customer;
	}


	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
		
	}


	@Override
	public void deleteById(Integer id) {
		customerMapper.deleteCustomerById(id);
		
	}

	
}
