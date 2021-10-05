package ru.xsires.models;

import java.util.Optional;

public class Model1Backend {
    private final String id;
    private final String name = null;
    private final Model1BackEnum id2;

    private Model1Backend(String id, Model1BackEnum id2) {
        this.id = id;
        this.id2 = id2;
    }

    public static Builder build() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getId2AsString() {
        return id2.name();
    }

    public Model1BackEnum getId2OrThrow() {
        return id2;
    }

    public Model1BackEnum getId2OrNull() {
        return id2;
    }

    public Optional<Model1BackEnum> getId2() {
        return Optional.of(id2);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public String getNameOrThrown() {
        return name;
    }

    public String getNameOrNull() {
        return name;
    }

    public enum Model1BackEnum {
        Value1, Value2, Value_3
    }

    public static class Builder {

        private String id;
        private Model1BackEnum id2;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withId2(Model1BackEnum id2) {
            this.id2 = id2;
            return this;
        }

        public Model1Backend build() {
            return new Model1Backend(id, id2);
        }

    }
}
