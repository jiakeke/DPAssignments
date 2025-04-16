package visitor.filesystem;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 10.0);
        File file2 = new File("file2.txt", 20.0);
        File file3 = new File("file3.txt", 30.0);
        File file4 = new File("file4.txt", 40.0);
        Directory directory1 = new Directory("dir1", new FileSystemElement[]{file1, file2});
        Directory directory2 = new Directory("dir2", new FileSystemElement[]{directory1, file3, file4});

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        directory2.accept(sizeCalculatorVisitor);
        System.out.println("Total size: " + sizeCalculatorVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor("file2.txt");
        directory2.accept(searchVisitor);
        System.out.println("Found file: " + searchVisitor.getFoundFile());
    }
}
