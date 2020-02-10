package custom1;

//import org.apache.log4j.MDC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.jboss.logging.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CustomAppenderApplication {

	private static final Logger logger = LogManager.getLogger(CustomAppenderApplication.class.getName());
	public static String sessionid;
	public static String graphname;
	 
	public static void main(String[] args) {
		SpringApplication.run(CustomAppenderApplication.class, args);
		
		//createLog();
	}

	@RequestMapping(value="/data1", method=RequestMethod.POST)
	public String createLog(@RequestBody state state1)
	//public static String createLog()
	{
		
		sessionid = state1.getSessionid();
		graphname = state1.getGraphname();
		//demo d1 = new demo();
		//d1.statdata(state1);
		
		/*MDC.put("","");
		MDC.put("","");
		MDC.put("","");
		MDC.put("","");*/
		
		//logger.info("sessionid:{}:graphname:{}",state1.getSessionid(), state1.getGraphname());
		logger.info( "info");
		logger.info( "info");
		logger.debug( "debug");
		logger.debug( "debug");
		logger.warn( "warn");
		logger.error("error");
		//System.out.println("In WebService");
		
		//logger.info("info : "+state1.getSessionid());
		//logger.debug("debug : "+state1.getGraphname());
		//logger.error("error : "+state1.getGraphname());
		//logger.fatal("fatal : "+state1.getGraphname());
		//logger.trace("trace : "+state1.getSessionid() );
		//logger.warn("warn : "+state1.getGraphname());
		
		//logger.info("MimictronServer execution starts " + " || sessionid: " +state1.getSessionid()+ " || graphname: " +state1.getGraphname());
		
		
		return "Sent";
	}

}
