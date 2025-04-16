package visitor.filesystem;

public class SearchVisitor implements FileSystemVisitor {
    private String searchName;
    private File foundFile;

    public SearchVisitor(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(searchName)) {
            foundFile = file;
        }
    }

    @Override
    public void visit(Directory directory) {
        if (foundFile != null) {
            return; // Stop searching if the file has already been found
        }
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public File getFoundFile() {
        return foundFile;
    }
}
