import moto.motorcyclegaragehelper.Entities.Motorcycle;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.io.Serializable;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
                config.exposeIdsFor(Motorcycle.class);
                config.setBasePath("/api"); //Sets Api url

                cors.addMapping("/api/**").allowedOrigins("*"); //Allows cross origins for api communication
    }


}
