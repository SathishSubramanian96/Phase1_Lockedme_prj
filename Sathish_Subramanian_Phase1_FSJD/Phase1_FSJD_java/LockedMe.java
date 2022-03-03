package Phase1_FSJD_java;

import java.io.*;  
import java.util.*;


public class LockedMe {
	static String DIRECTORY;
	File folder_name;
	
	public void primaryMenu() {
		try {
		System.out.println(PRIMARY_PROMPT);
		Scanner sc  = new Scanner(System.in);
		int option =sc.nextInt();
		sc.close();
		
		
		switch(option) {
		
		case 1: {
		showFiles();
		primaryMenu();
		}
		
		case 2 : {
			 secondaryMenu();
		}
		
		case 3 : {
			System.out.println("Thank You\n"+ "Happy Learning\n");
			System.exit(0);
		} 
		
		
		default : {
			System.out.println("Please enter any of the following options 1, 2 or 3\n");
			primaryMenu();
			}
		}
	}catch(Exception e) {
			System.out.println("Please enter any of the following options 1, 2 or 3\n");
			primaryMenu();
		}	
	}
	
	public void secondaryMenu() {
		System.out.println(SECONDARY_PROMPT);
		try { Scanner sb=new Scanner(System.in);
		char[] a =sb.nextLine().toLowerCase().trim().toCharArray();
		char b= a[0];

		switch (b)
		{
		case a: {
			System.out.println("Adding a new file...Please enter a file name : ");
			String name=sb.next().trim().toLowerCase();
			addFile(name);
			break;
			
		}
		case b : {
			System.out.println("Deleting the file...Please enter the file name : ");
			String name=sb.next().trim().toLowerCase();
			deleteFile(name);
			
		}
		
		case c : {
			System.out.println("Searching the file...Please enter a file name : ");
			String name=sb.next().trim().toLowerCase();
			searchFile(name);
			
		}
		
		case d : {
			System.out.println("Switching to Primary Menu /n");
			primaryMenu();
		}
		
		default : 
			
			
		}
		}catch (Exception e)
		{
			System.out.println("Please enter any of the following option a, b, c or d \n");
			secondaryMenu();
		}
		
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
			"1 --> Show the files in the directory\n"+
	        "2 --> Add,Delete or Search for files\n"+
			"3 --> Exit Application\n";
	
	
	private static final String SECONDARY_PROMPT ="\n"+
	"Sendory Menu --> Select any of the following options\n"+
			"a --> Add a file\n"+
	          "b --> Delete a file\n"+
			     "c --> Search a file\n"+
	                "d --> Previous Menu \n";
	 


  
	public static void main(String[] args) {
		LockedMe menu = new LockedMe();
		System.out.println(WELCOME_PROMPT);
		menu.primaryMenu();
	}

}
