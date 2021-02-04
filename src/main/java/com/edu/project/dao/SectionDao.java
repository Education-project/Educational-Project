package com.edu.project.dao;

import com.edu.project.model.Section;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectionDao extends DaoUtilImpl<Section>
{
  public SectionDao(SessionFactory sessionFactory)
  {
    super(sessionFactory);
  }

  public Section findById(long id)
  {
    return findById(id, Section.class);
  }

  public List<Section> findAll()
  {
    return findAll(Section.class);
  }
}
