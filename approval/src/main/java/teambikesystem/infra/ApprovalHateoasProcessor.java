package teambikesystem.infra;
import teambikesystem.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class ApprovalHateoasProcessor implements RepresentationModelProcessor<EntityModel<Approval>>  {

    @Override
    public EntityModel<Approval> process(EntityModel<Approval> model) {

        
        return model;
    }
    
}
