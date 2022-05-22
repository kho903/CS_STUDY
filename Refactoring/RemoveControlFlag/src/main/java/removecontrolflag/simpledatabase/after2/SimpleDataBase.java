package removecontrolflag.simpledatabase.after2;

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
		String line;
		while (true) {
			line = br.readLine();
			if (line == null) {
				break;
			}
			int equalIndex = line.indexOf('=');
			if (equalIndex > 0) {
				String key = line.substring(0, equalIndex);
				String value = line.substring(equalIndex + 1, line.length());
				map.put(key, value);
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
