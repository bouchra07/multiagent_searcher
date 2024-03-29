package Utilisateur;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class UtilisateurAgent  extends GuiAgent{
	private UtilisateurGUI gui;
	
	@Override
     protected void setup(){
		gui=new UtilisateurGUI();
		gui.setUtilisateurAgent(this);
    	ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
    	 addBehaviour(parallelBehaviour);
    	 parallelBehaviour.addSubBehaviour(new CyclicBehaviour(){
    		 Integer i=0;
			@Override
			public void action() {
				MessageTemplate messageTemplate = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("utilisateur"));
				ACLMessage aclMessage = receive(messageTemplate);
				MessageTemplate messageTemplate1 = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("resfin"));
				ACLMessage aclMessage1 = receive(messageTemplate1);
				if(aclMessage1!=null){
					String description = aclMessage1.getUserDefinedParameter("description");
					String brand = aclMessage1.getUserDefinedParameter("brand");
					String type = aclMessage1.getUserDefinedParameter("type");
					System.out.println(description);
					
					
					
					if(description.length() != 3){
						gui.showMessage("\n"
					
							+ "The laptops with the brand "+brand+" and type "+description+" are : \n"+type+"\n");
						}
					
					else{
						gui.showMessage("\n"
								+ "Aucune resultat n'est trouve");
					}
					
					
					
				
				}
				else{
					block();
				}
				
					
				}
				
			
    		 
    	 });
    	 
	}
	@Override
	public void onGuiEvent(GuiEvent ev) {
		
		switch(ev.getType()){
		case 1:
			String brand = (String) ev.getParameter(0);
			String type = (String) ev.getParameter(1);
			List<String> list =new ArrayList<String>();
			list.add(brand);
			list.add(type);
			System.out.println(brand+"      "+type);
			
			ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
			aclMessage.addReceiver(new AID("intermediaire1",AID.ISLOCALNAME));
			try {
				aclMessage.setContentObject((Serializable) list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//aclMessage.setContent(type);
			aclMessage.setOntology("intermed");
			send(aclMessage);
			break;
		
		}
		
		
	}
}