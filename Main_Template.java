/*
 * PDPM IIITDM Jabalpur
 * Asutosh Rana
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{
    static long MOD = 1000000007;
    static Set<Integer> Primes;
    public static void main (String[] args) throws java.lang.Exception
	{
		//InputReader in=new InputReader(new FileInputStream("C:\\Users\\Asutosh\\Desktop\\in.txt"));
    	InputReader in = new InputReader(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out=new PrintWriter("C:\\Users\\Asutosh\\Desktop\\out.txt","UTF-8");
		PrintWriter out = new PrintWriter(System.out);
        int t = in.readInt();
        while(t-->0){
        	int N = in.readInt();
        	long[] A = new long[N];
        	in.readLong(A);
        	long min = Long.MAX_VALUE;
        	for(int i=0;i<=10000;i++){
        		min = Math.min(min, check(A,i));
        	}
        	out.println(min);
        }
		out.flush();
        out.close();
	}
    
    static long check(long[] A,long k){
    	int count = 0;
    	for(int i=0;i<A.length;i++){
    		long p = A[i];
    		while(p>k){
    			p/=2;count++;
    		}
    		count+=k-p;
    	}
    	return count;
    }
}
 
class InputReader{
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	
	public InputReader(InputStream stream){this.stream = stream;}
	public int read(){
		if (numChars==-1) throw new InputMismatchException();
		if (curChar >= numChars){
			curChar = 0;
			try {numChars = stream.read(buf);}
			catch (IOException e){throw new InputMismatchException();}
			if(numChars <= 0) return -1;
		}
		return buf[curChar++];
	}
 
	public int readInt(){
		int c = read();
		while(isSpaceChar(c)) c = read();
		int sgn = 1;
		if (c == '-') {sgn = -1;c = read();}
		int res = 0;
		do {
			if(c<'0'||c>'9') throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		while (!isSpaceChar(c)); return res * sgn;
	}
	
	public void readInt(int[] A){
		for(int i=0;i<A.length;i++)
			A[i] = readInt();
	}
	
	public long readLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
        }
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
        }
		while (!isSpaceChar(c));
            return res * sgn;
    }
	
	public void readLong(long[] A){
		for(int i=0;i<A.length;i++)
			A[i] = readLong();
	}
	
	public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
        }
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E')
				return res * Math.pow(10, readInt());
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
        }
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				m /= 10;
				res += (c - '0') * m;
				c = read();
            }
        }
		return res * sgn;
    }
	
	public char[] readCharA(){
		return readString().toCharArray();
	}
	
	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
	public String next() {
		return readString();
	}
	
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
	
}
