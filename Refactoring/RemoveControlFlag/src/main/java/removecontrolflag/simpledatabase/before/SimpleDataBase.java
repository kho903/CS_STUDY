package removecontrolflag.simpledatabase.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleDataBase {
	private Map<String, String> map = new HashMap<>();

	public SimpleDataBase(Reader reader) throws IOException {
		BufferedReader br = new BufferedReader(reader);
		boolean flag = false;
		String temp;
		while (!flag) {
			temp = br.readLine();
			if (temp == null) {
				flag = true;
			} else {
				boolean flag2 = true;
				StringBuffer sb1 = new StringBuffer();
				StringBuffer sb2 = new StringBuffer();

				for (int i = 0; i < temp.length(); i++) {
					char temp2 = temp.charAt(i);
					if (flag2) {
						if (temp2 == '=') {
							flag2 = false;
						} else {
							sb1.append(temp2);
						}
					} else {
						sb2.append(temp2);
					}
				}

				String s1 = sb1.toString();
				String s2 = sb2.toString();
				map.put(s1, s2);
			}
		}
	}

	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}

	public String getValue(String key) {
		return map.get(key);
	}
}
