package com.app.dao;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class AbstractDao {

	//@Autowired
	private DataSource myDataSource;
	//@Autowired
	private SessionFactory sessionFactory;

	private JdbcTemplate jdbcTemplate;
	private HibernateTemplate hibernateTemplate;

	public void setMyDataSource(DataSource myDataSource) {
		this.myDataSource = myDataSource;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public JdbcTemplate getJdbcTemplate() {
		if (null == jdbcTemplate) {
			jdbcTemplate = new JdbcTemplate(myDataSource);
		} else if (null == jdbcTemplate.getDataSource()) {
			if (null == myDataSource) {
				System.out
						.println("Data source required *****************************************");
			} else {
				jdbcTemplate = new JdbcTemplate(myDataSource);
			}
		}

		return jdbcTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		if (null == hibernateTemplate) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}

		return hibernateTemplate;
	}

}
