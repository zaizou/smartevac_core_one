package com.buildinnov.smartevac.plugin.evacplans_generation.services;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.interfaces.PublicInterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



public class EvacuationPlanServiceAdaptor  implements EvacuationPlanServiceInterface{


    @Override
    public Object getNavigatoionPlan(Long poid, Long roid) throws Exception {
        /*
        BimServerClientInterface bimServerClientInterface = this.getLocalBimServerClientInterface(null);
        SProject project = bimServerClientInterface.getServiceInterface().getProjectByPoid(poid);
        IfcModelInterface model = bimServerClientInterface.getModel(project,roid,false,false,true);
        VertexExtractorIFC2x3 vertexExtractorIFC2x3 = new VertexExtractorIFC2x3();
        return vertexExtractorIFC2x3.processLevelsSpacesGraphForFrontEnd(model);
         */
        return null;
    }
}
