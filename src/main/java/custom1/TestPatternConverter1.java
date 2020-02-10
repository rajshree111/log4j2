package custom1;

import java.util.Map;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;
import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.apache.logging.log4j.util.StringBuilders;
import org.apache.logging.log4j.util.TriConsumer;

@Plugin(name = "TestPatternConverter1", category = PatternConverter.CATEGORY)
@ConverterKeys({"graphname"})
public final class TestPatternConverter1 extends LogEventPatternConverter{
	
	
	 private final String key;
     private final String[] keys;
     private final boolean full;
     
	/**
     * Private constructor.
     * @param options options, may be null.
     */
    private TestPatternConverter1(final String[] options) {
    	super(options != null && options.length > 0 ? "MDC{" + options[0] + '}' : "MDC", "mdc");
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@mdcpatternconverter");
        
        if (options != null && options.length > 0) {
            full = false;
            if (options[0].indexOf(',') > 0) {
                keys = options[0].split(",");
                for (int i = 0; i < keys.length; i++) {
                    keys[i] = keys[i].trim();
                }
                key = null;
            } else {
                keys = null;
                key = options[0];
            }
        } else {
            full = true;
            key = null;
            keys = null;
        }
       // super("e", "graphname");
    }

    /**s
     * Obtains an instance of pattern converter.
     *
     * @param options options, may be null.
     * @return instance of pattern converter.
     */
    public static TestPatternConverter1 newInstance(final String[] options) {
    	//
    	
    	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    	
        return new TestPatternConverter1(options);
    }
    
    /**
     * {@inheritDoc}
     */
//    @Override
//    public void format(final LogEvent event, final StringBuilder toAppendTo) {
//        
//    }

	@Override
	public void format(LogEvent event, StringBuilder toAppendTo) {


		toAppendTo.append("check it out!!!");
		
		 //final ReadOnlyStringMap contextData = event.getContextData();
//		  final ReadOnlyStringMap contextData = event.getContextData();
//		
//		
//		
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& void format"+contextData);
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+full+"....."+keys.length);
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@contextdata"+contextData.getValue(key));
//		
//	    if (full) {
//            if (contextData == null || contextData.size() == 0) {
//               toAppendTo.append("{}");
//               return;
//           }
//           appendFully(contextData, toAppendTo);
//       } else {
//           if (keys != null) {
//               if (contextData == null || contextData.size() == 0) {
//                   toAppendTo.append("{}");
//                   return;
//               }
//               
//               
//               
//              // contextData. = "some hard code value...";
//               appendSelectedKeys(keys, contextData, toAppendTo);
//           } else if (contextData != null){
//               // otherwise they just want a single key output
//               final Object value = contextData.getValue(key);
//               if (value != null) {
//                   StringBuilders.appendValue(toAppendTo, value);
//               }
//           }
//       }
		 
		// TODO Auto-generated method stub
		
//        if(TestLogHandler.isTestLogEnabled()) {
//            TestContextHolder contextHolder = TestLogHandler.getLatestContextHolderFromStack(event.getThreadName());
//            if(contextHolder != null) {
//                flagg = contextHolder.getflaggForThread(event.getThreadName());
//            }
//            else{
//                flagg = TestContextHolder.getflaggForThread(event.getThreadName());
//            }
//        }
        //this.setAppend(event);
		
	}
	
	 private static final TriConsumer<String, Object, StringBuilder> WRITE_KEY_VALUES_INTO = new TriConsumer<String, Object, StringBuilder>() {
         @Override
         public void accept(final String key, final Object value, final StringBuilder sb) {
             sb.append(key).append('=');
             StringBuilders.appendValue(sb, value);
             sb.append(", ");
         }
     };
	
	private static void appendFully(final ReadOnlyStringMap contextData, final StringBuilder toAppendTo) {
        toAppendTo.append("{");
        final int start = toAppendTo.length();
        contextData.forEach(WRITE_KEY_VALUES_INTO, toAppendTo);
        final int end = toAppendTo.length();
        if (end > start) {
            toAppendTo.setCharAt(end - 2, '}');
            toAppendTo.deleteCharAt(end - 1);
        } else {
            toAppendTo.append('}');
        }
    }

    private static void appendSelectedKeys(final String[] keys, final ReadOnlyStringMap contextData, final StringBuilder sb) {
        // Print all the keys in the array that have a value.
        final int start = sb.length();
        sb.append('{');
        for (int i = 0; i < keys.length; i++) {
            final String theKey = keys[i];
            final Object value = contextData.getValue(theKey);
           // contextData.
            if (value != null) { // !contextData.containskey(theKey)
                if (sb.length() - start > 1) {
                    sb.append(", ");
                }
                sb.append(theKey).append('=');
                StringBuilders.appendValue(sb, value);
            }
        }
        sb.append('}');
    }
	
	public void setAppend(LogEvent event) {
		
            StringBuilder flagg = new StringBuilder("@@@@@@@@@@@22222");
		
		if(event.getLevel().toString().equalsIgnoreCase("error")) {
			
			System.out.println("################33"+event.getLevel());
			flagg = new StringBuilder("-1");
			
		}
		
		StringBuilder graphname = new StringBuilder(CustomAppenderApplication.graphname);
		
		for(int i=0;i<2;i++) {
			if(i==0) {
			this.format(event,flagg);
			}else {
				this.format(event,graphname);
			}
		}
	}

}
