package com.project1.garagePlug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project1.garagePlug.entities.GaragePlugEntity;
import com.project1.garagePlug.services.GaragePlugService;

@RestController
public class GaragePlugController {
	@Autowired
    GaragePlugService garageplugservice;
	@GetMapping("/showAll")
    public List<GaragePlugEntity> getCustomerInfo()
    {
		return garageplugservice.getAll();
        
    }
    @GetMapping("/showAll/{Custid}")
    public GaragePlugEntity getInfo(@PathVariable String Custid)
    {
    	return garageplugservice.getById(Integer.parseInt(Custid));
    }
    @PostMapping("/Add")
    public GaragePlugEntity addCustomerDetails(@RequestBody GaragePlugEntity entity1)
    {
    	return garageplugservice.addCustomerDetail(entity1);
    }
    @PutMapping("/Update")
    public GaragePlugEntity updateCustomerDetail(@RequestBody GaragePlugEntity entity1)
    {
    	return this.garageplugservice.updateCustomerDetails(entity1);
    }


}
