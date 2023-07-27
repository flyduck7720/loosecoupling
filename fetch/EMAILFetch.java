package loosecoupling.fetch;

import java.util.ArrayList;
import java.util.List;

public class EMAILFetch implements FetchMetadata {
	
	final String fetchType = "EMAIL";
	private static EMAILFetch instance = null;
	
	private EMAILFetch() {
    }
    
    
    public static EMAILFetch getInstance() {
        
        if (instance == null) {
            instance = new EMAILFetch();
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
		System.out.println("EMAIL Fetching some email data");
        return metadata;
	}
}