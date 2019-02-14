package xspeedit.domain;

import xspeedit.exception.OversizedPackage;

import java.util.Collections;
import java.util.List;

public final class Package {
    private static final Integer PACKAGE_SIZE_LIMIT = 10;
    private final List<Integer> articles;

    public Package(List<Integer> articles) {
        this.articles = articles;
    }

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

    private boolean cannotAdd(Integer newArticle) {
        return getCurrentPackageSize() + newArticle > PACKAGE_SIZE_LIMIT;
    }

    private Integer getCurrentPackageSize() {
        return this.articles.stream().reduce(0, (article1, article2) -> article1 + article2);
    }
}
