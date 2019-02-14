package xspeedit;

import xspeedit.domain.StandardPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SmarterPacker implements Packer {

    private final List<StandardPackage> packedArticles;

    SmarterPacker() {
        this.packedArticles = new ArrayList<>();
        packedArticles.add(new StandardPackage());
    }

    @Override
    public List<String> pack(String articleList) {
        return null;
    }

    List<StandardPackage> getPackedArticles() {
        return Collections.unmodifiableList(packedArticles);
    }
}
