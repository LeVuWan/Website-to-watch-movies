package com.poly.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.poly.utill.JpaUtill;

public abstract class abstractDAO<T> {

	public static final EntityManager entityManager = JpaUtill.getEntityManager();

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	public T findById(Class<T> clazz, Integer id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, Boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}
	
	public List<T> findAll(Class<T> clazz, Boolean existIsActive, int PageNumber, int PageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((PageNumber-1)*PageSize);
		query.setMaxResults(PageSize);
		return query.getResultList();
	}
	
	public T finOne(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for(int i = 0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> list = query.getResultList();
		
		if(list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}
	
	public List<T> findMany(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for(int i = 0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object... params) {
		Query query = entityManager.createNativeQuery(sql);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	
	public List<T> callStored(String namedStored, Map<String, Object> params) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(namedStored);
		params.forEach((key, value) -> query.setParameter(key, value));
		return (List<T>) query.getResultList();
	}
	
	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Create succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot insert entity " + entity.getClass().getSimpleName() + "to DB");
			throw new RuntimeException(e);
		}
	}
	
	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("Update succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot update entity " + entity.getClass().getSimpleName() + "to DB");
			throw new RuntimeException(e);
		}
	}
	
	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Delete succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot update entity " + entity.getClass().getSimpleName() + "to DB");
			throw new RuntimeException(e);
		}
	}
}
