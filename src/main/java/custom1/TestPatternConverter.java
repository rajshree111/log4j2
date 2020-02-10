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

@Plugin(name = "TestPatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys({"flagg",})
public final class TestPatternConverter extends LogEventPatternConverter{
	
	
//	 private final String key;
//     private final String[] keys;
//     private final boolean full;
     
	/**
     * Private constructor.
     * @param options options, may be null.
     */
    private TestPatternConverter(final String[] options) {
    	
		super("flagg","flagg");
	
    }

    /**s
     * Obtains an instance of pattern converter.
     *
     * @param options options, may be null.
     * @return instance of pattern converter.
     */
    public static TestPatternConverter newInstance(final String[] options) {
    	
        return new TestPatternConverter(options);
    }
   

	@Override
	public void format(LogEvent event, StringBuilder toAppendTo) {


		toAppendTo.append("test!!!!!");
		
		
	}

}
