package teambikesystem.common;


import teambikesystem.ApprovalApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ApprovalApplication.class })
public class CucumberSpingConfiguration {
    
}
