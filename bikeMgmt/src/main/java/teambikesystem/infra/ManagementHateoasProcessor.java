package teambikesystem.infra;
import teambikesystem.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class ManagementHateoasProcessor implements RepresentationModelProcessor<EntityModel<Management>>  {

    @Override
    public EntityModel<Management> process(EntityModel<Management> model) {

        
        return model;
    }
    
}
