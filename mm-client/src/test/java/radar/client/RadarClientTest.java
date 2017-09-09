package radar.client;

import com.github.dreamhead.moco.HttpServer;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

import static com.github.dreamhead.moco.Moco.file;
import static com.github.dreamhead.moco.MocoJsonRunner.jsonHttpServer;
import static com.github.dreamhead.moco.Runner.running;
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThat;

public class RadarClientTest {

    @Test
    public void should_get_techniques_microservices() throws Exception {
        final HttpServer server = jsonHttpServer(12306, file("contracts/microservices.json"));
        running(server, () -> {
            final Content content = Request.Get("http://localhost:12306/techniques/microservices")
                    .execute().returnContent();
            assertThat(content.asString())
                    .field("quadrant").isEqualTo("Techniques")
                    .field("ring").isEqualTo("TRIAL");
        });
    }
}
