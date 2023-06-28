package ca.ulaval.set.apipoc.admission.application.adapter;

import java.util.*;
import java.util.function.Function;

public class LazyTransformedList<S,T> implements List<T> {

    private final List<S> originalList;
    private final Function<S, T> transformer;
    private List<T> transformedList;

    public LazyTransformedList(List<S> originalList, Function<S,T> transformer) {
        this.originalList = originalList;
        this.transformer = transformer;
    }

    @Override
    public int size() {
        return this.getTransformedList().size();
    }

    @Override
    public boolean isEmpty() {
        return this.getTransformedList().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.getTransformedList().contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.getTransformedList().iterator();
    }

    @Override
    public Object[] toArray() {
        return this.getTransformedList().toArray();
    }

    @Override
    public boolean add(T o) {
        return this.getTransformedList().add(o);
    }

    @Override
    public boolean remove(Object o) {
        return this.getTransformedList().remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return this.getTransformedList().addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return this.getTransformedList().addAll(index, c);
    }

    @Override
    public void clear() {
        this.getTransformedList().clear();
    }

    @Override
    public T get(int index) {
        return this.getTransformedList().get(index);
    }

    @Override
    public T set(int index, T element) {
        return this.getTransformedList().set(index, element);
    }

    @Override
    public void add(int index, T element) {
        this.getTransformedList().add(index, element);
    }

    @Override
    public T remove(int index) {
        return this.getTransformedList().remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.getTransformedList().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.getTransformedList().lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.getTransformedList().listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return this.getTransformedList().listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return this.getTransformedList().subList(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection c) {
        return this.getTransformedList().retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return this.getTransformedList().removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return this.getTransformedList().containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.getTransformedList().toArray(a);
    }

    private List<T> getTransformedList() {
        if (this.transformedList != null) {
            return transformedList;
        }

        return initTransformedList();
    }

    private synchronized List<T> initTransformedList() {
        if (this.transformedList != null) {
            return transformedList;
        }

        ArrayList<T> tmpList = new ArrayList<>();
        this.originalList.forEach(s -> tmpList.add(this.transformer.apply(s)));
        this.transformedList = tmpList;
        return this.transformedList;
    }
}
