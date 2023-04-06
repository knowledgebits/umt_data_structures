import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        LinkedList<String> words = readWordsFromFile("example.txt");
        LinkedList<Frequency> frequencies = countWordFrequencies(words);
        sortFrequenciesDescending(frequencies);
        printFrequencies(frequencies);
    }

    public static LinkedList<String> readWordsFromFile(String filename) throws IOException {
        LinkedList<String> words = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            for (String token : tokens) {
            	String cleanToken = token.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!cleanToken.isEmpty()) {
                    words.add(cleanToken);
                }
           }
        }
        reader.close();
        return words;
    }

    public static LinkedList<Frequency> countWordFrequencies(LinkedList<String> words) {
        LinkedList<Frequency> frequencies = new LinkedList<>();
        for (String word : words) {
            Frequency freq = findFrequency(frequencies, word);
            if (freq != null) {
                freq.count++;
            } else {
                frequencies.add(new Frequency(word, 1));
            }
        }
        return frequencies;
    }

    public static void sortFrequenciesDescending(LinkedList<Frequency> frequencies) {
        Collections.sort(frequencies, Collections.reverseOrder());
    }

    public static void printFrequencies(LinkedList<Frequency> frequencies) {
        for (Frequency freq : frequencies) {
            System.out.println(freq.word + ": " + freq.count);
        }
    }

    public static Frequency findFrequency(LinkedList<Frequency> frequencies, String word) {
        for (Frequency freq : frequencies) {
            if (freq.word.equals(word)) {
                return freq;
            }
        }
        return null;
    }

    public static class Frequency implements Comparable<Frequency> {
        public String word;
        public int count;

        public Frequency(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Frequency other) {
            return Integer.compare(count, other.count);
        }
    }
}
