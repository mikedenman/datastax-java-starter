package com.datastax.sample.service;

import java.util.List;
import java.util.Set;

import com.codahale.metrics.Gauge;
import com.datastax.demo.utils.PropertyHelper;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.sample.dao.SampleDao;

public class Service {

	private SampleDao dao;

	public Service() {	
                String contactPointsStr = System.getProperty("contactPoints");
                if (contactPointsStr == null) {
                        contactPointsStr = "127.0.0.1";
                }

		this.dao = new SampleDao(contactPointsStr.split(","));
	}	
	
	public List<KeyspaceMetadata> getKeyspaces() {
		return dao.getKeyspaces();
	}
}
