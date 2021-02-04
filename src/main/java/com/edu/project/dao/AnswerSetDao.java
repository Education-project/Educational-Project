package com.edu.project.dao;

import com.edu.project.model.AnswerSet;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerSetDao extends DaoUtilImpl<AnswerSet>
{
  public AnswerSetDao(SessionFactory sessionFactory)
  {
    super(sessionFactory);
  }

  public AnswerSet findById(long id)
  {
    return findById(id, AnswerSet.class);
  }

  public List<AnswerSet> findAll()
  {
    return findAll(AnswerSet.class);
  }
}
