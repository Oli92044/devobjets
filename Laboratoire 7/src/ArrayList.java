/*
 *  Created by Olivier Blackburn
 */

import java.util.Arrays;

public class ArrayList<T>
        implements List {

    private Object[] elements = new Object[10];

    //marche
    private void expandTableau(int position) {

        if (position >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    //À tester
    private void reduceTableau() {
        if (size() <= (elements.length / 4)) {
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
    }

    //marche
    public void add(int index, Object contenu) {
        if (index>0 && index <= size()) {
            expandTableau(index);
            System.arraycopy(elements, index,
                    elements, index + 1,
                    size() - index);
            elements[index] = contenu;
        } else
            System.out.println("ArrayIndexOutOfBoundsException");
    }

    //marche
    public void add(Object contenu) {
        int position = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                position = i;
                break;
            }
        }
        expandTableau(position);
        elements[position] = contenu;
    }

    //marche
    public void set(int index, Object contenu) {
        if (index <= size()) {
            expandTableau(index);
            elements[index] = contenu;
        }
    }

    //marche
    public Object get(int index) {
        return elements[index];
    }

    //marche
    public void remove(int index) {
        if(index<0)
            index = 0;
        for (int i = index; i < size(); i++) {
            elements[i] = elements[i + 1];
        }
        reduceTableau();
    }

    //marche
    public void clear() {
        Arrays.fill(elements, null);
        elements = new Object[10];
    }

    //marche
    public int size() {
        int size = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                size = i;
                break;
            }
        }
        return size;
    }

    public int length() {
        return elements.length;
    }
}
