package app.config;


//import app.repository.*;
//import app.service.*;
import app.repository.AnswerRepoSql;
import app.repository.QuizRepoSQL;
import app.repository.UserRepo;
import app.repository.repoInterface.IUserRepo;
import app.service.*;
import app.service.serviceInterface.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = "app.repository")
@ComponentScan("app")
@ComponentScan("app.model")
public class AppConfig {
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        registrationBean.setFilter(characterEncodingFilter);
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        registrationBean.setOrder(Integer.MIN_VALUE);
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("Jdbc:mysql://52.187.177.166:3306/case4?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("Maiyeuem89");
        return dataSource;
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(additionalProperties());
        entityManagerFactory.setPackagesToScan("app.model");
        return entityManagerFactory;
    }

    @Bean
    @Qualifier("entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        URL url = getClass().getClassLoader().getResource("message.properties");
//        System.out.println(url.getPath().replace(".properties",""));
//        messageSource.setBasenames("/WEB-INF/classes/message");
        messageSource.setBasenames("/WEB-INF/i18n/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public IUserRepo getUserRepo() {
        return new UserRepo();
    }
    @Bean
    public IUserService getUserService() {
        return new UserService();
    }
    @Bean
    public IUserRoleService getUserRoleService() {
        return new UserRoleService();
    }

    @Bean
    public ISubjectService getSubjectService() {
        return new SubjectService();
    }
    @Bean
    public IQuizEntityService quizEntityService() {
        return new QuizEntityService();
    }

    @Bean
    public QuizRepoSQL quizRepoSQL() {
        return new QuizRepoSQL();
    }

    @Bean
    public AnswerRepoSql answerRepoSql() {
        return new AnswerRepoSql();
    }

    @Bean
    public IAnswerService answerService() {
        return new AnswerService();
    }

    @Bean
    public ITestEntityService testEntityService() {
        return new TestEntityService();
    }

    @Bean
    public ICorrectAnswerService correctAnswerService() {
        return new CorrectAnswerService();
    }
}
