
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class USBLogger {

    /**
     * Program by Andreas Neil Jensen, all rights reserved.
     * System.lineSeparator() is used in order to provide platform-independent line separation.
     */
    public static void main(String[] args) {
        String line1 = "User name: " + System.getProperty("user.name").toString() + System.lineSeparator();  
        String line2 = "Operating system name: " + System.getProperty("os.name").toString() + System.lineSeparator();  
        String line3 = "Operating system version: " + System.getProperty("os.version").toString() + System.lineSeparator();
        String line4 = "Operating system architecture: " + System.getProperty("os.arch").toString() + System.lineSeparator();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime localDateTime = LocalDateTime.now();  
        String line5 = dateTimeFormatter.format(localDateTime);
        
        String data = line1 + line2 + line3 + line4 + line5 + System.lineSeparator() + System.lineSeparator();
        writeToFile(data);
        
        System.out.println("Information has been logged.");
    }
    
    /**
     * I used a PrintWriter so that I was able to use 'println' 
     * which just provided me with an easy way of appending to a file without checking if the file already existed.
     * @param data - String containing the text which should be printed to the log.
     */
    private static void writeToFile(String data) {

    	try(FileWriter fileWriter = new FileWriter("log.txt", true);
    		    BufferedWriter bbufferedWriterw = new BufferedWriter(fileWriter);
    		    PrintWriter printWriter = new PrintWriter(bbufferedWriterw))
    		{
    		    printWriter.println(data);
    		} catch (IOException e) {
    		    //exception handling left as an exercise for the reader
    		}
    	
    }
}
