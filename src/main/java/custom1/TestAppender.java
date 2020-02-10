package custom1;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.message.Message;
import org.jboss.logging.MDC;

@Plugin(name = "TestAppender", category = "Core", elementType = "appender", printObject = true)
public class TestAppender extends AbstractAppender{
	
	private ConcurrentMap<String, LogEvent> eventMap = new ConcurrentHashMap<>();

	protected TestAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
	    super(name, filter, layout, ignoreExceptions);
		System.out.println("In TestAppender Constructor");
		
	}
	
	@PluginFactory
    public static TestAppender createAppender(@PluginAttribute("name") String name,
            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filters") Filter filter) {


		//filter.filter(event)
		
		System.out.println("In CreateAppender");
        return new TestAppender(name, filter, layout, true);
    }

	@Override
	public void append(LogEvent arg0) {
		
		//arg0.
		
		
		// TODO Auto-generated method stub
		//System.out.println("in logEvent "+arg0.getMessage());
		String msg = arg0.getMessage().getFormattedMessage();
		//System.out.println("str : "+msg);
		//System.out.println("level : "+arg0.getLevel());
//		String flagg = "0";
		//char flagg;
		
		//if(level.equals(Level.ERROR)){
		
		eventMap.put("dummy", arg0);
		
		//System.out.println("##########################"+arg0.getLevel().toString().equalsIgnoreCase("ERROR"));
		
//		if(arg0.getLevel().toString().equalsIgnoreCase("ERROR")){
//			flagg = "0";
//			System.out.println("flagg : "+flagg);
//		}
//		else if(arg0.getLevel().toString().equalsIgnoreCase("INFO")){
//			flagg="-1";
//			System.out.println("flagg : "+flagg);
//		}
		
//		MDC.put("timestamp", "");
//		
//		MDC.put("timestamp", "");
//		MDC.put("formatted_messege", "messege");
//		MDC.put("session_id", CustomAppenderApplication.sessionid);
//		MDC.put("graphname", CustomAppenderApplication.graphname);
//		//MDC.put("graphname", "fbdg");
//		MDC.put("level_string", "");
//		//MDC.put("flagg",flagg );
//		//System.out.println("flagg : "+ flagg);
//		MDC.put("error_reason", "error");
//		arg0.setEndOfBatch(true);
		
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+MDC.get("graphname"));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+MDC.get("timestamp"));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+MDC.get("flagg"));
	}
	
	 public ConcurrentMap<String, LogEvent> getEventMap() {
	        return eventMap;
	    }

	    public void setEventMap(ConcurrentMap<String, LogEvent> eventMap) {
	        this.eventMap = eventMap;
	    }
}