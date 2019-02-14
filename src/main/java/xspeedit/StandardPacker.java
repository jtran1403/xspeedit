package xspeedit;

import xspeedit.domain.StandardPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StandardPacker {
    final List<StandardPackage> packedArticles;

    StandardPacker() {
        this.packedArticles = new ArrayList<>();
        packedArticles.add(new StandardPackage());
    }

    List<StandardPackage> getPackedArticles() {
        return packedArticles;
    }
}
