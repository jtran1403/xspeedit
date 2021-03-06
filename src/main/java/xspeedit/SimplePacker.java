package xspeedit;

import xspeedit.domain.StandardPackage;

import java.util.List;
import java.util.stream.Collectors;

public final class SimplePacker extends StandardPacker implements Packer {

    SimplePacker() {
        super();
    }

    @Override
    public List<String> pack(String articleList) {
        final List<Integer> articles = getArticlesBySize(articleList);

        articles.forEach(newArticle -> {
            final StandardPackage lastPackage = getLastPackage();
            final boolean addedArticle = lastPackage.addNewArticle(newArticle);
            if (!addedArticle) {
                addInNewPackage(newArticle);
            }
        });
        return getPackagesAsString();
    }

    private List<String> getPackagesAsString() {
        return packedArticles.stream()
                .map(StandardPackage::getArticlesAsString)
                .collect(Collectors.toList());
    }

    private void addInNewPackage(Integer newArticle) {
        packedArticles.add(new StandardPackage());
        getLastPackage().addNewArticle(newArticle);
    }

    private StandardPackage getLastPackage() {
        final int lastPackageIndex = packedArticles.size() - 1;
        return packedArticles.get(lastPackageIndex);
    }
}
