package org.microservices.gateway;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CrewModule {

    private String type;
    private String name;
    private String path;
    private String owningTeam;

    static CrewModule of(String type, String name, String path, String owningTeam) {
        return new CrewModule(type, name, path, owningTeam);
    }

    private CrewModule(String type, String name, String path, String owningTeam) {
        this.type = type;
        this.name = name;
        this.path = path;
        this.owningTeam = owningTeam;
    }
}
