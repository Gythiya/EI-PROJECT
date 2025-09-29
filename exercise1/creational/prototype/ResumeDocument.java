package exercise1.creational.prototype;

public class ResumeDocument implements DocumentPrototype {
    private String name;
    private String skills;
    private final String font;
    private final String alignment;

    public ResumeDocument(String name, String skills, String font, String alignment) {
        this.name = name;
        this.skills = skills;
        this.font = font;
        this.alignment = alignment;
    }

    @Override
    public ResumeDocument clone() {
        return new ResumeDocument(this.name, this.skills, this.font, this.alignment);
    }

    public ResumeDocument cloneWith(String name, String skills) {
        return new ResumeDocument(name, skills, this.font, this.alignment);
    }

    @Override
    public void showDetails() {
        System.out.println("Resume [Name: " + name + ", Skills: " + skills +
                ", Font: " + font + ", Alignment: " + alignment + "]");
    }
}
