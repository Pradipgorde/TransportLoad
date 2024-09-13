package com.pg.service;

import com.pg.entity.TransportBean;

public interface ItransportService
{
	
	public String saveTranport(TransportBean transport);
	
	public Iterable<TransportBean> getAllData();
	
	public TransportBean getById(Integer id);
	
	public String updateData(TransportBean transport);
	
	
	public String deleteData(Integer id);
	

}
