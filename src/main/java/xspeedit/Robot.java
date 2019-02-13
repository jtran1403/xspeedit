package xspeedit;

import java.util.List;

public class Robot
{
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
}
