Ethan Tuning
6/7/2017
CSCD330
Ping Program

Tools: Notepad++, cmd.exe, javac, windows10.
Instructions: Run via JVM like any other java program.
	      "java PingServer 1634"
	      "java PingClient 127.0.0.1 1633"
Overview: Developing was pretty straight forward, just copied the
	  server code and changed a few things so that the client
	  would actually stop after 10 packets were pinged.
Tests: Just wrote a few JUNIT tests, to test the connection, then
       the actual packet retrieval and sending. Also ran the
       program a few times just to make sure it worked fine.