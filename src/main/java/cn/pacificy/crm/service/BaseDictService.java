package cn.pacificy.crm.service;

import java.util.List;

import cn.pacificy.crm.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> getCustomerSourceList(String customerSource);

}
