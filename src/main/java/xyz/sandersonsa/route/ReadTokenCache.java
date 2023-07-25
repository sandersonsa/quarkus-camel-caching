package xyz.sandersonsa.route;

import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.caffeine.CaffeineConstants;
import org.apache.camel.model.rest.RestBindingMode;

@ApplicationScoped
public class ReadTokenCache extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:gettoken?period={{timer.period}}")            
            .to("caffeine-cache://cache?key=1&action=GET")            
            .log("Test! ${body}")
        ;

    }
}