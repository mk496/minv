package com.cg.hkrbudgeting.budgetingmanagement.logic.impl;

import com.cg.hkrbudgeting.budgetingmanagement.common.api.to.FileTo;
import com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.FileEntity;
import com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.repository.FileEntityRepository;
import com.cg.hkrbudgeting.budgetingmanagement.logic.api.FileLogic;

import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource.BinaryData;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileLogicImpl implements FileLogic {

	private final Logger logger = LoggerFactory.getLogger(FileLogicImpl.class);

	@Inject
	private FileEntityRepository fileRepository;

	@Inject
	private Mapper mapper;

	@Override
	public List<FileTo> readAll() {
		return fileRepository.findAll()
				.stream()
				.map(this::mapToTransferObject)
				.collect(Collectors.toList());
	}

	@Override
	public FileTo readById(Long id) {
		FileEntity fileEntity = fileRepository.findOne(id);
		return mapToTransferObject(fileEntity);
	}

	@Override
	public FileTo create(FileTo to) {
		// actual creation of db entities is made once with binary stream in method
		// writeBinaryData
		return to;
	}

	@Override
	public FileTo createEmpty() {
		return new FileTo();
	}

	@Override
	public FileTo update(FileTo to) {
		FileEntity entity = mapToEntityObject(to);
		entity = fileRepository.save(entity);
		return mapToTransferObject(entity);
	}

	@Override
	public FileTo setRelation(FileTo source, Object nestedObject) {
		logger.warn("setRelation is not implemented");
		return null;
	}

	@Override
	public void deleteById(Long id) {
		fileRepository.delete(id);
	}

	private FileEntity mapToEntityObject(FileTo fileTo) {
		return mapper.map(fileTo, FileEntity.class);
	}

	private FileTo mapToTransferObject(FileEntity fileEntity) {
		return mapper.map(fileEntity, FileTo.class);
	}

	@Override
	public BinaryData readBinaryData(Object mediaEnity) {
		FileEntity fileEntity = fileRepository.findOne(((FileTo) mediaEnity).getId());
		Blob fileBlob = fileEntity.getFile();

		byte[] file = null;
		try {
			logger.debug("read blob with size " + fileBlob.length());
			file = fileBlob.getBytes(1, (int) fileBlob.length());
		} catch (SQLException e) {
			logger.error("Error occured ", e);
		}

		return new BinaryData(file, fileEntity.getMime());
	}

	@Override
	public FileTo writeBinaryData(BinaryData mediaData, FileTo fileTo) {
		try {
		    //TODO move create entity to create method
			Blob fileBlob = new SerialBlob(mediaData.getData());
			FileEntity fileEntity = new FileEntity();
			fileEntity.setFile(fileBlob);
			fileEntity.setMime(mediaData.getMimeType());

			return mapToTransferObject(fileRepository.save(fileEntity));
		} catch (SQLException e) {
			logger.error("Error occured ", e);
		}

		return fileTo;
	}

    @Override
    public <S> List<S> readRelatedEntities(FileTo source, Class<S> targetClass) {

        logger.debug("readRelatedEntities is not implemented for " + source);
        return null;
    }

    @Override
    public <S> S readRelatedEntity(FileTo source, Class<S> targetClass) {

        logger.debug("readRelatedEntity is not implemented for " + source);
        
        S result = null;
        return result;
    }
}
