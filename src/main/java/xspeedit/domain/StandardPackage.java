package xspeedit.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StandardPackage {
    private static final Integer PACKAGE_SIZE_LIMIT = 10;
    private final List<Integer> articles = new ArrayList<>();

    public boolean addNewArticle(Integer newArticle) {
        if (cannotAdd(newArticle)) {
            return false;
        }
        return this.articles.add(newArticle);
    }

    public String getArticlesAsString() {
        final StringBuilder stringBuilder = new StringBuilder();
        articles.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private boolean cannotAdd(Integer newArticle) {
        return getCurrentPackageSize() + newArticle > PACKAGE_SIZE_LIMIT;
    }

    private Integer getCurrentPackageSize() {
        return this.articles.stream().reduce(0, (article1, article2) -> article1 + article2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardPackage that = (StandardPackage) o;
        return Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articles);
    }
}
