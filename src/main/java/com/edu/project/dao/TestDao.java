package com.edu.project.dao;

import com.edu.project.model.Test;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDao extends DaoUtilImpl<Test>
{
  public TestDao(SessionFactory sessionFactory)
  {
    super(sessionFactory);
  }

  public Test findById(long id)
  {
    return findById(id, Test.class);
  }

  public List<Test> findAll()
  {
    return findAll(Test.class);
  }
}
