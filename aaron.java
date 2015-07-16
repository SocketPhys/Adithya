public class aaron{
	public static void main(String[]args){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				int number = i-j;
				if(number<0)
					number *=-1;
				System.out.print(number);
			}
			System.out.print("\n");
		}
	}
}
