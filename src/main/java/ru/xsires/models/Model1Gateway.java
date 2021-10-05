package ru.xsires.models;

import org.springframework.lang.Nullable;

import java.util.Optional;

public class Model1Gateway {
    private final String id;
    private final Model1GateEnum id2;

    private Model1Gateway(Model1GateEnum id2, String id) {
        this.id = id;
        this.id2 = id2;
    }

    public String getId() {
        return id;
    }

    public String getId2AsString() {
        return id2.name();
    }

    public Model1Gateway.Model1GateEnum getId2OrThrow() {
        return id2;
    }

    @Nullable
    public Model1Gateway.Model1GateEnum getId2OrNull() {
        return id2;
    }

    public Optional<Model1Gateway.Model1GateEnum> getId2() {
        return Optional.of(id2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public enum Model1GateEnum {
        Value1, Value2, Value3
    }

    public static class Builder {

        private String id;
        private Model1GateEnum id2;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withId2(Model1GateEnum id2) {
            this.id2 = id2;
            return this;
        }

        public Model1Gateway build() {
            return new Model1Gateway(id2, id);
        }

    }
}
