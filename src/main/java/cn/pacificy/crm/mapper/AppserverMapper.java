package cn.pacificy.crm.mapper;

import cn.pacificy.crm.pojo.Appserver;
import cn.pacificy.crm.pojo.AppserverQueryVo;

import java.util.List;

public interface AppserverMapper {

	List<Appserver> getAppserverListWithCond(AppserverQueryVo appserverQueryVo);

	int getTotalResult(AppserverQueryVo appserverQueryVo);

	Appserver getAppserverById(Integer id);

	void updateAppserver(Appserver appserver);

	void deleteAppserverById(Integer id);

	

}
