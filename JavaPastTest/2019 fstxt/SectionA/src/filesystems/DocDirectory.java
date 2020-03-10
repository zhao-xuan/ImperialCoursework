package filesystems;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DocDirectory extends DocFile {
    private Set<DocFile> directory;
    /**
     * Construct a file with the given name.
     *
     * @param name The name of the file.
     */
    private DocDirectory(String name, Set<DocFile> dir) {
        super(name);
        this.directory = dir;
    }

    public DocDirectory(String name) {
        super(name);
        this.directory = new HashSet<>();
    }

    @Override
    public int getSize() {
        return getName().length();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isDataFile() {
        return false;
    }

    @Override
    public DocDirectory asDirectory() {
        return this;
    }

    @Override
    public DocDataFile asDataFile() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DocFile duplicate() {
        Set<DocFile> newDir = directory.stream()
                .map(i -> i.duplicate())
                .collect(Collectors.toSet());
        return new DocDirectory(getName(), newDir);
    }

    public boolean containsFile(String name) {
        return directory.stream()
                .map(i -> i.getName().equals(name))
                .reduce(Boolean::logicalOr).orElse(false);
    }

    public Set<DocFile> getAllFiles() {
        return directory;
    }

    public Set<DocDirectory> getDirectories() {
        return directory.stream()
                .filter(DocFile::isDirectory)
                .map(i -> (DocDirectory) i)
                .collect(Collectors.toSet());
    }

    public Set<DocDataFile> getDataFiles() {
        return directory.stream()
                .filter(DocFile::isDataFile)
                .map(i -> (DocDataFile) i)
                .collect(Collectors.toSet());
    }

    public void addFile(DocFile file) {
        if (containsFile(file.getName())) {
            throw new IllegalArgumentException();
        }
        directory.add(file);
    }

    public boolean removeFile(String name) {
        for (DocFile f : directory) {
            if (f.getName().equals(name)) {
                return directory.remove(f);
            }
        }
        return false;
    }

    public DocFile getFile(String filename) {
        return directory.stream()
                .filter(i -> i.getName().equals(filename))
                .findAny()
                .orElse(null);
    }
}
