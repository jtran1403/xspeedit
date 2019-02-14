package xspeedit.exception;

public class OversizedPackage extends Exception {
    public OversizedPackage() {
        super("Cannot add article to package");
    }
}
