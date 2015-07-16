
public class CacheSpeed {
	public static void main(String[]args){
		for(int size = 1; size<1024*1024; size*=2){
			int[]data = new int[size];

			long start_time = System.nanoTime();
			int j=0;
			for(int i=0; i < 1000000000;i++){
				data[j] +=i;
				j++;
				j&=size-1;
			}
			long end_time = System.nanoTime();
			System.out.println("" + (end_time - start_time));
		}
	}
}
