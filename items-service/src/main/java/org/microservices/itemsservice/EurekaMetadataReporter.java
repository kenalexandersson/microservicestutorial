package org.microservices.itemsservice;

import com.netflix.appinfo.ApplicationInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class EurekaMetadataReporter {

    @Autowired
    private ApplicationInfoManager applicationInfoManager;

    @PostConstruct
    private void addMetaData() {
        applicationInfoManager.registerAppMetadata(Map.of("crewmodule", "", "description", "Some description"));
    }
}
