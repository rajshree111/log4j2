package custom1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import ch.qos.logback.classic.Level;

public class demo {
	
	private static final Logger logger = LogManager.getLogger(demo.class.getName());
	
	public void statdata(state state1){
		
		//logger.info("Number of nodes: 4 || sessionid: " +state1.getSessionid()+ " || graphname: " +state1.getGraphname());
		System.out.println("lsdkjhgndsgkmwrpjsdbflasdkfjwq;eofjkew;lqj;wtejowopetu : "+state1.getSessionid());
	}
}