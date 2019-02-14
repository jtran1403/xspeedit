package xspeedit.domain;

import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StandardPackage {
    private static final Integer PACKAGE_SIZE_LIMIT = 10;
    private final List<Integer> articles = new ArrayList<>();

    //FIXME unused
    public List<Integer> getArticles() {
        return Collections.unmodifiableList(articles);
    }

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
}
