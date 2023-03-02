package play.ground.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import play.ground.playground.app.integration.PagerDutyIntegration;
import play.ground.playground.app.model.UserEntity;
import play.ground.playground.app.model.UsersResponse;
import play.ground.playground.app.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PlaygroundApplication implements CommandLineRunner {

	final PagerDutyIntegration pagerDutyIntegration;

	public PlaygroundApplication(PagerDutyIntegration pagerDutyIntegration) {
		this.pagerDutyIntegration = pagerDutyIntegration;
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			String usersResponseString = pagerDutyIntegration.makeRequest("/users", 0);
			System.out.println(usersResponseString);
			UsersResponse usersResponse = Utils.parseJsonToObject(usersResponseString, UsersResponse.class);
			HashMap<String, UserEntity> userMaps = new HashMap<>();
			for (UserEntity user : usersResponse.getUsers()) {
				userMaps.put(user.getId(), user);
			}
			Integer offset = 25;
			while(usersResponse.getMore()){
				usersResponseString = pagerDutyIntegration.makeRequest("/users", offset);
				usersResponse = Utils.parseJsonToObject(usersResponseString, UsersResponse.class);
				for (UserEntity user : usersResponse.getUsers()) {
					userMaps.put(user.getId(), user);
				}
				offset = offset + 25;
			}
			System.out.println(userMaps);


			String userToFind = Utils.readKeyboardInputFromUser();
			UserEntity userFound = userMaps.get(userToFind);

			if (userFound != null)
			{
				System.out.println(userFound.getContact_methods());

			}


		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
