/*
 *  Created by Olivier Blackburn
 */

import java.util.Arrays;

public class Pile {

    private Object[] elements = new Object[10];

    private void expandTableau(int position) {
        if (position >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public void push(Object contenu){
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

    public Object pop(){
        int index = size()-1;
        if((size()-1)<0)
            index = 0;
        Object popper = elements[size()-1];
        elements[size()-1] = null;
        reduceTableau();
        return popper;
    }

    private void reduceTableau() {
        if (size() <= (elements.length / 4)) {
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
    }

    public Object peek(){
        int index = size()-1;
        if((size()-1)<0)
            index = 0;

        return elements[index];
    }

    public void clear(){
        Arrays.fill(elements, null);
        elements = new Object[10];}

    public int size(){int size = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                size = i;
                break;
            }
        }
        return size;}

}
