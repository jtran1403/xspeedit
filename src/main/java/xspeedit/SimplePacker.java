package xspeedit;

import xspeedit.domain.StandardPackage;
import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplePacker implements Packer {

    private List<StandardPackage> packedArticles;

    @Override
    public List<String> pack(String articleList) {
        packedArticles = new ArrayList<>();
        final List<Integer> articles = Stream.of(articleList.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        articles.forEach(newArticle -> {
            if(packedArticles.isEmpty()) {
                packedArticles.add(new StandardPackage(new ArrayList<>()));
            }
            final int lastPackageIndex = packedArticles.size() - 1;
            final StandardPackage lastPackage = packedArticles.get(lastPackageIndex);
            try {
                lastPackage.addArticle(newArticle);
            } catch (OversizedPackage oversizedPackage) {
                //TODO handle exception
            }
        });
        return packedArticles.stream()
                .map(StandardPackage::getArticlesAsString)
                .collect(Collectors.toList());
    }
}
