import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		int n = list.size() - 1;
		for (int i = 0; i < n; i++) {
			if (list.get(i).getBreed().equals("Pug")) {
				for (int j = n; j > i; j--) {
					if (list.get(n).getBreed().equals("Pug")) {
						n--;
					}
				}
				Dog temp = list.get(i);
				list.set(i, list.get(n));
				list.set(n, temp);


			}
		}
	}
}
