package cn.pacificy.crm.service;

import cn.pacificy.crm.pojo.Appserver;
import cn.pacificy.crm.pojo.AppserverQueryVo;
import cn.pacificy.crm.utils.Page;

public interface AppserverService {

	Page<Appserver> getAppserverPage(AppserverQueryVo appserverQueryVo);

	Appserver getAppserverById(Integer id);

	void updateAppserver(Appserver appserver);

	void deleteById(Integer id);

}
