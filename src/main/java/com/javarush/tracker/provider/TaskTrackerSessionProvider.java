package com.javarush.tracker.provider;

import com.javarush.tracker.model.entity.Tag;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class TaskTrackerSessionProvider implements SessionProvider {

    @Override
    public SessionFactory getSessionFactory() {
        Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        hibernateProperties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/tracker");
        hibernateProperties.setProperty("hibernate.connection.username", "anton");
        hibernateProperties.setProperty("hibernate.connection.password", "anton");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        return new Configuration()
                .addProperties(hibernateProperties)
                .addAnnotatedClass(Tag.class)
                .buildSessionFactory();
    }
}
