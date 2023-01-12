package com.project1.garagePlug.services;

import java.util.List;
import java.util.Optional;

import com.project1.garagePlug.entities.CustomerMembership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.garagePlug.Customerdao.GaragePlugRepository;
import com.project1.garagePlug.entities.GaragePlugEntity;


@Service
public class GaragePlugServiceImpl implements GaragePlugService {
   @Autowired
	private GaragePlugRepository garageplugrepository;
	@Override
	public List<GaragePlugEntity> getAll() {

		return  garageplugrepository.findAll();
	}
	@Override
	public GaragePlugEntity getById(int OrderId) {
		Optional<GaragePlugEntity> fetchOrder = garageplugrepository.findById(OrderId);
		GaragePlugEntity garagePlugEntity = new GaragePlugEntity();
		if(fetchOrder.isPresent())
		{
			garagePlugEntity = fetchOrder.get();
		}

		return garagePlugEntity;
	}
	@Override
	public GaragePlugEntity addCustomerDetail(GaragePlugEntity entity1) {
		// TODO Auto-generated method stub
			List<GaragePlugEntity> fetchAllOrderById=garageplugrepository.findAllByCustomerId(entity1.getCustomerId());
		try{
			if(fetchAllOrderById.size() != 0)
			{
				entity1.setMembership(fetchAllOrderById.size() >= 10 && fetchAllOrderById.size()<20 ? CustomerMembership.Gold : fetchAllOrderById.size()>=20 ? CustomerMembership.Platinum : CustomerMembership.Regular);
				entity1.setDiscountPercentage(fetchAllOrderById.size() >= 10 && fetchAllOrderById.size()<20 ? 10 : fetchAllOrderById.size()>=20 ? 20 : 0);
			}
		}
		catch (Exception e)
		{
			throw new NullPointerException();
		}
		garageplugrepository.save(entity1);
		return entity1;
	}
	@Override
	public GaragePlugEntity updateCustomerDetails(GaragePlugEntity entity1) {
		// TODO Auto-generated method stub
		garageplugrepository.save(entity1);
		return entity1;	}

	

}
