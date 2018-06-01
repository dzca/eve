package ca.eve.app.tiger.tools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

public class TestReadFile {

	@Test
	public void read() throws URISyntaxException {
		Path path = Paths.get(getClass().getClassLoader()
	    	      .getResource("sessions2017.txt").toURI());
	    	          
	    	    StringBuilder data = new StringBuilder();
	    	    //Stream<String> lines = Files.lines(path);
	    	    
		//String fileName = "c://lines.txt";

		//read file into stream, try-with-resources
		//try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(item-> System.out.println(String.format("\"%s\",", item)));

			//1. filter line 3
			//2. convert all content to upper case
			//3. convert it into a List
//			list = stream
//					.filter(line -> !line.startsWith("line3"))
//					.map(String::toUpperCase)
//					.collect(Collectors.toList());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
