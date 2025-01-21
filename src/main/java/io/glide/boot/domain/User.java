package io.glide.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

  @Id private Long id;

  private String firstName;

  private String lastName;

  @ManyToOne()
  @JsonIgnoreProperties(value = "users" )
  private Department department;

  @Embedded
  @ElementCollection()
  private Set<Address> addresses;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(final Department department) {
    this.department = department;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(final Set<Address> addresses) {
    this.addresses = addresses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
