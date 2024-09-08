package com.javarush.tracker.provider;

import org.hibernate.SessionFactory;

public interface SessionProvider {

    SessionFactory getSessionFactory();
}
