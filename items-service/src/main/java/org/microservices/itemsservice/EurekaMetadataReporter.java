package org.microservices.itemsservice;

import com.netflix.appinfo.ApplicationInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class EurekaMetadataReporter {

    @Autowired
    private ApplicationInfoManager applicationInfoManager;

    @PostConstruct
    private void addMetaData() {
        Map<String, String> metaData = new HashMap<>();
        metaData.put("crewmodule", "");
        metaData.put("description", "Some description");

        //applicationInfoManager.registerAppMetadata(metaData);
    }
}
