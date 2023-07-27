package loosecoupling.collector;

import loosecoupling.export.ExportMetadata;
import loosecoupling.fetch.FetchMetadata;

public interface MetadataCollector {
	public void setMetadataCollector(FetchMetadata fetchMetadata, ExportMetadata exportMetadata);
	public void collectMetadata();
	public void sendMessage(String recipientName, String message);
}
