package com.edu.project.dao;

import com.edu.project.model.Question;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao extends DaoUtilImpl<Question>
{
  public QuestionDao(SessionFactory sessionFactory)
  {
    super(sessionFactory);
  }

  public Question findById(long id)
  {
    return findById(id, Question.class);
  }

  public List<Question> findAll()
  {
    return findAll(Question.class);
  }
}
