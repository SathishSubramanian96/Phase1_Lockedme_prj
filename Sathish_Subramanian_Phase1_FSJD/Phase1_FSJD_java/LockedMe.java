package Phase1_FSJD_java;

import java.io.*; 
import java.util.*;


public class LockedMe {
	static String DIRECTORY;
	File folder_name;
	
	public void primaryMeny() {
		System.out.println(PRIMARY_PROMPT);
	}
	
	public LockedMe() {
        DIRECTORY = System.getProperty("user.dir");
        folder_name = new File(DIRECTORY+"/files");
        if (!folder_name.exists())
            folder_name.mkdirs();
        System.out.println("DIRECTORY : "+ folder_name.getAbsolutePath());
    }
	
	private static final String WELCOME_PROMPT =""+
"\n#################    LockedMe.com     #################\n"+
"\n################# Sathish Subramanian #################\n";
	
	private static final String PRIMARY_PROMPT ="\n"+
	"Main Menu --> Select any of the following option\n"+
			"1 --> Show the files in the directory"+
	        "2 --> Add,Delete or Search for files"+
			"3 --> Exit Application";
	
	

  
	public static void main(String[] args) {
		LockedMe menu = new LockedMe();
		System.out.println(WELCOME_PROMPT);
		
	}

}
