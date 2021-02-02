package cn.pacificy.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pacificy.crm.mapper.BaseDictMapper;
import cn.pacificy.crm.mapper.CustomerMapper;
import cn.pacificy.crm.pojo.BaseDict;

@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

	
	@Autowired
	private BaseDictMapper baseDictMapper;
	
	
	@Override
	public List<BaseDict> getCustomerSourceList(String customerSource) {
		List<BaseDict> baseDictList = baseDictMapper.getCustomerByCode(customerSource);
		return baseDictList;
	}

	

}
