package cn.pacificy.crm.mapper;

import java.util.List;

import cn.pacificy.crm.pojo.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> getCustomerByCode(String customerSource);

}
