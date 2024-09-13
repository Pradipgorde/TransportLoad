package com.pg.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TranportData")
public class TransportBean 
{
	
	@Column(name="shipperId")
	@Id
	@SequenceGenerator(name="gen1",sequenceName="Seq_shipId",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer shipperId;
	
	@Column(length=50)
	private String loadingPoint;
	
	@Column(length=50)
	private String unloadingPoint;
	
	@Column(length=50)
	private String productType;
	
	@Column(length=50)
	private String truckType;
	
	@Column
	private Integer numberOfTruck;
	
	@Column
	private Integer weight;
	
	@Column
	private String remark;
	
	@Column 
	private LocalDate loadingDate;
	
	
	

}
