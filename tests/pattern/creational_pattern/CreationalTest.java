package pattern.creational_pattern;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// These teaching files deliberately colocate package-private participant classes.
@SuppressWarnings("auxiliaryclass")
public final class CreationalTest {
    public static void main(String[] args) throws Exception {
        var executor = Executors.newFixedThreadPool(8);
        CountDownLatch start = new CountDownLatch(1);
        var results = new ArrayList<Future<Singleton>>();
        try {
            for (int i = 0; i < 8; i++) results.add(executor.submit(() -> { start.await(); return Singleton.getInstance(); }));
            start.countDown();
            Singleton value = results.get(0).get(5, TimeUnit.SECONDS);
            for (var result : results) require(result.get(5, TimeUnit.SECONDS) == value);
        } finally { executor.shutdownNow(); require(executor.awaitTermination(5, TimeUnit.SECONDS)); }
        require(Singleton2.getInstance() == Singleton2.getInstance());
        ShallowClone shallow = new ShallowClone(); shallow.list.add("old");
        require(shallow.clone().list == shallow.list);
        DeepClone deep = new DeepClone(); deep.list.add("old");
        DeepClone copy = deep.clone(); copy.list.add("new");
        require(deep.list.size() == 1 && copy.list.size() == 2);
        Builder builder = new BuilderA();
        Product first = Director.construct(builder), second = Director.construct(builder);
        require(first != second);
        first.setPartA("changed"); require(second.getPartA().equals("Part A"));
        require(new FactoryMethod.UpperDocument().render("Hi").equals("HI"));
        require(new FactoryMethod.PlainDocument().render("Hi").equals("Hi"));
        require(AbstractFactory.render(new AbstractFactory.LightFactory()).equals("light button / light checkbox"));
        require(AbstractFactory.render(new AbstractFactory.DarkFactory()).equals("dark button / dark checkbox"));
        System.out.println("CreationalTest: singleton concurrency, cloning, builder and factory contracts passed");
    }
    private static void require(boolean condition) { if (!condition) throw new AssertionError(); }
}
