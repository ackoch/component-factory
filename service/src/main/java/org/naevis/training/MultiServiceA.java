package org.naevis.training;

import org.apache.felix.scr.annotations.*;
import org.osgi.framework.Constants;

@Component(
        //label = "Multi Service A",
        name = "org.naevis.training.MultiServiceA",
        policy = ConfigurationPolicy.REQUIRE,
        configurationFactory = true,
        metatype = true,
        immediate = true

)

@Service(
        value = MultiServiceA.class
)

@Properties(
        {

                @Property(
                        name = "webconsole.configurationFactory.nameHint",
                        value = " {serviceName} - {serviceGroupId}"),

                @Property(
                        name = Constants.SERVICE_RANKING,
                        intValue = 10)
        })


public class MultiServiceA {

        @Property(
                label = "Service Name",
                name = "serviceName",
                value = "MultiServiceA",
                description = "Friendly name to make the service identifiable in the felix console")
        public String serviceName;


        @Property(
                name = "serviceGroupId",
                description = "Use this identifier to define a group of services. Only services with the same serviceGroupId will be able to reference each other. ")
        private String serviceGroupId;

        public String getServiceGroupId() {
                return serviceGroupId;
        }


}
