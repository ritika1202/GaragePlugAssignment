package com.project1.garagePlug.services;

import java.util.List;

import com.project1.garagePlug.entities.GaragePlugEntity;


public interface GaragePlugService {

	List<GaragePlugEntity> getAll();

	GaragePlugEntity getById(int parseInt);

	GaragePlugEntity addCustomerDetail(GaragePlugEntity entity1);

	GaragePlugEntity updateCustomerDetails(GaragePlugEntity entity1);

}
