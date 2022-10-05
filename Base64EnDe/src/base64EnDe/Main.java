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
		
		HashMap<Character, String> hashMapBase = new HashMap<Character, String>();

	    // storing the key value pairs
		hashMapBase.put('A', "000000");
		hashMapBase.put('B', "000001");
		hashMapBase.put('C', "000010");
		hashMapBase.put('D', "000011");
		hashMapBase.put('E', "000100");
		hashMapBase.put('F', "000101");
	    hashMapBase.put('G', "000110");
	    hashMapBase.put('H', "000111");
	    hashMapBase.put('I', "001000");
	    hashMapBase.put('J', "001001");
	    hashMapBase.put('K', "001010");
	    hashMapBase.put('L', "001011");
	    hashMapBase.put('M', "001100");
	    hashMapBase.put('N', "001101");
	    hashMapBase.put('O', "001110");
	    hashMapBase.put('P', "001111");
	    hashMapBase.put('Q', "010000");
	    hashMapBase.put('R', "010001");
	    hashMapBase.put('S', "010010");
	    hashMapBase.put('T', "010011");
	    hashMapBase.put('U', "010100");
	    hashMapBase.put('V', "010101");
	    hashMapBase.put('W', "010110");
	    hashMapBase.put('X', "010111");
	    hashMapBase.put('Y', "011000");
	    hashMapBase.put('Z', "011001");
	    hashMapBase.put('a', "011010");
	    hashMapBase.put('b', "011011");
	    hashMapBase.put('c', "011100");
	    hashMapBase.put('d', "011101");
	    hashMapBase.put('e', "010100");
	    hashMapBase.put('f', "011111");
	    hashMapBase.put('g', "100000");
	    hashMapBase.put('h', "100001");
	    hashMapBase.put('i', "100010");
	    hashMapBase.put('j', "100011");
	    hashMapBase.put('k', "100100");
	    hashMapBase.put('l', "100101");
	    hashMapBase.put('m', "100110");
	    hashMapBase.put('n', "100111");
	    hashMapBase.put('o', "101000");
	    hashMapBase.put('p', "101001");
	    hashMapBase.put('q', "101010");
	    hashMapBase.put('r', "101011");
	    hashMapBase.put('s', "101100");
	    hashMapBase.put('t', "101101");
	    hashMapBase.put('u', "101110");
	    hashMapBase.put('v', "101111");
	    hashMapBase.put('w', "110000");
	    hashMapBase.put('x', "110001");
	    hashMapBase.put('y', "110010");
	    hashMapBase.put('z', "110011");
	    hashMapBase.put('0', "110100");
	    hashMapBase.put('1', "110101");
	    hashMapBase.put('2', "110110");
	    hashMapBase.put('3', "110111");
	    hashMapBase.put('4', "111000");
	    hashMapBase.put('5', "111001");
	    hashMapBase.put('6', "111010");
	    hashMapBase.put('7', "111011");
	    hashMapBase.put('8', "111100");
	    hashMapBase.put('9', "111101");
	    hashMapBase.put('+', "111110");
	    hashMapBase.put('/', "111111");
	    hashMapBase.put('=', "");
		
		//Hex Table
		HashMap<Character, String> hashMapHex = new HashMap<Character, String>();

	    // storing the key value pairs
		hashMapHex.put('0', "0000");
		hashMapHex.put('1', "0001");
		hashMapHex.put('2', "0010");
		hashMapHex.put('3', "0011");
		hashMapHex.put('4', "0100");
		hashMapHex.put('5', "0101");
		hashMapHex.put('6', "0110");
		hashMapHex.put('7', "0111");
		hashMapHex.put('8', "1000");
		hashMapHex.put('9', "1001");
		hashMapHex.put('A', "1010");
		hashMapHex.put('B', "1011");
		hashMapHex.put('C', "1100");
		hashMapHex.put('D', "1101");
		hashMapHex.put('E', "1110");
		hashMapHex.put('F', "1111");
		
		
		while(xbrun == true) {	
			System.out.println("Enter 1 for Encoding or 2 for Decoding, or enter exit for close.");
			
			
			try {
				input = "";
				input = BR.readLine();
				
				switch(input) {
				case "exit": xbrun = false; break;
				case "": xbrun = false; break;
				case "1": System.out.println("Enter String for Encoding: "); input = ""; input = BR.readLine(); System.out.println(Encode(input, hashMapHex));System.out.println("\n"); break;
				case "2": System.out.println("Enter String for Decoding: "); input = ""; input = BR.readLine(); System.out.println(Decode(input, hashMapBase));System.out.println("\n"); break;
				default: System.out.println("Ivalid Input!");
				}
			}
			 catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
public static String Encode(String input, HashMap<Character, String> hashMap) {
	int iadded = 0;
	char[] chars = input.toCharArray();
	String binary = "";
	String hex = "";
	String binaryfromhex = "";
	String sbaseout = "";
	String strArrBase[] = {"A","B","C","D","E","F","G",
			"H","I","J","K","L","M","N",
			"O","P","Q","R","S","T","U","V",
			"W","X","Y","Z","a","b","c","d", 
			"e","f","g","h","i","j","k","l",
			"m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z","0","1",
			"2","3","4","5","6","7","8","9",
			"+","/"};

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
	
	//Check Binary length
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
	
	//Convert 6 Bit to decimal
	int sum = 0;
	
	//Remove added 0-Bytes Elements
	int iremove = iadded;
	
	while(iremove != 0) {
		int iarrLen = strArrSplitt.length;
		
		strArrSplitt[iarrLen - iremove] = "";
		
		iremove--;
	}
	
	for(int i2 = 0; i2 < strArrSplitt.length; i2++) {
		
		int factor = 0;
		String str = strArrSplitt[i2];
		
		if(str.equals("")) {
			
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
			sbaseout += strArrBase[sum];
		 	
			sum = 0;
			}
		}
	
	//Add = when added Zero Spaces
	for(int i3 = 0; i3 < iadded; i3++) {
		sbaseout += "=";
	}
		return sbaseout;
	}

public static String Decode(String input, HashMap<Character, String> hashMapBase) {
	char chararr[] = input.toCharArray();
	//Base64 Table
	    String binaryfrombase = "";
	    String out = "";
	    
	    //Total String of Bytes
	    for(char c : chararr) {
	    	binaryfrombase += hashMapBase.get(c);
	    }
	    
	    //Convert Byte String to Text String   
	    int sArrLength = binaryfrombase.length() / 8;
	    
	    String sArr[] = new String[sArrLength];
	    int iserachstart = 0;
	    int iserachstop = 8;
	    
	    for(int i = 0; i < sArr.length; i++) {
	    	sArr[i] = binaryfrombase.substring(iserachstart, iserachstop);
	    	
	    	iserachstart = iserachstop;
		    iserachstop += 8;
		    
		    int iparse = Integer.parseInt(sArr[i], 2);

		    char c=(char)iparse;
		    
		    out += c;
	    }
	    return out;
}
}



