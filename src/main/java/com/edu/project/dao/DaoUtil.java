package com.edu.project.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoUtil <T>
{
  public void save(T entity);

  public void update(T entity);

  public T findById(long id);

  public void delete(T entity);

  public List<T> findAll();

  public void deleteAll();
}
