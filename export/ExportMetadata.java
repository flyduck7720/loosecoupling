package loosecoupling.export;

import java.io.File;
import java.util.List;

public interface ExportMetadata {
	String getExportType();
	File export(List<Object> metadata);
}
