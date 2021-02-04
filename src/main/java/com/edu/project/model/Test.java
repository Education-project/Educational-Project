package com.edu.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test")
public class Test
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "year")
  private int year;

  @Column(name = "shift")
  private short shift;

  @JsonManagedReference
  @OneToMany(mappedBy = "test")
  private List<Section>sections;

  public short getShift()
  {
    return shift;
  }

  public void setShift(short shift)
  {
    this.shift = shift;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public List<Section> getSections()
  {
    return sections;
  }

  public void setSections(List<Section> sections)
  {
    this.sections = sections;
  }
}
