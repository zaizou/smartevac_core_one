package com.buildinnov.smartevac.plugin.evacplans_generation.services;

import org.bimserver.shared.interfaces.PublicInterface;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(
        name = "EvacuationPlanServiceInterface",
        targetNamespace = "org.bimserver"
)
@SOAPBinding(
        style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)

public interface EvacuationPlanServiceInterface extends PublicInterface {
    @WebMethod(
            action = "getNavigationPlan"
    )
    Object getNavigatoionPlan(@WebParam(name = "poid") Long poid, @WebParam(name = "roid") Long roid) throws Exception;


}
