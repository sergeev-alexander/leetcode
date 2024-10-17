package alexander.sergeev.linked_list;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomLinkedList<T> {

    static <T> boolean allMatch(Node<T> head, Predicate<T> p) {
        return !anyMatch(head, p.negate());
    }

    static <T> boolean anyMatch(Node<T> head, Predicate<T> p) {
        return head != null && (p.test(head.data) || anyMatch((Node<T>) head.next, p));
    }

    static <T> boolean allMatch1(Node<T> head, Predicate<T> p) {
        return head == null || (p.test(head.data) && allMatch((Node<T>) head.next, p));
    }

    static <T> boolean anyMatch2(Node<T> head, Predicate<T> p) {
        if (head == null) return false;
        return p.test(head.data) || anyMatch((Node<T>) head.next, p);
    }

//    static <T> Node<T> filter(Node<T> head, Predicate<T> p) {
//        while ( (head != null) && !p.test(head.data) ) head = (Node<T>) head.next;
//        return head == null ? null : new Node<T>(head.data, filter((Node<T>) head.next, p));
//    }

//    static <T, R> Node<R> map(Node<T> head, Function<T, R> f) {
//        return head == null ? null : new Node<>(f.apply(head.data), map(head.next, f));
//    }
//}

    public static <T> T reduce(Node<T> head, BiFunction<T,T,T> f, T init) {
        return head == null ? init : reduce((Node<T>) head.next, f, f.apply(init, head.data));
    }

}
