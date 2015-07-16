import java.util.*;
import java.util.Random;

public class War_Game <K,V>{     
	 static SimpleLinkedListMap<Integer,Integer> map = new  SimpleLinkedListMap<Integer,Integer>();
	 static SimpleLinkedListMap<Integer,Integer> map2 = new  SimpleLinkedListMap<Integer,Integer>();
	 static int[] array = new int[52];
	
	public static void main(String[] args) {
		suitUp();
		setUp();
		int condition = 0;
		int card1;
		int card2;
		int count=0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		while(map.size()!=0 && map2.size()!=0){
			
			for(int i=0;i<1;i++){
				list.addHead(map.get(count));
				System.out.println("The map says" + map.get(count));
				list2.addHead(map2.get(count));
				System.out.println("The map says" + map2.get(count));
				System.out.println("player 1 card is " + list.getHead());
				System.out.println("player 2 card is " + list2.getHead());
				count++;
				if(list.getHead() == null){
					System.out.println("Adsf");
				}
				if(list.getHead() ==list2.getHead()){
					i--;
				}else if(list.getHead() >list2.getHead()){
					for(int z=0; z <list.size() + list2.size();z++){
						map.put(26 + count ,list.getHead());
						System.out.println("player 1 wins");
						System.out.println(map.get(27));
						list.removeHead();
						count++;
						map.put(26 + count ,list2.getHead());
						list2.removeHead();
						count++;
					}
					
				}else{
					for(int z=0; z <list.size() + list2.size();z++){
						map2.put(26 + count ,list.getHead());
						System.out.println("player 2 wins");
						list.removeHead();
						count++;
						map2.put(26 + count ,list2.getHead());
						list2.removeHead();
						count++;
					}
				}
				
			}
			
			
		}
		
		System.out.println("Game over");
		if(map.size() ==0){
			System.out.println("Player 1 won");
			
		}else{
			System.out.println("Player 2 won");
		}
	}
	
	public static void suitUp(){
		

		int count = 0;
		for(int z=0; z<4;z++){
			for(int i=1;i<14;i++){
				array[count] = i;
				count++;
			}
		}
		
	}
	
	public static void setUp(){
		 Random rand = new Random();
		for(int i=0;i<(52/2);i++){
		   
		    int randomNum = rand.nextInt(52);
		    if(array[randomNum]!=0){
		    	map.put(i,array[randomNum]);
		    	array[randomNum] = 0;
		    }else{
		    	i--;
		    }
		    
		}
		for(int i=0;i<52/2;i++){
		   
		    int randomNum = rand.nextInt(52);
		    if(array[randomNum]!=0){
		    	map2.put(i,array[randomNum]);
		    	array[randomNum] = 0;
		    }else{
		    	i--;
		    }
		    
		}
		
	}
	
	
	

}