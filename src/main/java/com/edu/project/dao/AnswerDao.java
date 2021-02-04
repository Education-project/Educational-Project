package com.edu.project.dao;

import com.edu.project.model.Answer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerDao extends DaoUtilImpl<Answer>
{
  public AnswerDao(SessionFactory sessionFactory)
  {
    super(sessionFactory);
  }

  public Answer findById(long id)
  {
    return findById(id, Answer.class);
  }

  public List<Answer> findAll()
  {
    return findAll(Answer.class);
  }
}
