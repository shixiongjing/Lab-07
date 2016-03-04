import java.util.Scanner;
import java.io.*;

public class Universe{
    
    public static void main(String[] args){
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.print("How big will this universe be? >>");
    	int size=sc.nextInt();
    	char[] universe=generateUniverse(size);
        printarray(universe);
    	System.out.print("[Q]uit, [A]dvance one iteration or [S]ave to file?");
    	String choice=sc.next();


    	while(choice.equals("A")){
    		rununiverse(universe);
    		printarray(universe);
            System.out.print("[Q]uit, [A]dvance one iteration or [S]ave to file?");
            choice=sc.next();
    	}
        if(choice.equals("S")){
            System.out.println("What do you want to name the file?");
            String name=sc.next();
            save(universe,name);
        }

    }

    public static char[] generateUniverse (int size){
    	char[] universe=new char[size];
    	for(int i=0;i<size;i++){
    		if(i%7==0){
    			universe[i]='0';
    		}
    		else if(i%5==0){
    			universe[i]='^';
    		}
    		else{
    			universe[i]='.';
    		}
    	}
    	return universe;
    }

    public static void rununiverse (char[] array){
    	for(int i=0;i<array.length;i++){
    		if(array[i]=='0'){
    			array[i]='1';
    		}
    		else if(array[i]=='1'){
    			array[i]='2';
    		}
    		else if(array[i]=='2'&&i<array.length-1){
    			if(array[i+1]=='^'){
    				array[i+1]='b';
    				array[i]='.';
    			}
    			else if(array[i+1]=='.'){
                    array[i+1]='a';
    				array[i]='.';
    			}
                
    		}
    		else if(array[i]=='a'){
    			array[i]='2';
    		}
    		else if(array[i]=='b'){
    			array[i]='0';
    		}
    		
    	}
    }

    public static void printarray (char[] array){
    	for(int i=0;i<array.length;i++){
    		System.out.print(array[i]);
    	}
        System.out.print("\n");
    }

    public static void save(char[] array, String nam){
        File file=new File(nam+".txt");
        int child=0, adult=0, baby=0;
        for(int i=0;i<array.length;i++){
            if(array[i]=='0'){
                baby++;
            }
            if(array[i]=='1'){
                child++;
            }
            if(array[i]=='2'){
                adult++;
            }
        }
        
            try{
            FileWriter create=new FileWriter(nam+".txt");
            PrintWriter output=new PrintWriter(create);
            String array1=new String(array);

            output.println(array1);
            output.println("Children: "+child);
            output.println("Baby: "+baby);
            output.println("Adult: "+adult);
            output.close();
            }catch(Exception e){}
            
        }
    }
    

