import java.util.List;

public class Main {
    record UiElement(String type, String label, boolean keyboardAccessible, double contrastRatio) {}

    public static void main(String[] args) {
        List<UiElement> elements = List.of(
                new UiElement("Button", "Save profile", true, 5.2),
                new UiElement("Icon button", "", true, 4.8),
                new UiElement("Link", "View invoice", true, 3.2),
                new UiElement("Menu", "Main navigation", false, 7.0));

        System.out.println("=== Accessibility Checklist Runner ===");
        for (UiElement element : elements) {
            boolean hasLabel = element.label() != null && !element.label().isBlank();
            boolean contrastOk = element.contrastRatio() >= 4.5;
            boolean passed = hasLabel && element.keyboardAccessible() && contrastOk;

            System.out.printf("%-12s -> %s%n", element.type(), passed ? "PASS" : "REVIEW");
            if (!hasLabel) System.out.println("  - Add an accessible label.");
            if (!element.keyboardAccessible()) System.out.println("  - Add keyboard support.");
            if (!contrastOk) System.out.println("  - Improve text/background contrast.");
        }
    }
}
