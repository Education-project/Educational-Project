package com.edu.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "text")
  private String text;

  @JsonBackReference
  @ManyToOne(fetch= FetchType.EAGER)
  @JoinColumn(name="answer_set_id")
  private AnswerSet answerSet;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public AnswerSet getAnswerSet() {
    return answerSet;
  }

  public void setAnswerSet(AnswerSet answerSet) {
    this.answerSet = answerSet;
  }
}
