package org.naevis.training;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

@Component(
        label = "Simple Service Component",
        metatype = true,
        immediate = true
)

@Service(
        value = SimpleService.class
)

@Properties(
        {
                @Property(
                        name = "MyProperty",
                        value = "MyValue",
                        propertyPrivate = false),
                @Property(
                        name = Constants.SERVICE_RANKING,
                        intValue = 10)
        })

public class SimpleService {
}
