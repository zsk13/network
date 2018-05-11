package network.service;

import java.util.List;
import java.util.Map;

public interface RollcallExportService {
    public List<Map<String, String>> selectAllRollCall(Long rId);
}
