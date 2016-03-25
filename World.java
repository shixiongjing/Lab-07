import java.util.Scanner;
import java.io.*;

public class World{

    int[][][][][] universe;

    public World(){
        universe=new int[10][10][10][10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    for(int m=0;m<10;m++){
                        for(int n=0;n<10;n++){
                            universe[i][j][k][m][n]=(i+j+k+m+n)%10;
                        }
                    }
                }
            }
        }
    }


    public static int[] wrap (int[] location){
    	int[] loc1=new int[6];
        for(int i=0;i<6;i++){
            if(location[i]>=0){
                loc1[i]=location[i]%10;
            }
            else{
                while(location[i]<0){
                    location[i]=location[i]+10;
                }
                loc1[i]=location[i]%10;
            }
        }
    	return loc1;
    }

    public void paint(int[] a){
        universe[a[0]][a[1]][a[2]][a[3]][a[4]]=11;
    }

    public int getcolor(int[] a){
        int color=universe[a[0]][a[1]][a[2]][a[3]][a[4]];
        return color;
    }

    public String printcolor(int a){
        String color;
        if(a==1){
            color="Lime";
        }
        else if(a==2){
            color="Cerulea";
        }
        else if(a==3){
            color="Goldenrod";
        }
        else if(a==11){
            color="white";
        }
        else {
            color="black";
        }
        return color;
    }
 
}