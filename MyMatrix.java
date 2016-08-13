package com.alpesh.matrixworld;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class MyMatrix {	
	final int WIDTH=120,HEIGHT=10;
	char[][] buffer;
	int[] rank;
	
	public MyMatrix() {

		buffer = new char[HEIGHT][WIDTH];
		rank = new int[WIDTH];
				
		for(int i=0; i<HEIGHT; i++)
			for(int j=0; j<WIDTH; j++)
				buffer[i][j] = ' ';

		for(int j=0; j<WIDTH; j++)
			rank[j] = 0;

	}

	public void compute(){
		
		//move chars down line by line
		for(int i=HEIGHT-1; i>0; i--){
			for(int j=0; j<WIDTH; j++)
				buffer[i][j] = buffer[i-1][j];
		}
	
		//add new line
		for(int j=0; j<WIDTH; j++){
			buffer[0][j] = getChar(j);
			if(buffer[0][j]==' ')
				rank[j] = 0;
			else
				rank[j]++;
				
		}
		
	}

	public char getChar(int p){
	
		Random rand = new Random();
		
		//select a random integer
		// which points to a char between A-Z
		char n = (char)(rand.nextInt(25)+65);
		
		// randomly decide
		// whether to return the character or
		// or just return a blank space
		// so as to create character density effect
		return rank[p]>0?(rand.nextInt(100)<70? n:' '):(rand.nextInt(100)<1? n:' ');
	}
	
	public void print(){
			
		//print each row of buffer as a line
		for(int i=0; i<HEIGHT; i++)
			System.out.println(getLine(i));
		System.out.flush();
	}
	
	public String getLine(int row){
		
		String result="";
		
		for(int i=0; i<WIDTH; i++)
			result += buffer[row][i];
		
		return result;
	}
	
	public static void main(String[] args) throws InterruptedException{

	MyMatrix mat = new MyMatrix();
	
	//keep running in loop till infinity 
	//first need to compute
	//then printout the result 
		do {
			mat.compute();
			mat.print();
			Thread.sleep(100);
		} while (true);	
	
	}
}
