package com.aissatech.decode;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NoUTF8Char {	

	public static void main(String[] args) {
		
		CharsetDecoder utf8Decoder = Charset.forName("UTF-8").newDecoder();
		utf8Decoder.onMalformedInput(CodingErrorAction.REPLACE);
		utf8Decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
		utf8Decoder.replaceWith("?");

		// Read stress file
		Path path = Paths.get("no_UTF8.txt");
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteBuffer input = ByteBuffer.wrap(data);

		// UTF-8 decoding
		CharBuffer output = null;
		try {
			output = utf8Decoder.decode(input);
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}

		// Char buffer to string
		String outputString = output.toString();
		String outputStringClean = "";
		
		for(int i = 0; i < outputString.length(); i++){
			
			if( (byte)outputString.charAt(i) == -3){//-3 = ? as byte			
				outputStringClean += "";				
			}else{				
				outputStringClean += outputString.charAt(i);				
			}
		}

		System.out.println("first  ======= " + outputString);
		System.out.println("after  ======= " + outputStringClean);
	}	
}
