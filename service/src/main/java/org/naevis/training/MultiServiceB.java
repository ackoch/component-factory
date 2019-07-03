package org.naevis.training;

import org.apache.felix.scr.annotations.*;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Component(
        label = "Naevis Multi Service B",
        name = "org.naevis.training.MultiServiceB",
        policy = ConfigurationPolicy.REQUIRE,
        configurationFactory = true, metatype = true, immediate = true
)

@Service(
        value = MultiServiceB.class
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
                name = "multiServiceA.target",
                label = ComponentGroupHelper.SERVICEGROUPID_TARGET_LABEL + " multiServiceA",
                description = ComponentGroupHelper.SERVICEGROUPID_TARGET_DESCRIPTION
        ),

        @Property(
                name = Constants.SERVICE_RANKING,
                intValue = 10
        )
})


public class MultiServiceB extends ComponentGroupHelper {

    protected static final Logger LOG = LoggerFactory.getLogger(MultiServiceB.class);

    private String serviceGroupId = "";

    @Reference(name = "multiServiceA", target = "(serviceGroupId=XXX)")
        MultiServiceA multiServiceA;

    @Activate
    public void activate(Map<String, Object> props){

        serviceGroupId = ComponentGroupHelper.getAttribute(props, ComponentGroupHelper.SERVICEGROUPID_NAME);

        LOG.debug("BBB MultiServiceB activated: serviceGroupId: {}, multiServiceA.serviceGroupId: {}",
                serviceGroupId, multiServiceA.getServiceGroupId());
    }



}
