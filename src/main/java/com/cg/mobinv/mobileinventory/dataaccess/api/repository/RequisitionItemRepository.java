package com.cg.mobinv.mobileinventory.dataaccess.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionItemEntity;

@Transactional
public interface RequisitionItemRepository extends JpaRepository<RequisitionItemEntity, Long> {

	@Query("select item from RequisitionItemEntity item where item.itemDesc = :itemDesc and item.requisitionHeader.requisitionDescription = :requisitionDescription")
	RequisitionItemEntity findByItemDescAndReqDesc(@Param("itemDesc") String itemDesc, @Param("requisitionDescription") String requisitionDescription);

}
