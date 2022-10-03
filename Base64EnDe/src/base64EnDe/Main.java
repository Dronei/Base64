package base64EnDe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		boolean xbrun = true;
		 
		
		while(xbrun == true) {	
			String sbaseout = "";
			System.out.println("Enter String for Convertion: ");
			System.out.println("or enter exit for close");
			System.out.println("Do not enter spezial character!");
			
			try {
				input = BR.readLine();
				
				if(input.equals("exit")) {
					xbrun = false;
				}
				
				else {
					char[] chars = input.toCharArray();
					String binary = "";
					String hex = "";
					String binaryfromhex = "";

					//Hex Table
					HashMap<Character, String> hashMap
		            = new HashMap<Character, String>();
		 
			        // storing the key value pairs
			        hashMap.put('0', "0000");
			        hashMap.put('1', "0001");
			        hashMap.put('2', "0010");
			        hashMap.put('3', "0011");
			        hashMap.put('4', "0100");
			        hashMap.put('5', "0101");
			        hashMap.put('6', "0110");
			        hashMap.put('7', "0111");
			        hashMap.put('8', "1000");
			        hashMap.put('9', "1001");
			        hashMap.put('A', "1010");
			        hashMap.put('B', "1011");
			        hashMap.put('C', "1100");
			        hashMap.put('D', "1101");
			        hashMap.put('E', "1110");
			        hashMap.put('F', "1111");
					
					//Convert String to Hex and Binary
					for(char c : chars) {
												
						hex = Integer.toHexString(c);
						
						hex = hex.toUpperCase();
						char[] hexchar = hex.toCharArray();
						
						for(char c1 : hexchar) {
							binaryfromhex += hashMap.get(c1);
						}
						
						binary += binaryfromhex;
						binaryfromhex = "";
						
					}
					
					System.out.println(binary);
					
					//Check Binary length
					int iadded = 0;
					
					while(binary.length() % 3 > 0) {
						//Add Zero Spaces
						for(int i = 0; i < 8; i++){
							binary += 0;
						}	
						iadded++;
					}
									
					//Split String to 6 Bits
					int strArrLength = binary.length() / 6;
					String[] strArrSplitt = new String[strArrLength];
					int strArrIter = 0;
					
					int searchstart = 0;
					int searchend = 6;
					
					while(searchend <= binary.length()) {
						strArrSplitt[strArrIter] = binary.substring(searchstart,searchend);
						
						searchstart = searchend;
						searchend = searchend + 6;
						strArrIter++;
					}
					
					//Convert 6 Bit to dezimal
					int sum = 0;
					
					for(int i2 = 0; i2 < strArrSplitt.length; i2++) {
						
						int factor = 0;
						String str = strArrSplitt[i2];
						
						if(strArrSplitt[i2].equals("000000")) {
							if(i2 == strArrSplitt.length) {
								
							}
							if(i2 == strArrSplitt.length - 1) {
								
							}
						}
						
						else {
				        // conversion from String object to StringBuffer
				        StringBuffer sbr = new StringBuffer(str);
				        // To reverse the string
				        sbr.reverse();
				        
				        char[] chars1 = sbr.toString().toCharArray();
				        
							for(char c : chars1) {
								if(c == '1') {
									sum += Math.pow(2, factor);
								}
								else {
									sum += 0;
								}
								factor++;
							}
							
							//Convert Base64 to String
							String strArrBase[] = {"A","B","C","D","E","F","G",
													"H","I","J","K","L","M","N",
													"O","P","Q","R","S","T","U","V",
													"W","X","Y","Z","a","b","c","d", 
													"e","f","g","h","i","j","k","l",
													"m","n","o","p","q","r","s","t",
													"u","v","w","x","y","z","0","1",
													"2","3","4","5","6","7","8","9",
													"+","/"};
							
							sbaseout += strArrBase[sum];
						 	
							sum = 0;
						}
					}
					
					//Add = when added Zero Spaces
					for(int i3 = 0; i3 < iadded; i3++) {
						sbaseout += "=";
					}
					System.out.println(sbaseout);
					}
				}
			 catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}