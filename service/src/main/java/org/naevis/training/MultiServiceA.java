package org.naevis.training;

import org.apache.felix.scr.annotations.*;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Component(
        label = "Naevis Multi Service A",
        name = "org.naevis.training.MultiServiceA",
        policy = ConfigurationPolicy.REQUIRE,
        configurationFactory = true, metatype = true, immediate = true
)

@Service(
        value = MultiServiceA.class
)

@Properties({

        @Property(
                name = ComponentGroupHelper.WEBCONSOLE_NAMEHINT_NAME,
                value = ComponentGroupHelper.WEBCONSOLE_NAMEHINT_VALUE
        ),

        @Property(
                label = ComponentGroupHelper.SERVICEGROUPID_LABEL,
                name = ComponentGroupHelper.SERVICEGROUPID_NAME,
                description = ComponentGroupHelper.SERVICEGROUPID_DESCRIPTION
        ),

        @Property(
                name = Constants.SERVICE_RANKING,
                intValue = 10
        )
})


public class MultiServiceA {

    private static final Logger LOG = LoggerFactory.getLogger(MultiServiceA.class);

    private String serviceGroupId = "";


    public String getServiceGroupId() {
        return serviceGroupId;
    }

    @Activate
    public void activate(Map<String, Object> props){

        serviceGroupId = ComponentGroupHelper.getAttribute(props, ComponentGroupHelper.SERVICEGROUPID_NAME);

        LOG.debug("AAA MultiServiceA activated: serviceGroupId: {}", serviceGroupId);
    }


}
