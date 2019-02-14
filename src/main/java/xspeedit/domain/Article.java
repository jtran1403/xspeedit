package xspeedit.domain;

public final class Article {
    private final Integer size;
    private final boolean packed;

    public Article(Integer size) {
        this.size = size;
        this.packed = false;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isPacked() {
        return packed;
    }
}
