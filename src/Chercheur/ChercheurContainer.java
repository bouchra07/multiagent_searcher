package Chercheur;

import jade.core.ProfileImpl;
import jade.core.Runtime;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ChercheurContainer {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Runtime runtime=Runtime.instance();
			ProfileImpl profileImpl= new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST,"localhost");
			AgentContainer agentContainer= runtime.createAgentContainer(profileImpl);
			
			AgentController agentController=agentContainer.createNewAgent("chercheur1", ChercheurAgent.class.getName(), new Object[]{});
			agentController.start();
			
			//agentContainer.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
