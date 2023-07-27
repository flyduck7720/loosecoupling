package loosecoupling.export;

import java.io.File;
import java.util.List;

public class EMAILExport implements ExportMetadata {
	
	final String exportType = "CSV";	
	private static EMAILExport instance = null;
	
	
    private EMAILExport() {
    }
    
    
    public static EMAILExport getInstance() {
        
        if (instance == null) {
            instance = new EMAILExport();
        }
        return instance;
    }
	
	@Override
	public String getExportType() {
		return this.exportType;
	}
	
	@Override
	public File export(List<Object> metadata) {
		System.out.println("EMAIL Exporting data...");
        // Export Metadata
        File outputCSV = null;
        return outputCSV;
	}
}
