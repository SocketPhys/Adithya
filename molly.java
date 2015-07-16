public class molly{
	public static void main(String[]args){
		int number = 0;
		for(int i=0;i<5;i++){
			if(i%2==0){
                                         number = 1;
                                }else{  
                                        number = 0;
                                }


			for(int j=0;j<5;j++){
				if(number==1){
					if(number==1){
						System.out.print(1);
						number=0;
					}else{
						System.out.print(0);
						number=1;
					}
				}else{
					 if(number==1){
                                                System.out.print(1);
                                                number=0;
						
                                       } else{
                                                System.out.print(0);
                                                number=1;
					}
				}	
			
				
			}
			System.out.print("\n");
		}
	}

}
