package com.company;

import java.util.List;

public class Association<K, E> {
    private K key;
    private E element;

    public Association(K key, E element) {
         this.key = key;
         this.element = element;
    }

    public E getElement() {
        return element;
    }

    public K getKey() {
        return key;
    }

    public static <K, E> E findElement(List<Association<K,E>> assc, K key){
        E element = null;
        for(int i = 0; i < assc.size(); i++) {
            if( key == assc.get(i).getKey());
                element = assc.get(i).getElement();
        }
        return element;
    }
}
