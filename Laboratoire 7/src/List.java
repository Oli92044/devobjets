/*
 *  Created by Olivier Blackburn
 */

public interface List {

    void add(int index, Object contenu);

    void add(Object contenu);

    void remove(int index);

    void clear();

    int size();
}
