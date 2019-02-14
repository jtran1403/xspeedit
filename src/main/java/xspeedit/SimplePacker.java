package xspeedit;

import xspeedit.domain.StandardPackage;
import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplePacker implements Packer {

    private List<StandardPackage> packedArticles = new ArrayList<>();

    @Override
    public List<String> pack(String articleList) {
        final List<Integer> articles = Stream.of(articleList.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        articles.forEach(newArticle -> {
            initFirstPackage();
            final StandardPackage lastPackage = getLastPackage();
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

    private void initFirstPackage() {
        if(packedArticles.isEmpty()) {
            //FIXME initial list should be StandardPackage responsibility
            packedArticles.add(new StandardPackage(new ArrayList<>()));
        }
    }

    private StandardPackage getLastPackage() {
        final int lastPackageIndex = packedArticles.size() - 1;
        return packedArticles.get(lastPackageIndex);
    }
}
