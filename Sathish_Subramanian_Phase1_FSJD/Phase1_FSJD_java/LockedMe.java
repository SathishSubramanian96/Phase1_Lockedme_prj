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
		
		
		
		switch(option) {
		
		case 1: {
		showFiles();
		primaryMenu();
		}
		
		case 2 : {
			 secondaryMenu();
			 break;
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
		char[] aa =sb.nextLine().toLowerCase().trim().toCharArray();
		char ab= aa[0];

		switch (ab)
		{
		case 'a': {
			System.out.println("Adding a new file...Please enter a file name : ");
			String name=sb.next().trim().toLowerCase();
			addFile(name);
			secondaryMenu();
			break;
			
		}
		case 'b' : {
			System.out.println("Deleting the file...Please enter the file name : ");
			String name=sb.next().trim().toLowerCase();
			deleteFile(name);
			secondaryMenu();
			break;
			
		}
		
		case 'c' : {
			System.out.println("Searching the file...Please enter a file name : ");
			String name=sb.next().trim().toLowerCase();
			searchFile(name);
			secondaryMenu();
			break;
			
		}
		
		case 'd' : {
			System.out.println("Switching to Primary Menu \n");
			primaryMenu();
		}
		
		default : 
			System.out.println("Please enter any of the following option a, b, c or d \n");
			secondaryMenu();
		  }
	} catch (Exception e)
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
	 
	void showFiles() {
		if(folder_name.list().length==0) {
			System.out.println("The folder is empty");
		} else if(folder_name.list().length==1) {
			String[] str=folder_name.list();
			System.out.println("The file in "+folder_name+" is : "+str[0]);
		}
		else {
			String[] name = folder_name.list();
			System.out.println("The files in "+folder_name+" are :");
		    Arrays.sort(name);
		    for (String str: name) {
		    	System.out.println(str);
		    }
		}
	}
	
	void addFile(String name)  throws IOException{
		File path = new File(folder_name+"/"+name);
		String[] list= folder_name.list();
		for(String file: list)
		if(name.equalsIgnoreCase(file)) {
			System.out.println("File " + file+ " already exist at "+"folder_name\n");
			return;
		}
		path.createNewFile();
		System.out.println("File "+ name +" is created at " + folder_name);
	}
	
	void deleteFile(String name)  throws IOException{
		   File path = new File(folder_name+"/"+name);
		   String[] list= folder_name.list();
			 for (String file: list) {
	            if (name.equals(file) && path.delete()) {
	                System.out.println("File " + name + " deleted from " + folder_name);
	                return;
	            }
	        }
	        System.out.println("Delete Operation failed. FILE NOT FOUND");
	    }
	
	 void searchFile(String name)  throws IOException{
			String[] list = folder_name.list();
	        for (String file: list) {
	            if (name.equals(file)) {
	                System.out.println("FOUND : File " + name + " exists at " + folder_name);
	                return;
	            }
	        }
	        System.out.println("File not found (FNF)");
			
		}


  
	public static void main(String[] args) {
		LockedMe menu = new LockedMe();
		System.out.println(WELCOME_PROMPT);
		menu.primaryMenu();
	}

}
