package spi.objectfactories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * @author Holger Thurow (thurow.h@gmail.com)
 * @since 03.07.17
 */
public class DemoBeanFactory implements ObjectFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoBeanFactory.class);

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        LOGGER.debug("{} called.", this.getClass().getName());
        Reference ref = (Reference) obj;
        if (DemoBean.class.getName().equals(ref.getClassName())) {
            String fullName = (String) ref.get("fullName").getContent();
            int size = Integer.valueOf((String) ref.get("size").getContent());
            return new DemoBean(fullName, size);
        }
        else {
            return null;
        }
    }
}
