package visitor.filesystem;

public class File implements FileSystemElement {
    private String name;
    private Double size;

    public File(String name, Double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Double getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
