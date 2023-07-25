package xyz.sandersonsa.route;

import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class CacheTokenRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:getToken?period={{timer.period}}")
            //recuperarToke o resultado é setado no corpo, oq estiver no corpo é oq vai ser inserido no cache
            .bean("greeting", "greet")
            // .setBody(simple("Hello ${body}"))
            // .setBody (simple ("Hello World, " + counter++))
            //Inserir no cache
            .to("caffeine-cache://cache?action=PUT&key={{cache.key}}")           
        ;
    }
}