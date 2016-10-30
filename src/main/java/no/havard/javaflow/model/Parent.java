package no.havard.javaflow.model;

import java.util.List;

public class Parent {

  private final CanonicalName name;
  private Class reference;

  public Parent(CanonicalName name) {
    this.name = name;
  }

  public String getName() {
    return name.getName();
  }

  public String getCanonicalName() {
    return name.getCanonicalName();
  }

  public Class getReference() {
    return reference;
  }

  public List<Field> getFields() {
    return reference.getFields();
  }

  public void setReference(Class reference) {
    this.reference = reference;
  }
}
