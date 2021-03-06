package no.havard.javaflow.phases.writer.flow;

import java.io.IOException;

import no.havard.javaflow.ast.Class;
import no.havard.javaflow.ast.Field;
import no.havard.javaflow.phases.writer.Writer;
import no.havard.javaflow.phases.writer.flow.converter.Converter;

class ClassWriter implements Writer<Class> {

  private Writer<Field> fieldWriter;

  public ClassWriter(Converter converter) {
     this.fieldWriter = new FieldDefinitionWriter(converter);
  }

  @Override
  public void write(Class aClass, java.io.Writer writer) throws IOException {
    writer.write("export type ");
    writer.write(aClass.getName());
    writer.write(" = {");
    writeFields(aClass, writer);
    writer.write("};");
  }

  private void writeFields(Class aClass, java.io.Writer writer) throws IOException {
    if (aClass.getFields().size() > 0) {
      writer.write("\n");
    }
    for (Field field : aClass.getFields()) {
      writer.write("  ");
      fieldWriter.write(field, writer);
      writer.write(",\n");
    }
  }
}

