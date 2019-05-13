package com.cg.mobinv.mobileinventory.dataaccess.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionHeaderEntity;

@Transactional
public interface RequisitionHeaderRepository extends JpaRepository<RequisitionHeaderEntity, Long> {

	RequisitionHeaderEntity findByReqDesc(String reqDesc);
	
}
