package org.microservices.uigateway;

public class CrewModule {

    private String type;
    private String path;

    static CrewModule of(String type, String path) {
        return new CrewModule(type, path);
    }

    private CrewModule(String type, String path) {
        this.type = type;
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return String.format("CrewModule{type='%s', path='%s'}", type, path);
    }
}
