package xspeedit.domain;

import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class StandardPackage {
    private static final Integer PACKAGE_SIZE_LIMIT = 10;
    private final List<Integer> articles = new ArrayList<>();

    public List<Integer> addArticle(Integer newArticle) throws OversizedPackage {
        if (cannotAdd(newArticle)) {
            throw new OversizedPackage();
        }
        this.articles.add(newArticle);
        return getArticles();
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

    private List<Integer> getArticles() {
        return Collections.unmodifiableList(articles);
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
