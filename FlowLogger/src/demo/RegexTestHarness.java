package demo;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//The metacharacters supported by this API are: <([{\^-=$!|]})?*+.>

/*There are two ways to force a metacharacter to be treated as an ordinary character:
precede the metacharacter with a backslash, or
enclose it within \Q (which starts the quote) and \E (which ends it).
When using this technique, the \Q and \E can be placed at any location within the expression, provided that the \Q comes first.
*/
// Website http://myregexp.com/
public class RegexTestHarness {

    public static void main(String[] args) throws IOException{
    	
    	
//    	String line ="CA:DEBUG 16:25:01:149 ActionState - Entering state 'setFailOverFlag' of flow 'ownershipSignerChange-flow'";
//    	String line ="The dog plays in the yard.";
//    		Pattern pattern = Pattern.compile("(CA:DEBUG.*\\bState\\b.*\\bEntering state\\b.*)");
    		//(CA:DEBUG.*\\bActionExecutor\\b.*\\bFinished executing\\b.*)
//    		Pattern pattern = Pattern.compile("(CA:DEBUG.*\\bActionExecutor\\b.*\\bFinished executing\\b.*)");
//    	(^.*(\\bActionState\\b|\\bViewState\\b|\\bDecisionState\\b|\\bSubflowState\\b|\\bEndState\\b).*\\bEntering state\\b.*)
    		Pattern pattern = Pattern.compile("(^.*(\\bActionState\\b|\\bViewState\\b|\\bDecisionState\\b|\\bSubflowState\\b|\\bEndState\\b).*\\bEntering state\\b.*)");
    		Matcher matcher = null; 
//            boolean found = false;
            
            BufferedReader bufferedReader =new BufferedReader(new FileReader(new File("C:\\Vasanth\\logs\\tcpa-logs.txt")));   
            String line;
            try{
            	while((line=bufferedReader.readLine())!=null)
                {
                	
                	matcher=pattern.matcher(line);
                	if(matcher.find())
                	{
                		System.out.println(line);
                	}
                }
            }
            catch(IOException io)
            {
            	io.printStackTrace();
            }
            finally
            {
            	bufferedReader.close();
            }
            
            
            System.out.println("Completed...");
            
            
            /*if(matcher.find())
            {
            	System.out.println("I found the text");
                found = true;
            }*/
            
            /*while (matcher.find()) {
            	System.out.println("I found the text");
                found = true;
            }
            if(!found){
                System.out.println("No matches found");
            }*/
        /*}*/
    }
}

