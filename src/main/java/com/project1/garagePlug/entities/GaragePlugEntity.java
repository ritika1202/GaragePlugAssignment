package com.project1.garagePlug.entities;


import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Table(name="CustomerDetails")
public class GaragePlugEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int OrderId;
   private int customerId;
   private String customerName;
	private String customerOrder;

    @Column(length = 32, columnDefinition = "varchar(32) default 'Regular'")
	@Enumerated(EnumType.STRING) 
	private CustomerMembership membership;
    private float ItemPrice;
   private int discountPercentage;

}
