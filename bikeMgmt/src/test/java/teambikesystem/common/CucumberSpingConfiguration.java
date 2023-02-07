package teambikesystem.common;


import teambikesystem.BikeMgmtApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BikeMgmtApplication.class })
public class CucumberSpingConfiguration {
    
}
