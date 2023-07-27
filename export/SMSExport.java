package loosecoupling.export;

import java.io.File;
import java.util.List;

public class SMSExport implements ExportMetadata {
	
	final String exportType = "SMS";
	
	private static SMSExport instance = null;
	
	// �����ڸ� private�� �����Ͽ� �ܺο��� �ν��Ͻ��� ������ �� ������ �մϴ�.
    private SMSExport() {
    }
    
    // �ܺο��� �ν��Ͻ��� ������ �� �ִ� ���� �޼ҵ带 �߰��մϴ�.
    public static SMSExport getInstance() {
        // �ν��Ͻ��� �����Ǿ� ���� ���� ��쿡�� �ν��Ͻ��� �����մϴ�.
        if (instance == null) {
            instance = new SMSExport();
        }
        return instance;
    }
	
	@Override
	public String getExportType() {
		return this.exportType;
	}

	@Override
	public File export(List<Object> metadata) {
		System.out.println("SMS Exporting data...");
        // Export Metadata
        return null;
	}
}