package org.naevis.training;

import org.apache.felix.scr.annotations.Activate;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ComponentGroupHelper {

    public static final String SERVICEGROUPID_DESCRIPTION = "Target Identifier for groups of services: Only services with the same ID should reference this service.";
    public static final String SERVICEGROUPID_LABEL = "Service Group ID";
    public static final String SERVICEGROUPID_NAME = "serviceGroupId";

    public static final String SERVICEGROUPID_TARGET_DESCRIPTION = "Target filter referencing a valid groupId; Example: '(serviceGroupId=MyServiceGroup)' ";
    public static final String SERVICEGROUPID_TARGET_LABEL = "Service Target for";


    public static final String WEBCONSOLE_NAMEHINT_NAME = "webconsole.configurationFactory.nameHint";
    public static final String WEBCONSOLE_NAMEHINT_VALUE = "{service.factoryPid} - {serviceGroupId}";

    protected static final Logger LOG = LoggerFactory.getLogger(ComponentGroupHelper.class);

    static String getAttribute(Map<String, Object> props, final String attributeName){
        return  PropertiesUtil.toString(props.get(attributeName), "n/a");
    }


}
