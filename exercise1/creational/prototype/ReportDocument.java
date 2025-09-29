package exercise1.creational.prototype;

public class ReportDocument implements DocumentPrototype {
    private String title;
    private String author;
    private final String font;
    private final String alignment;

    public ReportDocument(String title, String author, String font, String alignment) {
        this.title = title;
        this.author = author;
        this.font = font;
        this.alignment = alignment;
    }

    @Override
    public ReportDocument clone() {
        return new ReportDocument(this.title, this.author, this.font, this.alignment);
    }

    public ReportDocument cloneWith(String title, String author) {
        return new ReportDocument(title, author, this.font, this.alignment);
    }

    @Override
    public void showDetails() {
        System.out.println("Report [Title: " + title + ", Author: " + author +
                ", Font: " + font + ", Alignment: " + alignment + "]");
    }
}
