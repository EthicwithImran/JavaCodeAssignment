import java.util.*;

class Randomcap
{
	Randomcap(){

    }
    int Randomcap(){
        int shuru;

		int khatam;
		
		shuru=1;
		khatam=4;
		int randomnew=(int)(Math.random()*(khatam-shuru+1)+shuru);
        return randomnew;      
	}
}
