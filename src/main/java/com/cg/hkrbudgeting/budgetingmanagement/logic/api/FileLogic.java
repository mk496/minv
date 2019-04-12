package com.cg.hkrbudgeting.budgetingmanagement.logic.api;

import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource.BinaryData;

import com.cg.hkrbudgeting.budgetingmanagement.common.api.to.FileTo;

public interface FileLogic extends LogicComponent<FileTo>{
	
	BinaryData readBinaryData(Object mediaEnity);

	FileTo writeBinaryData(BinaryData mediaData, FileTo mediaEntity);
	
}
