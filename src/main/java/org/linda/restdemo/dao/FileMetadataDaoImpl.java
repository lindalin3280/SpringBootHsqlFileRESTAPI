package org.linda.restdemo.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.linda.restdemo.entity.FileMetadata;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FileMetadataDaoImpl implements FileMetadataDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public FileMetadata findByFileId(Long fileId) {
		return entityManager.find(FileMetadata.class, fileId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileMetadata> findByFileName(String fileName) {
		String hql = "FROM FileMetadata as d WHERE d.fileName like ?1";
		return entityManager.createQuery(hql).setParameter(1, "%" + fileName + "%").getResultList();
	}

	@Override
	public void save(FileMetadata metaData) {
		entityManager.persist(metaData);
	}
}
