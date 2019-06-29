package org.naevis.training;

import org.apache.felix.scr.annotations.*;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(
        value = MultiServiceB.class
)

@Component(
        //label = "Multi Service B",
        //name = "org.naevis.training.multiservice.b.Config",
        policy = ConfigurationPolicy.REQUIRE,
        configurationFactory = true,
        metatype = true,
        immediate = true

)

@Properties(
        {
                @Property(
                        label = "MyProperty",
                        name = "MyProperty",
                        value = "MyValue"),

                @Property(
                        name = Constants.SERVICE_RANKING,
                        intValue = 10)
        })


public class MultiServiceB {

        @Property(name = "serviceGroupId")
        private String serviceGroupId;

        @Reference(target="(serviceGroupId=AAA)")
        MultiServiceA multiServiceA;

        private static final Logger LOG = LoggerFactory.getLogger(MultiServiceB.class);

        @Activate
        public void activate(){

                LOG.debug("MultiServiceB activated: {}", this.toString());
                LOG.info("MultiServiceB activated. My serviceGroupID: {}; multiServiceA: {}; serviceGroupId: {}",
                        serviceGroupId,
                        multiServiceA.toString(),
                        multiServiceA.getServiceGroupId());
        }
}
