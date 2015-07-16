
public class String_control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = reverse("Hello world",0,4);
		System.out.println(answer);

	}
	
	public static String reverse(String x,int start,int end){
		String reversed = "";
		
		for(int z=end;z>=start;z--){
			reversed+= x.charAt(z);
		}
		return reversed;
	}

}
