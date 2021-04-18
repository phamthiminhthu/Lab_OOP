package hust.soict.hedspi.aims.media;

import java.util.*;

public class Book extends Media {
    private ArrayList<String> authors;
    private String content;
    private List<String> contentTokens;
    private TreeMap<String, Integer> wordFrequency;


    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
        wordFrequency = new TreeMap<>();
    }

    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("Author existed. Can not add author.");
        } else {
            authors.add(authorName);
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.contentTokens = new ArrayList<>();
        this.processContent();
    }

    public void removeAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) {
            if (authorName.equals(authors.get(i))) {
                authors.remove(authors.get(i));
                return;
            }
        }
        if (!this.authors.remove(authorName))
            System.out.println("Author does not exist. Can not delete ");


    }

    public void processContent() {
        String[] a = this.content.split(" ");
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            this.contentTokens.add(a[i]);
        }
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<String> c = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < this.contentTokens.size() - 1; i++) {
            ++count;
            if (this.contentTokens.get(i) != this.contentTokens.get(i + 1)) {
                c.add(this.contentTokens.get(i));
                b.add(count + 1);
                count = 0;
            }
        }
        for(int i = 0; i < c.size(); i++){
                this.wordFrequency.put(c.get(i),b.get(i));
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", contentLength='" + contentTokens.size() + '\'' +
                ", token_list=" + wordFrequency.keySet() +
                ", wordFrequency=" + wordFrequency +
                '}';
    }
}
