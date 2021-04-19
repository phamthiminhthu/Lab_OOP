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
        Iterator<String> iterator = this.contentTokens.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if(this.wordFrequency.containsKey(key)){
                this.wordFrequency.put(key, this.wordFrequency.get(key) + 1);
            }else{
                this.wordFrequency.put(key, 1);
            }
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
