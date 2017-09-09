package radar.server;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TechniquesService {
    public Map<String, String> getResult() {
        final Map<String, String> result = new HashMap<>();
        result.put("quadrant", "Techniques");
        result.put("ring", "TRIAL");
        return result;
    }
}