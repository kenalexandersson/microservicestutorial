package org.microservices.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CrewModuleLoader {

    private static Logger LOGGER = LoggerFactory.getLogger(CrewModule.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    private List<CrewModule> crewModules;

    @PostConstruct
    public void load() {

        this.crewModules = discoveryClient.getServices()
                .stream()
                .map(this::toCrewModule)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        LOGGER.info("{}", this.crewModules);

    }

    public List<CrewModule> getCrewModules() {
        return crewModules;
    }

    private Optional<CrewModule> toCrewModule(String serviceId) {
        Map<String, String> metadata = discoveryClient.getInstances(serviceId).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No crewmodule defined"))
                .getMetadata();

        CrewModule crewModule = null;
        if (metadata.containsKey("crewmodule")) {
            crewModule = CrewModule.of("crewmodule", "/path/to/be/used/in/menu");
        }

        return Optional.ofNullable(crewModule);
    }
}
