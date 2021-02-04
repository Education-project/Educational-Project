package com.edu.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "section")
public class Section
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @JsonBackReference
  @ManyToOne(targetEntity = Test.class)
  private Test test;

  @Column(name = "extra_text_path")
  private String textPath;

  @JsonManagedReference
  @OneToMany(mappedBy = "section")
  private List<Question> questions;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getTextPath()
  {
    return textPath;
  }

  public void setTextPath(String textPath)
  {
    this.textPath = textPath;
  }

  public Test getTest()
  {
    return test;
  }

  public void setTest(Test test)
  {
    this.test = test;
  }

  public List<Question> getQuestions()
  {
    return questions;
  }

  public void setQuestions(List<Question> questions)
  {
    this.questions = questions;
  }
}
