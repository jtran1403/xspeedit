package xspeedit;

import xspeedit.domain.StandardPackage;
import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SimplePacker implements Packer {

    private final List<StandardPackage> packedArticles ;

    SimplePacker() {
        this.packedArticles = new ArrayList<>();
        packedArticles.add(new StandardPackage());
    }

    @Override
    public List<String> pack(String articleList) {
        final List<Integer> articles = Stream.of(articleList.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        articles.forEach(newArticle -> {
            final StandardPackage lastPackage = getLastPackage();
            try {
                lastPackage.addArticle(newArticle);
            } catch (OversizedPackage oversizedPackage) {
                addInNewPackage(newArticle);
            }
        });
        return packedArticles.stream()
                .map(StandardPackage::getArticlesAsString)
                .collect(Collectors.toList());
    }

    private void addInNewPackage(Integer newArticle) {
        try {
            packedArticles.add(new StandardPackage());
            getLastPackage().addArticle(newArticle);
        } catch(Exception exception) {
            //TODO handle case that should never happen
        }
    }

    private StandardPackage getLastPackage() {
        final int lastPackageIndex = packedArticles.size() - 1;
        return packedArticles.get(lastPackageIndex);
    }

    List<StandardPackage> getPackedArticles() {
        return Collections.unmodifiableList(packedArticles);
    }
}
