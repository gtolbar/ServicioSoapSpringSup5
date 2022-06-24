package com.ti.customer.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ti.customer.entity.Collaborator;
import com.ti.customer.schema.*;
import com.ti.customer.service.CollaboratorService;

@Endpoint
public class CollaboratorEndPoint<collaboratorResponse> {
	private static final String NAMESPACE_URI ="http://www.example.org/Collaborator";
	
	@Autowired
	CollaboratorService customerServiceImpl;
	
	
	@PayloadRoot(namespace=NAMESPACE_URI,localPart="collaboratorRequest")
	@ResponsePayload
	public JAXBElement<CollaboratorResponse> getCollaborator(@RequestPayload JAXBElement<CollaboratorRequest> request){
		
		ObjectFactory  objectFactory = new ObjectFactory();
		CollaboratorResponse collaboratorResponsefactory = objectFactory.createCollaboratorResponse();
		JAXBElement<CollaboratorResponse> collaboratorResponse = objectFactory.createCollaboratorResponse(collaboratorResponsefactory);
		
		try {
			int action = request.getValue().getAction();
			
			if(action ==1) {
				CollaboratorResponse collaboratorResponseObject= new CollaboratorResponse();
				List<Collaborator> listCollaborator = customerServiceImpl.getListAllCollaborator();
				
				if(listCollaborator!=null) {
					for(Collaborator collab:listCollaborator) {
						CollaboratorDetails collaboratorDetails = new CollaboratorDetails();
						collaboratorDetails.setId(collab.getCollabid().intValue());
						collaboratorDetails.setAlias(collab.getCollabalias());
						collaboratorDetails.setDni(collab.getCollabdni());
						collaboratorDetails.setEmail(collab.getCollabemail());
						collaboratorDetails.setImageCollaborator(collab.getCollabimage());
						collaboratorDetails.setPassword(collab.getCollabpassword());
						collaboratorDetails.setName(collab.getCollabname());
						collaboratorResponseObject.getCollaboratorDetails().add(collaboratorDetails);
					}
				}
				collaboratorResponse.setValue(collaboratorResponseObject);
				
			}else if(action==2) {
				CollaboratorResponse collaboratorResponseObject= new CollaboratorResponse();
				Collaborator collaborator = customerServiceImpl.getCollaboratorById(new Long(request.getValue().getId()));
				CollaboratorDetails collaboratorDetails = new CollaboratorDetails();
				if (collaborator!=null) {
					collaboratorDetails.setId(collaborator.getCollabid().intValue());
					collaboratorDetails.setAlias(collaborator.getCollabalias());
					collaboratorDetails.setDni(collaborator.getCollabdni());
					collaboratorDetails.setEmail(collaborator.getCollabemail());
					collaboratorDetails.setImageCollaborator(collaborator.getCollabimage());
					collaboratorDetails.setPassword(collaborator.getCollabpassword());
					collaboratorDetails.setName(collaborator.getCollabname());
					collaboratorResponseObject.getCollaboratorDetails().add(collaboratorDetails);
					collaboratorResponse.setValue(collaboratorResponseObject);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return collaboratorResponse;
		
	}
	
}
