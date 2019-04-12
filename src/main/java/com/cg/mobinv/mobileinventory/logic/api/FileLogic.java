package com.cg.mobinv.mobileinventory.logic.api;

import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource.BinaryData;

import com.cg.mobinv.mobileinventory.common.api.to.FileTo;

public interface FileLogic extends LogicComponent<FileTo>{
	
	BinaryData readBinaryData(Object mediaEnity);

	FileTo writeBinaryData(BinaryData mediaData, FileTo mediaEntity);
	
}
