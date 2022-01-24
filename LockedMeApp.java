import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class LockedMeApp {
private static File[] matchingFiles;

@SuppressWarnings("unchecked")
public static void main(String[] args) {
	System.out.println("LockedMe.com project application, for Company Lockers Pvt. Ltd");	
	System.out.println(" ");	
    try (Scanner input = new Scanner(System.in)) {


		int choice;
		while(true){
		    System.out.println("Main Menu\n");
		    System.out.print("1.) Sort file names in ascending order \n");
		    System.out.print("2.) Add filename defined in code.\n");
		    System.out.print("3.) Delete file defined in code.\n");
		    System.out.print("4.) Search for a file you enter.\n");
		    System.out.print("5.) Exit\n");
		    System.out.print("\nEnter Your Menu Choice: ");

		    choice = input.nextInt();


		switch(choice){

		case 1:
            Scanner keyboard = new Scanner( System.in );
            System.out.println("Enter the file path: ");
            String dirPath = keyboard.nextLine(); // Takes the directory path as the user input

            File folder = new File(dirPath);
            if(folder.isDirectory())
            {
                File[] fileList = folder.listFiles();

                Arrays.sort(fileList);

                System.out.println("\nTotal number of items present in the directory: " + fileList.length );


                // Lists only files since we have applied file filter
                for(File file:fileList)
                {
                    System.out.println(file.getName());
                }

                // Creating a filter to return only files.
                FileFilter fileFilter = new FileFilter()
                {
                    @Override
                    public boolean accept(File file) {
                        return !file.isDirectory();
                    }
                };

                fileList = folder.listFiles(fileFilter);

                // Sort files by name
                Arrays.sort(fileList, new Comparator()
                {
                    @Override
                    public int compare(Object f1, Object f2) {
                        return ((File) f1).getName().compareTo(((File) f2).getName());
                    }
                });

                //Prints the files in file name ascending order
                for(File file:fileList)
                {
                    System.out.println(file.getName());
                }
                
		    break; }

		case 2: 
			// Check if a file already exist in Java
			Path path = Paths.get("C:\\Users\\gwary\\eclipse-workspace\\LockedMe\\file6.txt");
			 
			boolean doesFileExist =
			        Files.exists(path,
			            new LinkOption[]{ LinkOption.NOFOLLOW_LINKS });


			// Create a new file or append to an existing file
			List<String> lines = Arrays.asList("1st line of test text", "2nd line of test text");
			 
			try {
				for (Path path3 : Files.write(Paths.get("file6.txt"), lines, 
				        StandardCharsets.UTF_8)) {
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



			// Create a new file with default options
			List<String> lines1 = Arrays.asList("1st line of test text", "2nd line of test text");
			 
			try {
				for (Path path2 : Files.write(Paths.get("file6.txt"), 
				                lines1, 
				                StandardCharsets.UTF_8,
				                StandardOpenOption.CREATE, 
				                StandardOpenOption.APPEND)) {
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    break;

		case 3:
            // Deletes a file in 
			File file = new File("C:\\Users\\gwary\\eclipse-workspace\\LockedMe\\file6.txt");
	          
	        if(file.delete())
	        {
	            System.out.println("File deleted successfully");
	        }
	        else
	        {
	            System.out.println("Failed to delete the file");
	        }
		    break;

		case 4: 
			 File temp;
		      try
		      {
		         temp = File.createTempFile("file6", ".txt");
		          
		         boolean exists = temp.exists();
		          
		         System.out.println("Temp file exists : " + exists);
		      } catch (IOException e)
		      {
		         e.printStackTrace();
		      }
		    break;


		case 5: 
		    System.out.println("Exiting Program...");
		    System.exit(0);
		     break;
		default :
		         System.out.println("This is not a valid Menu Option! Please Select Another");
		         break;

		}

		}
	}

    }

   }