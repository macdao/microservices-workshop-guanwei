package radar.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TechniquesController {
    @Autowired
    private TechniquesService techniquesService;

    @RequestMapping(path = "/techniques/microservices", method = RequestMethod.GET)
    public Map<String, String> microservices() {
//        return null;
        return techniquesService.getResult();
    }
}
