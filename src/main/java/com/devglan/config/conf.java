package com.devglan.config;

import com.devglan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class conf {

  @Autowired
  MongoMappingContext mongoMappingContext;
  @Autowired
  private MongoTemplate mongoTemplate;

  @EventListener(ApplicationReadyEvent.class)
  public void initIndicesAfterStartup() {

    IndexOperations indexOps = mongoTemplate.indexOps(User.class);

    IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);

    resolver.resolveIndexFor(User.class).forEach(indexOps::ensureIndex);
  }

}
