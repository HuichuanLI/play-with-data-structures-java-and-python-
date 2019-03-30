public class LinkedlistSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedlistSet() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (this.list.contains(e) == false)
            this.list.addFirst(e);
    }

    public void remove(E e) {
        this.list.removeElement(e);
    }

    public boolean contains(E e) {
        return this.list.contains(e);
    }

    public int getSize() {
        return this.list.getSize();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}


class Main{

}