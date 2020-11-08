import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    PrintWriter writer;

    public MyFileVisitor(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (dir.getFileName().equals(Paths.get("D:\\IJ проекты").relativize(dir))) {
            writer.write("#" + dir.getFileName() + "\n");
        }
        return super.preVisitDirectory(dir, attrs);
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.toString().endsWith(".java")){
            writer.write("###" + file.getFileName() + "\n");
            writer.write("```java\n");
            List<String> lines = Files.readAllLines(file);
            for (String s : lines){
            writer.write(s);
            writer.write("\n");
            writer.flush();
            }
            writer.write("```\n");
        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("D:\\IJ проекты"),
                new MyFileVisitor(new PrintWriter("D:\\IJ проекты\\PR_17-18\\result.md")));
    }
}