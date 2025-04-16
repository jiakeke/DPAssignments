package visitor.filesystem;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize;

    public SizeCalculatorVisitor() {
        this.totalSize = 0;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // No action needed here, as we handle files in the visit(File file) method
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public double getTotalSize() {
        return totalSize;
    }
}
