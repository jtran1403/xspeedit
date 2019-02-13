package xspeedit;

import java.util.List;

public class Robot
{
    private final Packer packer;

    public Robot(final Packer packer) {
        this.packer = packer;
    }

    public String print(List<String> articles) {
        final StringBuilder stringBuilder = new StringBuilder();
        articles.forEach(article -> {
            if(isFirstArticle(stringBuilder)) {
                stringBuilder.append("/");
            }
            stringBuilder.append(article);
        });
        return stringBuilder.toString();
    }

    private boolean isFirstArticle(StringBuilder stringBuilder) {
        return !stringBuilder.toString().equals("");
    }

    public void packArticles(final String articles) {
        packer.pack(articles);
    }
}
