package org.demo.business;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p/>
 * Central service locator that encapsulates all service lookup and creation
 * processes for EJBs, JMS, Transactions, Datasources, MailSession, etc.
 * </p>
 */
public class ServiceLocator {

    private static Logger logger=Logger.getLogger(ServiceLocator.class);

    /**
     * Field cache
     */
    private Map cache = null;

    /**
     * Field datasource
     */
    private HashMap datasourceCache = null;

    /**
     * Field appProps
     */
    //private static Properties appProps = null;

    /**
     * Field instance
     */
    private static ServiceLocator instance;

    /**
     * Field ic
     */
    private static InitialContext ic;

    private static ApplicationContext context;

    private String contextXMLName = "/WEB-INF/applicationContext-resources.xml";

    /**
     * Constructors
     */
    private ServiceLocator() throws Exception {
        try {
            cache = Collections.synchronizedMap(new HashMap());
            ic = new InitialContext();
        }
        catch (Exception e) {

        }
    }

    /**
     * Constructor for ServiceLocator
     *
     * @param iCtx InitialContext
     */
    private ServiceLocator(InitialContext iCtx) {
        ic = iCtx;
    }

    /**
     * <p/>
     * Get instance of ServiceLocator.
     * </p>
     *
     * @return ServiceLocator
     */
    public static ServiceLocator getInstance() throws Exception {
        if (instance == null)
            instance = new ServiceLocator();
        return instance;
    }


    /**
     * <p/>
     * Get instance of ServiceLocator.
     * </p>
     *
     * @param iCtx
     * @return ServiceLocator
     */
    public static ServiceLocator getInstance(InitialContext iCtx)
            throws Exception {
        if (instance == null)
            instance = new ServiceLocator();
        if (ic == null)
            ic = iCtx;
        return instance;
    }

    /**
     * @return a new database connection from pooled datasource
     * @throws Exception
     */
    public DataSource getDataSource(String dataSourceJndiName) throws Exception {
        DataSource ds = null;
        try {
            if (datasourceCache == null) {
                datasourceCache = new HashMap();
                ds = getDataSourceAndLoadCache(dataSourceJndiName);
            } else {
                ds = (DataSource) datasourceCache.get(dataSourceJndiName);
                if (ds == null) {
                    ds = getDataSourceAndLoadCache(dataSourceJndiName);
                }
            }


        } catch (NamingException e) {
            throw new Exception("Unable to create datasource", e);
        }
        if (ds == null) {
            throw new Exception("Could not find datasource with jndi name: " + dataSourceJndiName);
        }
        return ds;
    }

    private DataSource getDataSourceAndLoadCache(String dataSourceJndiName) throws NamingException {
        DataSource datasource = (javax.sql.DataSource) ic.lookup(dataSourceJndiName);
        datasourceCache.put(dataSourceJndiName, datasource);
        return datasource;
    }



    /**
     * @param serviceName name of the service
     * @return service reference which needs to be casted properly by the
     *         client of the service
     * @throws Exception
     */
    public Object getService(String serviceName) throws Exception {

        try {
            if (context == null)
                context = new ClassPathXmlApplicationContext(contextXMLName);
            //}
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Could not load application context");
        }
        Object obj = null;
        try {
            if(null!=context) {
                logger.info("context received from context xml........");
            }
            obj = context.getBean(serviceName);
        }
        catch (BeansException e) {
            throw new Exception(e);
        }
        return obj;
    }



}