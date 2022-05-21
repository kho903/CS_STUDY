package designpattern.structural.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
	private char charName;
	private String fontData;

	public BigChar(char charName) {
		this.charName = charName;
		try {
			BufferedReader reader = new BufferedReader(
				new FileReader("big" + charName + ".txt")
			);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			reader.close();
			this.fontData = sb.toString();
		} catch (IOException e) {
			this.fontData = charName + "?";
		}
	}

	// 큰 문자를 표시한다.
	public void print() {
		System.out.println(fontData);
	}
}
