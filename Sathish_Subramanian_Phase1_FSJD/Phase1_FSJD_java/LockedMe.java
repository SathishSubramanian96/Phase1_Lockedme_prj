package Phase1_FSJD_java;

import java.io.*;
import java.util.*;


public class LockedMe {
	static String DIRECTORY;
	File folder_name;
	
	
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

  
	public static void main(String[] args) {
		LockedMe menu = new LockedMe();
		System.out.println(WELCOME_PROMPT);
		
	}

}
