package com.mycompany.a2;

import java.util.Vector;

public class GameCollection implements ICollection {

	private Vector<GameObject> objectList;
	
	public GameCollection() {
		objectList=new Vector<GameObject>();
	}
	
	@Override
    public IIterator getIterator() {
        IIterator it = new GameIterator();
        return it;
    }

	@Override
	public void add(Object newObject) {
		if(newObject instanceof GameObject)
			objectList.add((GameObject) newObject);
		
	}
	
	public void remove(int i) {
		objectList.remove(i);
	}

	public boolean remove(GameObject target) {
		return objectList.remove(target);
		
	}
	
	private class GameIterator implements IIterator{

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
        	if(objectList.size()==0)
        		return false;
            return currentIndex < objectList.size();
        }

        @Override
        public GameObject getNext() {
        	GameObject ret = null;
        	if(hasNext()) {
        		ret= objectList.get(currentIndex);
        		currentIndex++;
        		
        	}
        	return ret;
        }
		 
    }

	public int size() {
		return objectList.size();
	}

	public GameObject get(int i) {
		return objectList.get(i);
	}
	
	/*
    
	@Override
	public boolean addAll(Collection<? extends GameObject> collection) {
		boolean nofail =true;
		for(Object item:collection) {
			if(item instanceof GameObject) {
				add((GameObject) item);
			}
			else {
				System.err.println("Error: attempted to add a non-GameObject");
				nofail=false;
			}
		}
		return nofail;
	}

	@Override
	public void clear() {
		objectList.clear();
		
	}

	@Override
	public boolean contains(Object object) {
		return objectList.contains(object);
	}

	@Override
	public boolean containsAll(Collection collection) {
		return objectList.containsAll(collection);
	}

	@Override
	public boolean isEmpty() {
		return objectList.isEmpty();
	}

	@Override
	public boolean removeAll(Collection collection) {
		return objectList.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection collection) {
		return objectList.retainAll(collection);
	}

	@Override
	public int size() {
		return objectList.size();
	}

	@Override
	public Object[] toArray() {
		return objectList.toArray();
	}

	@Override
	public Object[] toArray(Object[] array) {
		return objectList.toArray(array);
	}

	@Override
	public boolean add(GameObject object) {
		return objectList.add(object);
	}

	@Override
	public boolean remove(Object object) {
		return objectList.remove(object);
				
	}

	public GameObject get(int i) {
		return objectList.get(i);
	}
	*/
    
}
