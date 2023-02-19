
public class Word implements Comparable<Word> {

    public String word;
    public int count;

    public Word(String w) {
        word = w;
        count = 1;
    }

    public boolean equals(Object obj) {
        Word other = (Word) obj;
        return word.equals(other.word);
    }

    public int compareTo(Word obj) {
        return word.compareTo(obj.word);
    }

    public String toString() {
        return word + "\t" + count;
    }
}
