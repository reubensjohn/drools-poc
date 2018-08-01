package com.zyngl.raas.poc.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.drools.workshop.model.User;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import com.zyngl.raas.poc.api.UserCategorizationService;

@Component
public class UserCategorizationServiceImpl implements UserCategorizationService {

//    @Inject
//    @KReleaseId(groupId = "com.zyngl.raas", artifactId = "drools-user-kjar", version = "1.0-SNAPSHOT")
//    @KSession
    private KieSession kSession;

  //RSJ Modification
    //@Bean(name="dynamic-session")
    //@Bean
	public KieSession getKieSession() {
	   KieServices kieServices = KieServices.Factory.get();
       ReleaseId releaseId = kieServices.newReleaseId("com.zyngl.raas", "drools-user-kjar", "1.0.0-SNAPSHOT");

       // make sure you use "LATEST" version
       KieContainer kieContainer = kieServices.newKieContainer(releaseId);
       KieSession kSession = kieContainer.newKieSession("dynamic-session");

       // Poll every 30 seconds
       KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
       kieScanner.start(30000L);

	   return kSession;
	}
    
    public UserCategorizationServiceImpl() {
    }

    @Override
    public Response categorizeUser(User user) {
    	//RSJ Modification
    	kSession = getKieSession();
    	
        System.out.println(">> kSession: " + kSession);
        printKieSessionAllFacts(kSession);
        System.out.println(">> User: " + user);
        kSession.insert(user);
        int fired = kSession.fireAllRules();
        System.out.println(">> Fired: " + fired);
        return Response.status(Status.OK).entity(user).build();
    }

    @Override
    public Response getUsers() {
        List<User> users = new ArrayList<User>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof User) {
                users.add((User) o);
            }
        }
        //return users;
        return Response.status(Status.OK).entity(users).build();
    }

    private void printKieSessionAllFacts(KieSession kSession) {
        System.out.println(" >> Start - Printing All Facts in the Kie Session");
        for (Object o : kSession.getObjects()) {
            System.out.println(">> Fact: " + o);
        }
        System.out.println(" >> End - Printing All Facts in the Kie Session");
    }

}
