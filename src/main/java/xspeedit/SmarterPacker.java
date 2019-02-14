package xspeedit;

import xspeedit.domain.Article;
import xspeedit.domain.StandardPackage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TODO remove duplicated code with simplerPacker
public final class SmarterPacker extends StandardPacker implements Packer {

    private List<Article> articles;

    SmarterPacker() {
        super();
    }

    @Override
    public List<String> pack(String articleList) {
        articles = getArticlesBySize(articleList).stream()
                .map(Article::new)
                .collect(Collectors.toList());

        articles.forEach(newArticle -> {
            if (!newArticle.isPacked()) {
                final StandardPackage lastPackage = getLastPackage();
                final boolean addedArticle = lastPackage.addNewArticle(newArticle.getSize());
                if (!addedArticle) {
                    addInNewPackage(newArticle.getSize());
                    tryToFillWithRemainingArticles(lastPackage);
                }
                newArticle.packed();
            }
        });
        return getPackagesAsString();
    }

    private void tryToFillWithRemainingArticles(StandardPackage lastPackage) {
        final Integer spaceLeft = lastPackage.getSpaceLeft();
        final Optional<Article> complementaryArticle = articles.stream()
                .filter(article -> !article.isPacked())
                .filter(remainingArticle -> spaceLeft.equals(remainingArticle.getSize()))
                .findFirst();
        if(complementaryArticle.isPresent()) {
            final Article article = complementaryArticle.get();
            lastPackage.addNewArticle(article.getSize());
            article.packed();
        }
    }

    private List<String> getPackagesAsString() {
        return packedArticles.stream()
                .map(StandardPackage::getArticlesAsString)
                .collect(Collectors.toList());
    }

    private StandardPackage getLastPackage() {
        final int lastPackageIndex = packedArticles.size() - 1;
        return packedArticles.get(lastPackageIndex);
    }

    private void addInNewPackage(Integer newArticle) {
        packedArticles.add(new StandardPackage());
        getLastPackage().addNewArticle(newArticle);
    }
}
