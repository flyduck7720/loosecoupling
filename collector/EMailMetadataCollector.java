package loosecoupling.collector;

import loosecoupling.export.ExportMetadata;
import loosecoupling.fetch.FetchMetadata;

import java.util.List;

public class EMailMetadataCollector implements MetadataCollector {

	private FetchMetadata fetchMetadata;
    private ExportMetadata exportMetadata;

    public EMailMetadataCollector() {
    	
    }

	@Override
	public void setMetadataCollector(FetchMetadata fetchMetadata, ExportMetadata exportMetadata) {
		this.fetchMetadata = fetchMetadata;
        this.exportMetadata = exportMetadata;
	}

	@Override
	public void collectMetadata() {
		List<Object> metadata = fetchMetadata.fetchMetadata();
        exportMetadata.export(metadata);

	}

	@Override
	public void sendMessage(String recipientName, String message) {
		// 이메일로 메시지를 전송하는 코드 작성
		System.out.println("이메일로 " + recipientName + "에게 메시지를 보냅니다: " + message);
	}



}
