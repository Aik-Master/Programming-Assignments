/** 
* <b>Header</b>
* Praktikum    P1P
* Semester     WS12/13
* Team         S4T4
* Aufgabe      B1
* Kontrolleur  Michael Schafers
* Datum        13.12.12
* Quellen       /
* @author      Klostermann, Aiko; 2125565
*/

package aufgabenblatt_5;

public class MagicList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    public boolean isEmpty(){
        if(head == null){
            return(true);
        }// if
        return(false);
    }// isEmpty

    public void printF2L(){
        Node<T> tmp = head;
        while(tmp != null){
            System.out.println(tmp.info);
            tmp = tmp.next;
        }// while
    }// printF2L

    public void printL2F(){
        Node<T> tmp = tail;
        while(tmp != null){
            System.out.println(tmp.info);
            tmp = tmp.prev;
        }// while
    }// printL2F

    public T peekF(){
        return(peekNo(0));
    }// peekF

    public T peekL(){
        return(peekNo(size()-1));
    }// peekL

    public T peekNo(int position){
        assert position < this.size() : "No such Element, check size() for number of elements";
        int counter = 0;
        Node<T> tmp = head;
        if(position == 0){
            return(head.info);
        }else if(position == size()){
            return(tail.info);
        }else{
        while(counter < position){
            tmp = tmp.next;
            counter++;
        }// while
        return(tmp.info);
        }//else
    }// peekNo

    public T getF(){
    	return(getNo(0));
    }// getF

    public T getL(){
    	return(getNo(size()-1));
    }// getL

    public T getNo(int position){
        assert (position < size()) : "No such Element, check size() for number of elements";
        int counter = 0;
        Node<T> tmp = head;
        while(counter < position){
            tmp = tmp.next;
            counter++;
        }// while
        if(tmp.next == null && tmp.prev == null){//first and last <- only element
            head = null;
            tail  = null;
        }else if(tmp.next == null){//last element
            tail = tmp.prev;
            tail.next = null;
        } else if(tmp.prev == null){//first element
            head = tmp.next;
            head.prev = null;
        } else{
            tmp.next.prev = tmp.prev;
            tmp.prev.next = tmp.next;
        }// else
        return(tmp.info);
    }// getNo

    public int pos(T info){
        int counter = 0;
        int size = this.size();
        Node<T> tmp = head;
        while(counter < size){
            if(tmp.info.equals(info)){
                return(counter);
            }// if
            tmp = tmp.next;
            counter++;
        }// while
        return(-1);
    }// pos

    public void putF(T info){
        Node<T> node = new Node<T>(info);
        if(isEmpty()){
            tail = node;
        } else{
            head.prev = node;
        }// else
        node.next = head;
        head = node;
    }// putF

    public void putL(T info){
        Node<T> node = new Node<T>(info);
        if(isEmpty()){
            head = node;
        } else{
            tail.next = node;
        }// else
        node.prev = tail;
        tail = node;
    }// putL

    public boolean putNo(int position, T info){
        if(position > size() || position < 0){
            return(false);
        }// if
        if(position == 0){
            putF(info);
            return(true);
        }// if
        if(position == size()){
            putL(info);
            return(true);
        }// if
        Node<T> node = new Node<T>(info);
        int counter = 0;
        Node<T> tmp = head;
        while(counter < position){
            tmp = tmp.next;
            counter++;
        }// while
        node.next = tmp;
        tmp.prev.next = node;
        node.prev = tmp.prev;
        tmp.prev = node;
        return(true);
    }// putNo

    public T setNo(int position, T info){
        if(position > size() || position < 0){
            return(null);
        }// if
        T tmp = getNo(position);
        putNo(position, info);
        return(tmp);
    }// setNo

    public int size(){
        if(head == null){
            return(0);
        }// if
        int counter = 1;
        Node<T> tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            counter++;
        }// while
        return(counter);
    }// size

    public boolean remove(T info){
        Node<T> tmp = head;
        int counter = 0;
        while(tmp != null){
            if(tmp.info.equals(info)){
                getNo(counter);
                return(true);
            }// if
            if(tmp.next == null){
                return(false);
            }//if
            counter++;
            tmp = tmp.next;
        }// while
        return(false);
    }// remove

    public MagicList<T> subList(T start){
        Node<T> tmp = head;
        MagicList<T> sublist = new MagicList<T>();
        while(tmp != null){
            if(tmp.info.equals(start)){
                while(tmp != null){
                    sublist.putL(tmp.info);
                    tmp = tmp.next;
                }// while
                return(sublist);
            }// if
            tmp = tmp.next;
        }// while
        return(sublist);
    }// subList

    public MagicList<T> subList(T ersterParameter, T zweiterParameter){
        Node<T> tmp = head;
        T abbruchParameter;
        MagicList<T> sublist = new MagicList<T>();
        while(tmp != null){
            if(tmp.info.equals(ersterParameter) || tmp.info.equals(zweiterParameter)){
            	if((tmp.info.equals(ersterParameter))){
            		abbruchParameter = zweiterParameter;
            	}else{
            		abbruchParameter = ersterParameter;
            	}//else
                while(tmp.info != abbruchParameter){
                    if(tmp.next == null){
                        System.out.println("The 2nd object was not found in the original list, the sublist contains all objects beginning with the 1st object");
                        break;
                    }// if
                    sublist.putL(tmp.info);
                    tmp = tmp.next;
                }// while
                sublist.putL(tmp.info);
                return(sublist);
            }// if
            tmp = tmp.next;
        }// while
        System.out.println("The 1st object was not found in the original list, the sublist is empty");
        return(new MagicList<T>());
    }// subList

    @Override
    public String toString(){
        return String.format("<|MagicList|> head:%s, tail:%s  super: %s ",
                head,
                tail,
                super.toString());
    }//toString
}// MagicList<T>