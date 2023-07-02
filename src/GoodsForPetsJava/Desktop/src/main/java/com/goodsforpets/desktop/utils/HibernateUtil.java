package com.goodsforpets.desktop.utils;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      return new Configuration().configure(
              new File("Desktop\\src\\main\\resources\\com\\goodsforpets\\desktop\\hibernate.cfg.xml"))
          .buildSessionFactory();
    } catch (Throwable e) {
      System.err.println(e);
      throw new ExceptionInInitializerError(e);
    }
  }

  public static SessionFactory getSessionFactory() {
    return SESSION_FACTORY;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}
