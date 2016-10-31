package no.havard.javaflow.phases.reader;

import java.util.Optional;

import no.havard.javaflow.ast.Definition;

public interface Reader {
  Optional<Definition> read(String filename);
}

