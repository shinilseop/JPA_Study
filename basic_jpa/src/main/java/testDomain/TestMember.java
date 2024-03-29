package testDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTMEMBER")
public class TestMember {

  @Id
  @GeneratedValue
  @Column(name = "TESTMEMBER_ID")
  private Long id;
  @Column(name = "TESTMEMBER_NAME")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
