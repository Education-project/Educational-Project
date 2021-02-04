package com.edu.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "seq_number")
  private int seqNumber;

  @Column(name = "question_text")
  private String text;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "section_id")
  private Section section;

  @JsonManagedReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "answer_set_id")
  private AnswerSet answerSet;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "correct_answer_id", referencedColumnName = "id")
  private Answer correctAnswer;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public int getSeqNumber()
  {
    return seqNumber;
  }

  public void setSeqNumber(int seqNumber)
  {
    this.seqNumber = seqNumber;
  }

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public Section getSection()
  {
    return section;
  }

  public void setSection(Section section)
  {
    this.section = section;
  }

  public AnswerSet getAnswerSet()
  {
    return answerSet;
  }

  public void setAnswerSet(AnswerSet answerSet)
  {
    this.answerSet = answerSet;
  }

  public Answer getCorrectAnswer()
  {
    return correctAnswer;
  }

  public void setCorrectAnswer(Answer correctAnswer)
  {
    this.correctAnswer = correctAnswer;
  }
}
