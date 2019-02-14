package xspeedit;

import xspeedit.domain.StandardPackage;

import java.util.List;
import java.util.stream.Collectors;

public final class SmarterPacker extends StandardPacker implements Packer {

    SmarterPacker() {
        super();
    }

    @Override
    public List<String> pack(String articleList) {
        final List<Integer> articles = getArticlesBySize(articleList);

        articles.forEach(newArticle -> {
            final StandardPackage lastPackage = getLastPackage();
            lastPackage.addNewArticle(newArticle);
        });
        return getPackagesAsString();
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
}
