package session34.demo;

interface App {
    void serveA();
    void serveB();
}

class AppImpl implements App{
    @Override
    public void serveA() {
        System.out.println("App is serving A");
    }

    @Override
    public void serveB() {
        System.out.println("App is serving B");
        serveA();  // inheritance will change the actual-called serveA()
    }
}

final class InheritanceApp extends AppImpl {
    @Override
    public void serveA() {
        System.out.println("--before A--");
        super.serveA();
        System.out.println("--after A--");
    }

    @Override
    public void serveB() {
        System.out.println("--before B--");
        super.serveB();
        System.out.println("--after B--");
    }
}

final class CompositionApp implements App{
    private final App app;

    CompositionApp(App app) {
        this.app = app;
    }

    @Override
    public void serveA() {
        System.out.println("--before A--");
        app.serveA();
        System.out.println("--after A--");
    }

    @Override
    public void serveB() {
        System.out.println("--before B--");
        app.serveB();
        System.out.println("--after B--");
    }
}

class Demo {
    public static void main(String[] args) {
        App inheritance = new InheritanceApp();
        //inheritance.serveA();
        inheritance.serveB();
        System.out.println();

        App composition = new CompositionApp(new AppImpl());
        //composition.serveA();
        composition.serveB();
    }
}