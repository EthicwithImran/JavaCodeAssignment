import java.util.*;
public class Selectcap {
    public static void main(String[] args) {
        String team[]=new String[3];
        Player p=new Player();
        Randomcap c=new Randomcap();
        int a=c.Randomcap(); 
        for(int i=0;i<team.length;i++)
        {
            team[i]=p.PlayerDetails();
        }
        for(int j=0;j<1;j++){
            System.out.println("Selected captain is : "+team[a-1]);
           
        }
    }   
}
