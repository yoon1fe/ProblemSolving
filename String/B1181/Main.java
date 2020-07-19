package PS;

import java.io.IOException;
import java.util.*;

class sortByValueFirst implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()) return 1;
        else if(o1.length() < o2.length()) return -1;
        else return o1.compareTo(o2);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < n; i++)
            words.add(input.next());

        ArrayList<String> list = new ArrayList<>(words);
        Collections.sort(list, new sortByValueFirst());

        for (String s : list)
            System.out.println(s);
    }
}