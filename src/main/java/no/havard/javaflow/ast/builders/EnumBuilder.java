package no.havard.javaflow.ast.builders;

import static no.havard.javaflow.model.CanonicalName.object;

import java.util.ArrayList;
import java.util.List;

import no.havard.javaflow.ast.Enum;

public class EnumBuilder implements Builder<Enum> {

  private String packageName;
  private String name;
  private List<String> values = new ArrayList<>();

  private EnumBuilder() {
  }

  public static EnumBuilder enumBuilder() {
    return new EnumBuilder();
  }

  public EnumBuilder withPackageName(String packageName) {
    this.packageName = packageName;
    return this;
  }

  public EnumBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public EnumBuilder withEnumValue(String name) {
    this.values.add(name);
    return this;
  }

  public Enum build() {
    return new Enum(object(packageName, name), values);
  }

}