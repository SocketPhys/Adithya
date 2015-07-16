public class square{
	public static void main(String[]args){
		for(int i=0;i<5;i++){ //first for loop for 5 rows
			for(int j=0;j<i/2;j++){ //second for loop for numbers on
						//each line
				int number =( j*i)/2;
				System.out.print(number + " ");
			
			}
			for(int z=0;z<i/2;z++){//third for loop for after normal
				for(int a=0;a<i/2;a++){ //nested for loop 
							//for random spaces
					System.out.print(" ");
				}
				System.out.print(z);
				System.out.println(i);
			}
			
		}
	}
}
