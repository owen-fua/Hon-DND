import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Pug" in the list to the back of the list
	// All non-pugs must remain in the same relative order they were in originally
	// and all pugs must also remain in the same relative order they were in originally
	public static void rescuePugs(ArrayList<Dog> list) {
		ArrayList<Dog> temp = new ArrayList<>();
		int i = 0;
		while (i < list.size()) {
			if (list.get(i).getBreed().equals("Pug")) {
				temp.add(list.remove(i)); 
			} else {
				i++;
			}
		}
		for (int j = 0; j < temp.size(); j++) {
			list.add(temp.get(j));
		}
	}

		// int n = list.size() - 1;
		// for (int i = 0; i < n; i++) {
		// if (list.get(i).getBreed().equals("Pug")) {
		// for (int j = n; j > i; j--) {
		// if (list.get(n).getBreed().equals("Pug")) {
		// n--;
		// }
		// }
		// Dog temp = list.get(i);
		// list.set(i, list.get(n));
		// list.set(n, temp);
		// }
		// }
	}

