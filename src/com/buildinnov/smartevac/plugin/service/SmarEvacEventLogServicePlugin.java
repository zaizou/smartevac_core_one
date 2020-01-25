package com.buildinnov.smartevac.plugin.service;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/


import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientInterface;


import com.google.common.base.Charsets;
import org.bimserver.shared.exceptions.PluginException;
import org.tinfour.common.Vertex;
import org.tinfour.demo.utils.TestVertices;
import org.tinfour.demo.utils.TinRenderingUtility;
import org.tinfour.standard.IncrementalTin;

import java.io.File;
import java.util.List;

public class SmarEvacEventLogServicePlugin extends AbstractAddExtendedDataService {
	private static final String NAMESPACE = "http://bimserver.org/eventlog";

	public SmarEvacEventLogServicePlugin() {
		super(NAMESPACE);
	}


	@Override
	public void init(PluginContext pluginContext) throws PluginException {
		super.init(pluginContext);
		System.out.println("initialising SmarEvacEventLogServicePlugin");
	}

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
		SProject project = bimServerClientInterface.getServiceInterface().getProjectByPoid(poid);
		IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, true);




		PluginConfiguration pluginConfiguration = new org.bimserver.plugins.PluginConfiguration(settings);
		
		String nlsfbType = pluginConfiguration.getString("nlsfb");
		String materialType = pluginConfiguration.getString("material");
		//EventLog eventLog = new EventLog(model, nlsfbType, materialType);
		//String csvString = eventLog.toCsvString();
		//addExtendedData(csvString.getBytes(Charsets.UTF_8), "eventlog.csv", "Eventlog", "text/csv", bimServerClientInterface, roid);

		
	}


	public static void main(String []args) throws Exception {
		IncrementalTin tin = new IncrementalTin(1.0);
		List<Vertex> vertexList = TestVertices.makeRandomVertices(100, 0);
		tin.add(vertexList, null);
		TinRenderingUtility.drawTin(tin, 500, 500, new File("tin.png"));
	}

}