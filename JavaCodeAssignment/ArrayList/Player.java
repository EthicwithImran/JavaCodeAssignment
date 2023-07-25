import java.util.*;
public class Player 
{
    String name,type;
        int age;
        double height;
    Player(){

    }
    String PlayerDetails()
    {
        Scanner n=new Scanner(System.in);
        
             System.out.println("Enter Player Name :");
             name=n.next();
            System.out.println("Enter Player Height :");
             height=n.nextDouble();
             System.out.println("Enter Player Age :");
            
             age=n.nextInt();
             if(age>15)
             {
                System.out.println("Enter the type of player Bowler or Batsman or Wicket-Keeper");
                type=n.next();
                
            }
             else   
             {
                System.out.println("Plz try again");
             }
            
            /*System.out.println("Player name are : "+this.name);
            System.out.println("Player age are : "+this.age);
            System.out.println("Player type are : "+this.type);
            System.out.println("Player height are : "+this.height);
             */
        return "Name  : " + name + "\nHeight :" +height + "\nAge :" +age + "\nType :" + type;
            }
        
    }

