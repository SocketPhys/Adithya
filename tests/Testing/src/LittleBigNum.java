public class LittleBigNum {
    
    public int[] array;
    public int length;
    public final int base;
      
    
    // initial value is zero
    public LittleBigNum(int num_of_digits, int base) {
        //base has to be >=0
        //num_of_digits has to be int and >0
        
        if((Integer)num_of_digits == null || (Integer)base==null) throw new IllegalArgumentException("your base or num_of_digits are null");
        if(num_of_digits < 0) throw new NegativeArraySizeException("Array size cannot be negative");
        if(base<=1) throw new IllegalArgumentException("your base is less than or equal to 1"); 
        
        this.array = new int[num_of_digits];
        this.base = base;
        this.length = num_of_digits;
    }
    
    
    public int getDigit(int index) {
        // You should throw IndexOutOfBoundsException if the index is too large
        // (or too small) 
        if(index<0 || index>=array.length) throw new ArrayIndexOutOfBoundsException("index out of bounds");
        else return array[index];
    }
   
    
    public void setDigit(int index, int value) {
        // You should throw IllegalArgumentException if value is too large 
        // (or too small) for a digit.
        if(index<0 || index>=array.length) throw new ArrayIndexOutOfBoundsException("index out of bounds");
        if(value<0 || value>= base) throw new UnsupportedOperationException("value" + value);
        else  array[index] = value;    
    }
    
    
    // convert value to a long (if it fits)
    public long toLong() {
        long temp = 0;
        for(int i=0; i<array.length; i++){
            if(temp<Long.MIN_VALUE || temp> Long.MAX_VALUE) throw new UnsupportedOperationException("That numer is not within the ranges of a Long");
            temp+= Math.pow(base,i)*(int)array[i];
        }
        return temp;     
    }
    
    
    // convert value from a long (if current value is zero)
    public void fromLong(long el) {
        int temp=0;
        int i=0;
        while(base<el){
            temp= (int)(el)%base;
            array[i] = temp;        
            i++;
            el=(int)(el/base);          
        }
        array[i]=(int)el;
    }
    
    
    public boolean equals(Object o) {
        if(o instanceof LittleBigNum){
            LittleBigNum other = (LittleBigNum)o;
            
            boolean sameBase = false;
            boolean sameValue= true;
            
            // checsk bases
            if(other.base==this.base) sameBase=true;
            
            // find the shorter length array
            int length =0;
            if(array.length < other.array.length) length = array.length;
            else length = other.array.length;
            
            for(int i=0; i<length; i++){
                if(array[i]!=other.array[i]) sameValue= false;
                
            }
            
            if(sameBase && sameValue) return true;
            else return false;
        }
        else {throw new IllegalArgumentException("Input is not an instance of littlebignum");}     
    }
    
    
    public int hashCode() {
        return (int) (this.toLong()+this.base);
        //throw new UnsupportedOperationException();
    }
    
    
    public String toString() { 
        String returnFinal = "";
        int start = array.length-1;
        if(array[start]==0){
            while(array[start]==0 && start>0){
                start--;         
            }
        }
        if(base<=36){
            for(int i=start; i>=0; i--){
                if((array[i])<10){
                    returnFinal+=Integer.toString(array[i]);
                }
                else if (array[i]<37){
                    int charNum = array[i]-10;
                    char temp = (char)('A' + charNum);
                    returnFinal+=temp;
                }
            }
        }
        else{
            for(int i=start; i>=0; i--){
                returnFinal+=(Integer.toString(array[i])+":");
            }
            returnFinal = returnFinal.substring(0,returnFinal.length()-1);
        }
        return returnFinal;
        //throw new UnsupportedOperationException();
    }
    
    public static LittleBigNum addition(LittleBigNum a, LittleBigNum b){
    	int stop;
    	boolean enda = false;
    	boolean endb = false;
    	int answer = 0;
        if(a.base != b.base){
            throw new IllegalArgumentException("LittleBigNums must have the same base");
        }
        LittleBigNum sum = new LittleBigNum(a.length+1, a.base);
        if(a.length >b.length){
        	stop= a.length;
        	endb = true;
        }else{
        	stop = b.length;
        	enda = true;
        }
        for(int i = 0; i < a.array.length / 2; i++)
        {
            int temp = a.array[i];
            a.array[i] = a.array[a.array.length - i - 1];
            a.array[a.array.length - i - 1] = temp;
        }
        for(int i = 0; i < b.array.length / 2; i++)
        {
            int temp = b.array[i];
            b.array[i] = b.array[b.array.length - i - 1];
            b.array[b.array.length - i - 1] = temp;
        }
      
        for(int i=0;i<stop;i++){
        	
        	if(i!=a.length){
        		
        	 	answer = a.array[i] + b.array[i];
        	}else if(enda==true && i>=a.length){
        		answer = 0 + b.array[i];
        	}else if(endb==true && i>=b.length){
        		answer = 0 + a.array[i];
        	}
        	
        	if(answer>a.base){
        		sum.setDigit(i+1,(answer+a.base));
        	}
        	sum.setDigit(i,sum.array[i] +answer);
        }
        for(int i = 0; i < sum.array.length / 2; i++)
        {
            int temp = sum.array[i];
            sum.array[i] = sum.array[sum.array.length - i - 1];
            sum.array[sum.array.length - i - 1] = temp;
        }
        return sum;
    }
    
    public static LittleBigNum multiplication(LittleBigNum a, LittleBigNum b){
    	int stop;
    	if(a.array[0] * b.array[0]>a.base){
    		stop = a.length + b.length;
    	}else{
    		stop = a.length + b.length - 1;
    	}
    	System.out.println("stop is " + stop);
		LittleBigNum sum = new LittleBigNum(stop,a.base);
		int carry = 0;
		
		for(int i=0; i<b.length;i++){
			
			for(int z=0;z<a.length;z++){
				System.out.println("set is " + (sum.getDigit(z) ));
				System.out.println("arraya" + a.array[a.length-1 -z ]);
				System.out.println("arrayb" + b.array[b.length-1 -i ]);

				int answer = (a.array[a.length-1 -z ] * b.array[b.length-1-i]);
				System.out.println("answer before" + answer + "base" + a.base);
				carry=0;
				if(answer>=   sum.base){
					
					carry = answer/10;
					answer = answer%10;
				}
				System.out.println("answer after" + answer + "base" + a.base);
				System.out.println("carry after" + carry + "base" + a.base);
				System.out.println("set is " + (sum.getDigit(z) ));

				sum.setDigit((z), sum.getDigit(z) + answer ) ;
				if(z!=a.length){
					System.out.println("carry before" + carry);
					System.out.println("sum get digit " + sum.getDigit(z+1));
					sum.setDigit((z+1),  carry) ;
					System.out.println("carry after 2nd" + carry);
					System.out.println("sum get digit " + sum.getDigit(z+1));
					
				}
			}
		}
    	return sum;
    }
}
	
	
	

	
