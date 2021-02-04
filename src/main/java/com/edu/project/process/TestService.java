package com.edu.project.process;

import com.edu.project.dao.TestDao;
import com.edu.project.model.Test;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TestService
{
  private static final Logger LOGGER = Logger.getLogger(TestService.class.getName());

  @Autowired
  private TestDao testDao;

  public List<Test> findAll()
  {
    try
    {
      return testDao.findAll();
    }
    catch (HibernateException e)
    {
      LOGGER.log(Level.WARNING, "catch error when get all tests ", e);
    }
    return new ArrayList<>();
  }

  public Test findTest(Long id)
  {
    try
    {
      return testDao.findById(id);
    }
    catch (HibernateException e)
    {
      LOGGER.log(Level.WARNING, "catch error when get test "+ id, e);
    }
    return null;
  }
}
