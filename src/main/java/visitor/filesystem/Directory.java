package visitor.filesystem;

public class Directory implements FileSystemElement {
    private String name;
    private FileSystemElement[] elements;

    public Directory(String name, FileSystemElement[] elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public FileSystemElement[] getElements() {
        return elements;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);

    }
}
