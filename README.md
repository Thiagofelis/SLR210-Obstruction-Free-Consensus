# Paxos's Synoid in the Akka framework

The problem of consensus is fundamental in real-world systems. It is the basis of many distributed systems and blockchain algorithms. The Synoid Algorithm is an obstruction free algorithm that solves consensus on the message passing model. Its main use is implementing state-machine replication through the Paxos algorithm.

This projects implements the Synoid Algorithm using the Akka framework in Java. We run some tests, for which we present the results and a discussion of them. This was done with João André Pestre for the SLR210 course at Télécom Paris.

The pseudocode of the algorithm is presented at `class02-paxos.pdf`. To see a description of the specification of the project, check `project.pdf`. Results are presented in `report.pdf` and `slides.pdf`. At directory `implementation` run `mvn compile exec:exec` to see all events, or `mvn compile exec:exec | grep "MAIN"` to see only test results.


