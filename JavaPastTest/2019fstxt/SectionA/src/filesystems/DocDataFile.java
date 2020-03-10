package filesystems;

import java.util.Arrays;

public final class DocDataFile extends DocFile {
    private byte[] content;

    /**
     * Construct a file with the given name.
     *
     * @param name The name of the file.
     */
    public DocDataFile(String name, byte[] content) {
        super(name);
        this.content = content;
    }

    @Override
    public int getSize() {
        return getName().length() + content.length;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isDataFile() {
        return true;
    }

    @Override
    public DocDirectory asDirectory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DocDataFile asDataFile() {
        return this;
    }

    @Override
    public DocFile duplicate() {
        return new DocDataFile(getName(), content);
    }

    public boolean containsByte(byte bt) {
        for (byte b : content) {
            if (b == bt) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocDataFile)) return false;
        DocDataFile that = (DocDataFile) o;
        return that.getName().equals(this.getName())
                && Arrays.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(content);
    }
}
