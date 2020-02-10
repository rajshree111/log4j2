/*package custom1;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.MDC;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseAppender;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcDatabaseManager;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.util.Booleans;
import org.jboss.logging.MDC;

@Plugin(name = "JdbcAppender", category = "Core", elementType = "appender", printObject = true)
public final class JdbcAppender extends AbstractDatabaseAppender implements Appender {
	
	@Override
	public boolean isFiltered(LogEvent event) {
		// TODO Auto-generated method stub
		
		System.out.println("Yooo"+event.getMessage());
    	System.out.println("flaggggggg : "+event.getLevel().toString());
    	String flagg = null;
    	String error_reason = null;
		
		//if(level.equals(Level.ERROR)){
		if(event.getLevel().toString().equalsIgnoreCase("ERROR")){
			flagg = "-1";
			System.out.println("flagg : "+flagg);
			System.out.println("error :");
		}
		else{
			flagg="0";
			System.out.println("flagg : "+flagg);
			System.out.println("no error : ");
		}
		
    	
    	//MDC.put("timestamp", "");
		//MDC.put("formatted_messege", event.getMessage());
		//MDC.remove("session_id");
		//MDC.remove("graphname");
		//MDC.remove("flagg");
		//MDC.remove("error_reason");
		//MDC.clear();
		MDC.put("session_id", CustomAppenderApplication.sessionid);
		MDC.put("graphname", CustomAppenderApplication.graphname);
		//MDC.put("level_string", event.getLevel());
		MDC.put("flagg", flagg);
		MDC.put("error_reason", error_reason);
		System.out.println(new Timestamp(System.currentTimeMillis()));
		return super.isFiltered(event);
	}

	@Override
	protected Serializable toSerializable(LogEvent event) {
		// TODO Auto-generated method stub
    	
    	System.out.println(new Timestamp(System.currentTimeMillis()));
		return super.toSerializable(event);
	}

	private final String description;

    private JdbcAppender(final String name, final Filter filter, final boolean ignoreExceptions,
                         final JdbcDatabaseManager manager) {
        super(name, filter, ignoreExceptions, manager);
        this.description = this.getName() + "{ manager=" + this.getManager() + " }";
        System.out.println("Hello Hie");
    }

    @Override
    public String toString() {
        return this.description;
    }

    /**
     * Factory method for creating a JDBC appender within the plugin manager.
     *
     * @param name The name of the appender.
     * @param ignore If {@code "true"} (default) exceptions encountered when appending events are logged; otherwise
     *               they are propagated to the caller.
     * @param filter The filter, if any, to use.
     * @param connectionSource The connections source from which database connections should be retrieved.
     * @param bufferSize If an integer greater than 0, this causes the appender to buffer log events and flush whenever
     *                   the buffer reaches this size.
     * @param tableName The name of the database table to insert log events into.
     * @param columnConfigs Information about the columns that log event data should be inserted into and how to insert
     *                      that data.
     * @return a new JDBC appender.
     */
   /* @PluginFactory
    public static JdbcAppender createAppender(
            @PluginAttribute("name") final String name,
            @PluginAttribute("ignoreExceptions") final String ignore,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("ConnectionSource") final ConnectionSource connectionSource,
            @PluginAttribute("bufferSize") final String bufferSize,
            @PluginAttribute("tableName") final String tableName,
            @PluginElement("ColumnConfigs") final ColumnConfig[] columnConfigs) {

        final int bufferSizeInt = AbstractAppender.parseInt(bufferSize, 0);
        final boolean ignoreExceptions = Booleans.parseBoolean(ignore, true);

        final StringBuilder managerName = new StringBuilder("jdbcManager{ description=").append(name)
                .append(", bufferSize=").append(bufferSizeInt).append(", connectionSource=")
                .append(connectionSource.toString()).append(", tableName=").append(tableName).append(", columns=[ ");

        int i = 0;
        for (final ColumnConfig column : columnConfigs) {
            if (i++ > 0) {
                managerName.append(", ");
            }
            managerName.append(column.toString());
        }

        managerName.append(" ] }");

        final JdbcDatabaseManager manager = JdbcDatabaseManager.getJDBCDatabaseManager(
                managerName.toString(), bufferSizeInt, connectionSource, tableName, columnConfigs
        );
        if (manager == null) {
            return null;
        }

        return new JdbcAppender(name, filter, ignoreExceptions, manager);
    }   
}*/