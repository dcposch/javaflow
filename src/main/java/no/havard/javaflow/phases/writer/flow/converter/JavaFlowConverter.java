package no.havard.javaflow.phases.writer.flow.converter;

import static no.havard.javaflow.util.TypeMap.emptyTypeMap;

import no.havard.javaflow.definitions.Objects;
import no.havard.javaflow.definitions.Primitives;
import no.havard.javaflow.model.CanonicalName;
import no.havard.javaflow.util.TypeMap;

public final class JavaFlowConverter implements Converter {

  private final TypeMap customTypeMap;

  public JavaFlowConverter() {
    this.customTypeMap = emptyTypeMap();
  }

  public JavaFlowConverter(TypeMap typeMap) {
    this.customTypeMap = typeMap;
  }

  public String convert(CanonicalName canonicalName) {
    String name = canonicalName.getName();
    String fullName = canonicalName.getCanonicalName();

    return customTypeMap.getOrDefault(fullName, getOrDefault(fullName, name));
  }

  private static String getOrDefault(String name, String defaultName) {
    if (Objects.isObject(name)) {
      return Objects.get(name);
    }

    if (Primitives.isPrimitive(name)) {
      return Primitives.get(name);
    }

    return defaultName;
  }

}
