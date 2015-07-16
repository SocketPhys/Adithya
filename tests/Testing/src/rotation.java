
public class superreversed {

	public static void main(String[] args) {
		String answer = reverse("12345",4);
		System.out.println(answer);
	}
	public static String reverse(String x,int start){
		
		if(x==null)
			return null;
		try{
			start = start% x.length();
		
		String array = "";
		String second ="";
		for(int y=0;y<=start-1;y++){
			array = array + x.charAt(y);
		}
		for(int z = start;z<x.length();z++){
			second = second + x.charAt(z);
		}
		System.out.println(array);

		x = second + array;
		return x;
	}catch (ArithmeticException ae) {
        return "";
    }
	}
}
