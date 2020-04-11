package fp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class CombinationDemo {

    private final Map<Class<?>, Monoid<?>> monoidCache = new HashMap<>();


    <E> E combine(List<E> elements, Monoid<E> m) {
        if (elements.isEmpty()) return null;
        return elements.stream().reduce(m.identity(), m::combine);
    }
}

interface Monoid<A> {
    A identity();

    A combine(A a1, A a2);
}

final class SumInt implements Monoid<Integer> {

    @Override
    public Integer identity() {
        return 0;
    }

    @Override
    public Integer combine(Integer a1, Integer a2) {
        return a1 + a2;
    }
}
