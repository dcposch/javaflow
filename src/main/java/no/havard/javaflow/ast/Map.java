package no.havard.javaflow.ast;

import no.havard.javaflow.model.CanonicalName;

public class Map extends Type {
  private final CanonicalName key;
  private final CanonicalName value;

  public Map(CanonicalName name, CanonicalName key, CanonicalName value) {
    super(name);
    this.key = key;
    this.value = value;
  }

  public CanonicalName getKeyType() {
    return key;
  }

  public CanonicalName getValueType() {
    return value;
  }
}

