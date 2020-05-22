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

public class AbortImposeResponse{
    int ballot;
    public AbortImposeResponse(int _ballot)
    {
	ballot = _ballot;
    }
    int getBallot()
    { // needed to distinguish abort from other older requests
	return ballot;
    }
}