package com.shavika.foodies.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("baseDao")
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {

	private static final Logger LOG = Logger.getLogger(BaseDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public int saveAll(List<T> paramList) throws ShavikaAppException {
		int batchSize = 50;
		int count = 0;
		for (count = 0; count < paramList.size(); count++) {
			Object object = paramList.get(count);
			getEntityManager().persist(object);
			if (count % batchSize == 0) {
				getEntityManager().flush();
				getEntityManager().clear();
			}
		}
		getEntityManager().flush();
		getEntityManager().clear();
		return count;
	}
	
	@Override
	public T save(T domainObj) throws ShavikaAppException {
		try {
			getEntityManager().persist(domainObj);
			return domainObj;
		} catch (DataAccessException ex) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", ex);
		}
	}

	@Override
	public int updateAll(List<T> paramList) throws ShavikaAppException {
		int batchSize = 50;
		int count = 0;
		for (count = 0; count < paramList.size(); count++) {
			Object object = paramList.get(count);
			getEntityManager().merge(object);
			if (count % batchSize == 0) {
				getEntityManager().flush();
				getEntityManager().clear();
			}
		}
		getEntityManager().flush();
		getEntityManager().clear();
		return count;
	}

	
	@Override
	public void update(T domainObj) throws ShavikaAppException {
		try {
			getEntityManager().merge(domainObj);
		} catch (DataAccessException ex) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", ex);
		}
	}

	@Override
	public void updateById(Class<T> domainObj, long id) throws ShavikaAppException {
		try {
			getSession().update(find(domainObj, id));
		} catch (DataAccessException ex) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", ex);
		}
	}

	@Override
	public void delete(T domainObj) throws ShavikaAppException {
		try {
			getEntityManager().remove(domainObj);
		} catch (DataAccessException ex) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", ex);
		}
	}

	@Override
	public void deleteById(Class<T> domainObj, long id) throws ShavikaAppException {
		try {
			getSession().delete(find(domainObj, id));
		} catch (DataAccessException ex) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", ex);
		}
	}

	@Override
	public void deleteAll(Class<T> domainObj) throws ShavikaAppException {
		try {
			getSession().createQuery("delete from " + domainObj.getName()).executeUpdate();
		} catch (DataAccessException e) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", e);
		}
	}

	@Override
	public void saveOrUpdate(List<T> objList) throws ShavikaAppException {
		try {
			getSession().saveOrUpdate(objList);
		} catch (DataAccessException ex) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", ex);
		}
	}

	@Override
	public Object find(Class<T> domainObj, long id) throws ShavikaAppException {
		try {
			Criteria criteria = getSession().createCriteria(domainObj);
			criteria.add(Restrictions.eq("id", id));
			return criteria.uniqueResult();
		} catch (DataAccessException e) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> domainClass) throws ShavikaAppException {
		try {
			Query query = getSession().createQuery("from " + domainClass.getName());
			return query.list();
		} catch (DataAccessException e) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", e);
		}
	}

	@Override
	public boolean isRecordExist(Class<T> domainObj, long id) throws ShavikaAppException {
		try {
			Object object = find(domainObj, id);
			return (object != null) ? true : false;
		} catch (DataAccessException e) {
			throw new ShavikaAppException("GEN.DB.INVALID.OPERATION.ADD", e);
		}
	}


}
