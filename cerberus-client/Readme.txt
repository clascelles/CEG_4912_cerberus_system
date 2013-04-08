To run the cerberus-client as a .jar, follow these steps:

	1. Export the project in Eclipse as a Runnable Jar.
	2. Make sure that "Package required libraries into generated JAR" is selected.
	3. Create the runnable cerberus-client.jar file.
	4. Copy the log4j.xml file and the logs folder in the same directory as the .jar file
	5. Open a command prompt as an admin.
	6. go to the directory and run the jar file like this:
		java -jar cerberus-client.jar
	
	7. There are five arguments to control the simulation. Here's an example:
		java -jar cerberus-client.jar 192.168.1.181 8080 16 60000 false
	
	The previous call sets the server host to 192.168.1.181, the server port to 8080, 
		with 16 client threads, for 60000 ms (1 min), and the last boolean disables FULL BLAST (add delays before sending messages)
		