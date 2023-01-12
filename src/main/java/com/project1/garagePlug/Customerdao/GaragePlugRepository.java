package com.project1.garagePlug.Customerdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1.garagePlug.entities.GaragePlugEntity;

import java.util.List;

@Repository
public interface GaragePlugRepository extends JpaRepository<GaragePlugEntity,Integer>           {

    List<GaragePlugEntity> findAllByCustomerId(int id);
}
