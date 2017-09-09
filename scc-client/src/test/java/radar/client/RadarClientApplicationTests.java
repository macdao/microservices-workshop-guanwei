package radar.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureStubRunner(ids = {"radar:scc-server:+:stubs:8080"}, workOffline = true)
public class RadarClientApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void shouldGetTechniquesMicroservices() {
        @SuppressWarnings("unchecked") final Map<String, String> response = restTemplate.getForObject("http://localhost:8080/techniques/microservices", Map.class);
        assertThat(response).contains(entry("quadrant", "Techniques"), entry("ring", "TRIAL"));
    }

}
