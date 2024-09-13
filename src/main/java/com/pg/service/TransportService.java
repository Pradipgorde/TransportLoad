package com.pg.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.entity.TransportBean;
import com.pg.repository.TranportRepository;

@Service
public class TransportService implements ItransportService
{
	
	@Autowired
	private TranportRepository repo;
	
	

	@Override
	public String saveTranport(TransportBean transport) 
	{
		 
		Integer shipperId = repo.save(transport).getShipperId();
		
	
		return "Transport Details Added sucessfully With ID:"+shipperId;
	}



	@Override
	public Iterable<TransportBean> getAllData() 
	{
	   
		 Iterable<TransportBean> list = repo.findAll();
		 
		 return list;
		
		
	}



	@Override
	public TransportBean getById(Integer id) 
	{
	    
		    
		     Optional<TransportBean> list = repo.findById(id);
		 if(list.isPresent())
		 {
		TransportBean transportBean = list.get();
		
		return transportBean;}
		 else return null;
	}



	@Override
	public String updateData(TransportBean transport) 
	{
	   
		Optional<TransportBean> findById = repo.findById(transport.getShipperId());
		if(findById.isPresent())
		{
			
		  repo.save(transport);
		
		   return "Loading Details Updated With ID: "+transport.getShipperId();
		}else
		return "Details Not Found";
	}



	@Override
	public String deleteData(Integer id) 
	{
	
		 Optional<TransportBean> list = repo.findById(id);
		 if(list.isPresent())
		 {
		 repo.deleteById(id);
		
		return "Record Deleted Sucesfully";
		} 
	
		
		 else
		return "Record Not found with Id:"+id;
	}
	
	
	
	
	
	

}
