package com.edu.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public abstract class DaoUtilImpl <T> implements DaoUtil <T>
{
  protected final SessionFactory sessionFactory;

  public DaoUtilImpl(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

  protected Session getCurrentSession()
  {
    Session session;
    try {
      session = sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      session = sessionFactory.openSession();
    }
    return session;
  }

  @Transactional
  public void save(T entity) {
    getCurrentSession().save(entity);
  }

  @Transactional
  public void update(T entity) {
    getCurrentSession().update(entity);
  }

  @Transactional
  public void delete(T entity) {
    getCurrentSession().delete(entity);
  }

  @Transactional
  public void deleteAll() {
    List<T> entityList = findAll();
    for (T entity : entityList) {
      delete(entity);
    }
  }

  @Transactional
  protected T findById(long id, Class<T> clazz) {
    return getCurrentSession().get(clazz, id);
  }

  @Transactional
  public List<T> findAll(Class<T> clazz)
  {
    return (List<T>) getCurrentSession().createQuery("from " + clazz.getName()).list();
  }
}
