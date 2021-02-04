package com.edu.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer_set")
public class AnswerSet
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @JsonManagedReference
  @OneToMany(mappedBy = "answerSet")
  private List<Answer> answerList;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public List<Answer> getAnswerList()
  {
    return answerList;
  }

  public void setAnswerList(List<Answer> answerList)
  {
    this.answerList = answerList;
  }
}
