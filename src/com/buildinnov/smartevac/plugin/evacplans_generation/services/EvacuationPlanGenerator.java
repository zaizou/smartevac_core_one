package com.buildinnov.smartevac.plugin.evacplans_generation.services;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc4.*;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;

import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EvacuationPlanGenerator extends AbstractAddExtendedDataService implements EvacuationPlanServiceInterface

{

    private static final String NAMESPACE = "http://bimserver.org/eventlog";
    public EvacuationPlanGenerator() {
        super(NAMESPACE);
    }

    Map<Integer, Map<String,IfcDoor>> doorsByLevel = new HashMap<Integer,Map<String,IfcDoor>>();
    ///used in the processBoundary method
    //to avoid to select the door twice
    private List<String> treatedDoorsGIDs = new ArrayList<String>();
    private  Integer currentLogicalLevel = 0;


    @Override
    public void init(PluginContext pluginContext) throws PluginException {
        super.init(pluginContext);
        System.out.println("initialising SmartEvacQueryPlugin");
    }





    @Override
    public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
        System.out.println("new revision method invoked");
        SProject project =bimServerClientInterface.getServiceInterface().getProjectByPoid(poid);
        IfcModelInterface model =bimServerClientInterface.getModel(project,roid,false,false,true);

        System.out.println("Model gotten ");
        VertexExtractorIFC2x3 vertexExtractorIFC2x3 = new VertexExtractorIFC2x3();
        VertexExtractorIFC4 extractorIFC4 = new VertexExtractorIFC4();
        if( project.getSchema().equals("ifc2x3tc1")){
            vertexExtractorIFC2x3.processLevelsSpacesGraph(model);
            System.out.println("Project schema : IFC2x3tc1");
        }
        else {
            extractorIFC4.processLevelsFull(model);
            System.out.println("Project schema : IFC4");
        }
    }

    @Override
    public Object getNavigatoionPlan(Long poid, Long roid) throws Exception {
        BimServerClientInterface bimServerClientInterface = this.getLocalBimServerClientInterface(null);
        SProject project = bimServerClientInterface.getServiceInterface().getProjectByPoid(poid);
        IfcModelInterface model = bimServerClientInterface.getModel(project,roid,false,false,true);
        VertexExtractorIFC2x3 vertexExtractorIFC2x3 = new VertexExtractorIFC2x3();
        return vertexExtractorIFC2x3.processLevelsSpacesGraphForFrontEnd(model);
    }


/*
    public Object getNavigatoionPlan(long poid,long roid) throws Exception{



    }
*/







}
