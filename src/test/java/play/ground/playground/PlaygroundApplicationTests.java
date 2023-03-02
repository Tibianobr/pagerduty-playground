package play.ground.playground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import play.ground.playground.app.integration.PagerDutyIntegration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlaygroundApplicationTests {
	@Autowired
	private PagerDutyIntegration pagerDutyIntegration;

	@Test
	void contextLoads() {
	}

}
