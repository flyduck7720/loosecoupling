package loosecoupling.fetch;

import java.util.ArrayList;
import java.util.List;

public class SMSFetch implements FetchMetadata {
	
	final String fetchType = "SMS";
	private static SMSFetch instance = null;
	
	
    private SMSFetch() {
    }
    
    
    public static SMSFetch getInstance() {
        
        if (instance == null) {
            instance = new SMSFetch();
        }
        return instance;
    }
	
	@Override
	public String getFetchType() {		
		return this.fetchType;
	}	

	@Override
	public List<Object> fetchMetadata() {
		List<Object> metadata = new ArrayList<>();
		System.out.println("SMS Fetching some json data");
        return metadata;
	}
}