/**
 * Design Pattern: decorator
 */

public class Main {
    public static void main(String[] args) {
        Composant component = new Composant();
        DecoratorConcret decorator = new Decorator(component);

        decorator.methode();

    }
}