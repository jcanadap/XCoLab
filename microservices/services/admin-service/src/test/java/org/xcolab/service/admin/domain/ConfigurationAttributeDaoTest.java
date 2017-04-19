package org.xcolab.service.admin.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import org.xcolab.model.tables.pojos.ConfigurationAttribute;
import org.xcolab.service.admin.domain.configurationattribute.ConfigurationAttributeDao;

import static org.junit.Assert.*;
import java.net.URL;
import java.net.URLClassLoader;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@TestPropertySource(
    properties = {
        "cache.active=false",
        "eureka.client.enabled=false"
    }
)
@ComponentScan("org.xcolab.service.admin")
///microservices/services/admin-service/target/test-classes/
// ../../../../../
//Users/carlosbpf/ROOT/Professional/MIT/code/XCoLab/microservices/services/admin-service/target/test-classes/
///Users/carlosbpf/ROOT/Professional/MIT/code/XCoLab/microservices/services/admin-service/target/classes/
// classpath:/../../../scripts/travis/xcolab_Create.sql
//create.sql
@Sql(executionPhase= ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:/create.sql")
                                                                // classpath:/../../../../../scripts/travis/xcolab_Create.sql
public class ConfigurationAttributeDaoTest {

    @Autowired
    ConfigurationAttributeDao configurationAttributeDao;


    @Test
    public void shouldSaveNewConfigurationAttribute(){
        ConfigurationAttribute ca = new ConfigurationAttribute();
        ca.setName("SUPER");
        ca.setNumericValue(0l);
        ca.setAdditionalId(0l);
        ca.setRealValue(0d);
        ca.setStringValue("DUPER");
        ca = configurationAttributeDao.create(ca);

        assertNotNull(configurationAttributeDao.getConfigurationAttribute(ca.getName()).get());

    }

}
