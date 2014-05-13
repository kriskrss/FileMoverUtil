import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class ClusterTest {
	public static void main(String[] args) throws Exception {
		File f = new File("/home/sai/Desktop/work/cluster-result.txt");
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = br.readLine();
		String[] parts = line.split("\t");
		while (line != null) {
			parts = line.split("\t");
			if (map.containsKey(parts[0])) {
				ArrayList<String> temp = map.get(parts[0]);
				temp.add(parts[1]);
				map.put(parts[0], temp);
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(parts[1]);
				map.put(parts[0], temp);
			}
			line = br.readLine();

		}
		Iterator<String> it = map.keySet().iterator();
		int total = 0;
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("Cluster ID: " + key + map.get(key));
			total += map.get(key).size();
		}
		System.out.println("Total Number of documents Classified: " + total);
	}
}
