package cn.pacificy.crm.service;

import cn.pacificy.crm.mapper.AppserverMapper;
import cn.pacificy.crm.pojo.Appserver;
import cn.pacificy.crm.pojo.AppserverQueryVo;
import cn.pacificy.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppserverServiceImpl implements AppserverService {
	
	@Autowired
	private AppserverMapper appserverMapper;
	
	
	/**
	 * 分页查询的所有的逻辑都在这里封装
	 */
	@Override
	public Page<Appserver> getAppserverPage(AppserverQueryVo appserverQueryVo) {
		Page<Appserver> appserverPage = new Page<Appserver>();
		
		int start = appserverQueryVo.getPage()*appserverQueryVo.getSize()-appserverQueryVo.getSize();
		appserverQueryVo.setStart(start);
		//查询我们分页的数据出来
		List<Appserver> appserverList  = appserverMapper.getAppserverListWithCond(appserverQueryVo);
		//查询我们分页的总记录数
		
		int totalResult = appserverMapper.getTotalResult(appserverQueryVo);
		System.out.println(totalResult);
		appserverPage.setPage(appserverQueryVo.getPage());
		appserverPage.setRows(appserverList);
		appserverPage.setSize(appserverQueryVo.getSize());
		appserverPage.setTotal(totalResult);
		System.out.println(appserverList.size());
		return appserverPage;
	}


	@Override
	public Appserver getAppserverById(Integer id) {
		Appserver appserver = appserverMapper.getAppserverById(id);
		return appserver;
	}


	@Override
	public void updateAppserver(Appserver appserver) {
		appserverMapper.updateAppserver(appserver);
		
	}



	@Override
	public void deleteById(Integer id) {
		appserverMapper.deleteAppserverById(id);
		
	}

	
}
