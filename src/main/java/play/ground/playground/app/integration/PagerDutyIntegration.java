package play.ground.playground.app.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import play.ground.playground.app.util.Utils;

import java.io.IOException;

@Service
public class PagerDutyIntegration {

    @Value("${pagerduty.url}")
    private String pagerdutyUrl;

    @Value("${pagerduty.token}")
    private String token;



    public String makeRequest(String resource, Integer offset) throws IOException {
        String fullResourceWithParams = resource + "?offset=" + offset;
        fullResourceWithParams = fullResourceWithParams + "&include[]=" + "contact_methods";
        return Utils.httpGetRequest(pagerdutyUrl + fullResourceWithParams, token);
    }

    public String makeRequest(String resource) throws IOException {
        return Utils.httpGetRequest(pagerdutyUrl + resource, token);
    }
}
