package com.pg.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.entity.TransportBean;
import com.pg.service.ItransportService;

@RestController
@RequestMapping("/transport-api")
public class TransportController 
{
	@Autowired 
	private ItransportService service;
	
	
	@PostMapping("/load")  
	public ResponseEntity<String> saveTransportData(@RequestBody TransportBean transport)
	{
		
		  String msg = service.saveTranport(transport);
		
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/load")
	public ResponseEntity<Iterable<TransportBean>> getAllDetails()
	{
		
		
		Iterable<TransportBean> data = service.getAllData();
		
		 return new ResponseEntity<Iterable<TransportBean>>(data,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/find/{shipperId}")
	public ResponseEntity<?> getById(@PathVariable("shipperId") Integer shipperId)
	{
		
		   TransportBean list = service.getById(shipperId);
		   
		   if(list!=null)
		   {
			   return new ResponseEntity<>(list,HttpStatus.OK);
		   }
		   else
		   
		return new ResponseEntity<>("Record not Found",HttpStatus.OK);
		
		
		
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateLoad(@RequestBody TransportBean transport)
	{
		
		
		   String msg = service.updateData(transport);
		   
		   return new ResponseEntity<String>(msg,HttpStatus.OK);
		 
		
	}
	
	@DeleteMapping("/delete/{shipperId}")
	public ResponseEntity<String> deleteById(@PathVariable("shipperId") Integer shipperId) 
	{
		
		
		String msg = service.deleteData(shipperId);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
		
	}
	
	
	

}
