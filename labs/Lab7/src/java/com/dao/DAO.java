/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Wenqing
 */
public abstract class DAO {
    Configuration conf = new Configuration();
    SessionFactory sf = conf.configure("hibernate.cfg.xml").buildSessionFactory();
}