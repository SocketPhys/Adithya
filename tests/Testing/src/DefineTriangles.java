
public class DefineTriangles {
	public static void main(String[]args){
		int a;
		int b;
		int c;
	}
	
	public static String Sort(int a, int b, int c){
		String sorted ="";
		int [] sides = {a,b,c};
		int n = sides.length;
		if(a==b && a==c)
			return "isosceles";
		for(int i = 0; i < n; i++)
		{
		  for(int j = 0; j < n; j++)
		  {
		    if(i != j)
		      if(sides[i]==sides[j]){
		    	  
		      }
		  }
		}
		return sorted;
	}
}
