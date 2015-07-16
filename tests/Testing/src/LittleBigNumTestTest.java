
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class LittleBigNumTestTest {

    @Test
    public void zeroTest() {
	LittleBigNum i = new LittleBigNum(20, 10);
	assertEquals(i.toLong(), 0);
    }

    @Test
    public void oneTest() {
	LittleBigNum i = new LittleBigNum(20, 10);
	i.setDigit(0, 1);
	assertEquals(i.toLong(), 1);
    }
    
    @Test
    public void getDigitLarge(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		int z = i.getDigit(1000000000);
    		assert(false);
    	}catch(IndexOutOfBoundsException e){
    		e.getStackTrace();
    		assert(true);
    	}
    	
    }
    

    @Test
    public void getDigitsmall(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		int z = i.getDigit(1);
    		assert(false);
    	}catch(IndexOutOfBoundsException e){
    		e.getStackTrace();
    		assert(true);
    	}
    	
    }
    
    @Test
    public void setDigitSmall(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		i.setDigit(1,1);
    		assert(false);
    	}catch(IllegalArgumentException e){
    		e.getStackTrace();
    		assert(true);
    	}
    }
    
    @Test
    public void setDigitLarge(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		i.setDigit(1,100000000);
    		assert(false);
    	}catch(UnsupportedOperationException e){
    		assert(true);
    	}
    }
    
    @Test
    public void fromLong(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	long x=5;
    	i.fromLong(x);
    }
    
    @Test
    public void equalser(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	LittleBigNum z = new LittleBigNum(20,10);
    	boolean bool = i.equals(z);
    	assertEquals(bool,true);
    }
    
    @Test
    public void toStringer(){
    	try{
    		LittleBigNum i = new LittleBigNum(1,10);
    		if(i.toString().equals("0"));
    			assert false;
    	}catch(IndexOutOfBoundsException e){
    		assert true;
    	}

    }
    
    @Test
    public void hasher(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	LittleBigNum z = new LittleBigNum(20,10);
    	int x = i.hashCode();
    	int y = z.hashCode();
    	assertEquals(x,y);
    }
    
    @Test
    public void outOfBounds(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		i.getDigit(-1);
    		assert(false);
    	}catch(IndexOutOfBoundsException e){
    		assert(true);
    	}
    }
    
    @Test
    public void outOfBoundsSet(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		i.setDigit(-1,5);
    		assert(false);
    	}catch(IndexOutOfBoundsException e){
    		assert(true);
    	}
    	
    }
    
    @Test
    public void charSet(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		i.setDigit(-1,'x');
    		assert(false);
    	
    	}catch(IndexOutOfBoundsException e){
    		assert(true);
    	}
    	
    }
    
    @Test
    public void charGet(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	try{
    		i.getDigit('x');
    		assert(false);
    	}catch(IndexOutOfBoundsException e){
    		assert(true);
    	}
    }
    
    @Test
    public void charConstructor(){
    	
    	try{
    		LittleBigNum i = new LittleBigNum('x',10);
    		assert(false);
    	}catch(IllegalArgumentException e){
    		assert(true);
    	}
    }
    
    @Test
    public void charLong() {
	LittleBigNum i = new LittleBigNum(20, 10);
	assertEquals(i.toLong(),10);
    }
    
    @Test
    public void fromLonger(){
    	LittleBigNum i = new LittleBigNum(20,10);
    	i.fromLong('x');
    }
    
    @Test
    public void constructerBoth(){
    	try{
    		LittleBigNum i = new LittleBigNum('x','y');
    		assert(false);
    	}catch(IllegalArgumentException e){
    		assert(true);
    	}	
    }
    	@Test
        public void constructerSecond(){
        	try{
        		LittleBigNum i = new LittleBigNum(10,'y');
        		assert(false);
        	}catch(IllegalArgumentException e){
        		assert(true);
        	}
    	}
    	
    	@Test
    	public void constructerBig(){
        	try{
        		LittleBigNum i = new LittleBigNum(10000,'y');
        		assert(false);
        	}catch(IllegalArgumentException e){
        		assert(true);
        	}
    	}
    	
    	@Test
    	public void constructerSmall(){
        	try{
        		LittleBigNum i = new LittleBigNum(1,'y');
        		assert(false);
        	}catch(IllegalArgumentException e){
        		assert(true);
        	}
    	}
    	
    	@Test
        public void setDigitChar(){
        	LittleBigNum i = new LittleBigNum('x',10);
        	try{
        		i.setDigit(1,1);
        		assert(false);
        	}catch(IllegalArgumentException e){
        		e.getStackTrace();
        		assert(true);
        	}
        }
    	
    	@Test
        public void setDigit2Char(){
        	LittleBigNum i = new LittleBigNum(10,'y');
        	try{
        		i.setDigit(1,1);
        		assert(false);
        	}catch(IllegalArgumentException e){
        		e.getStackTrace();
        		assert(true);
        	}
        }
    	
    	@Test
    	public void fromLongerAdd(){
    		LittleBigNum i = new LittleBigNum(20,10);
    		try{
    			i.fromLong('x' + 5);
        		assert(false);
        	}catch(IllegalArgumentException e){
        		e.getStackTrace();
        		assert(true);
        	}
        	
    	}
    	
    	@Test
    	public void toLongerAdd(){
    		LittleBigNum i = new LittleBigNum('x' + 5, 10);
    		try{
    			
        		assertEquals(i.toLong(), 0);
        		assert(false);
        	}catch(IllegalArgumentException e){
        		e.getStackTrace();
        		assert(true);
        	}
    	}
    	
    	@Test 
    	public void addition(){
    		LittleBigNum z = new LittleBigNum(1,10);
    		LittleBigNum c = new LittleBigNum(2,10);
    		
    		z.setDigit(0, 5);
    		c.setDigit(0, 1);
    		c.setDigit(1,2);
    		LittleBigNum answer = LittleBigNum.addition(z,c);
    		
    		for(int i=0;i<answer.length;i++){
    			
    			
    		}
    		
    	}
    	
    	@Test
    	public void multiplication(){
    		LittleBigNum z = new LittleBigNum(1,10);
    		LittleBigNum c = new LittleBigNum(2,10);
    		
    		z.setDigit(0, 5);
    		c.setDigit(0, 1);
    		c.setDigit(1,9);
    		LittleBigNum answer = LittleBigNum.multiplication(z,c);
    		for(int i=0;i<answer.length;i++){
    			System.out.print(answer.getDigit(i));
    			
    		}
    	}
    
    	
    
    

}
