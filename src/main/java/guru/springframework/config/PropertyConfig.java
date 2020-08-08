package guru.springframework.config;

import guru.springfarmework.beans.FakeDataSource;
import guru.springfarmework.beans.FakeJMSBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyConfig {

    @Value("${guru.username}")
    String user;
    @Value("${guru.password}")
    String password;
    @Value("${guru.dburl}")
    String dburl;

    @Value("${guru.jms.username}")
    String jmsuser;
    @Value("${guru.jms.password}")
    String jmspassword;
    @Value("${guru.jms.url}")
    String jmsurl;


    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDburl(dburl);
        return fakeDataSource;
    }

    @Bean
    public FakeJMSBroker fakeJMSBroker () {
        FakeJMSBroker fakeJMSBroker = new FakeJMSBroker();
        fakeJMSBroker.setUsername(jmsuser);
        fakeJMSBroker.setPassword(jmspassword);
        fakeJMSBroker.seturl(jmsurl);
        return fakeJMSBroker;
    }
}
