package com.example;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);// Logger attached to actor
    private final int N;//number of processes
    private final int id;//id of current process
    private Members processes;//other processes' references

    public Process(int ID, int nb) {
        N = nb;
        id = ID;
    }
    
    public String toString() {
        return "Process{" + "id=" + id ;
    }

    /**
     * Static function creating actor
     */
    public static Props createActor(int ID, int nb) {
        return Props.create(Process.class, () -> {
            return new Process(ID, nb);
        });
    }
    
    public void onReceive(Object message) throws Throwable {
    	
          if (message instanceof Members) {//save the system's info
              Members m = (Members) message;
              processes = m;
              log.info("p" + self().path().name() + " received processes info");
          }
          if (message instanceof OfconsProposerMsg) {
        	  OfconsProposerMsg opm = (OfconsProposerMsg) message;
        	  log.info("p" + self().path().name() + " received OfconsProposerMsg: " + opm.message);
        	  ReadMsg rm = new ReadMsg("test read");
        	  for(ActorRef actor: processes.references) {
        		  log.info("p" + self().path().name() + " sent ReadMsg to " + "p" + actor.path().name());
        		  actor.tell(rm, self());
        	  }
          }
          if(message instanceof ReadMsg) {
        	  ReadMsg rm = (ReadMsg) message;
        	  log.info("p" + self().path().name() + " received ReadMsg: " + rm.message);
          }
      
    }
}