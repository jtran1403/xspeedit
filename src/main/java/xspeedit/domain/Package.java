package xspeedit.domain;

import java.util.Collections;
import java.util.List;

public final class Package {
    private final List<Integer> articles;

    public Package(List<Integer> articles) {
        this.articles = articles;
    }

    public List<Integer> getArticles() {
        return Collections.unmodifiableList(articles);
    }

    public List<Integer> addArticle(Integer newArticle) {
        this.articles.add(newArticle);
        return getArticles();
    }
}
