import java.lang.reflect.Array;

public class List <E>{

    private E[] arr;
    private int counter;

    public List (E[] a){
        this.arr = a;
        this.counter = this.arr.length;
    }

    public List (Class <E> c) {
        @SuppressWarnings("unchecked")
        E[] x = (E[]) Array.newInstance(c, 5);
        this.arr = x;
    }

    public void display() {
        String result = "[";

        for (int i = 0; i < this.counter; i++) {

            if (i < this.counter - 1) {
                result += this.arr[i] + ", "; //! this might need to be unboxed or toString()

            } else {
                result += this.arr[i];
            }
        }

        result += "]";
        System.out.println(result);
    }

    public void insert(Class <E> c,int idx, E x) {
        if (idx > this.counter) {
            throw new IllegalArgumentException("Index Out Of Range!"); // [2, 1, 3] insert(10, 3)
        }

        this.counter++;

        if (this.counter > this.arr.length) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) Array.newInstance(c, this.arr.length * 2); // resize the array //! cannot make generic array

            for (int i = 0; i < this.counter; i++) {
                if (i < idx) {
                    newArray[i] = this.arr[i];
                } else if (i == idx) {
                    newArray[i] = x;
                } else {
                    newArray[i] = this.arr[i - 1];
                }
            }
            this.arr = newArray;
        } else {
            for (int i = this.counter - 1; i > idx; i--) {
                this.arr[i] = this.arr[i - 1]; // starting from the last index, shift elements to the right until the
                                               // idxth index
            }
            this.arr[idx] = x;
        }
    }

    public void insert(Class <E> c, E x) {
        int idx = this.counter;
        this.counter ++;

        if (this.counter > this.arr.length) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) Array.newInstance(c, this.arr.length * 2); // resize the array //! cannot make generic array

            for (int i = 0; i < this.counter; i++) {
                if (i < idx) {
                    newArray[i] = this.arr[i];
                } else if (i == idx) {
                    newArray[i] = x;
                } else {
                    newArray[i] = this.arr[i - 1];
                }
            }
            this.arr = newArray;
        } else {
            for (int i = this.counter - 1; i > idx; i--) {
                this.arr[i] = this.arr[i - 1]; // starting from the last index, shift elements to the right until the
                                               // idxth index
            }
            this.arr[idx] = x;
        }
    }

    public void replace(int idx, E x) {
        if (idx >= this.counter) {
            throw new IllegalArgumentException("Index Out of Range!");

        }

        this.arr[idx] = x;
    }

    public E get(int idx) {
        if (idx < this.counter) {
            return this.arr[idx];
        }

        throw new IllegalArgumentException("Index Out of Range!");
    }

    public void remove(int idx) { // remove at a specified index
        if (idx >= this.counter) {
            throw new IllegalArgumentException("Index Out of Range!");
        }

        for (int i = idx + 1; i < this.counter; i++) {
            this.arr[i - 1] = this.arr[i]; // shifting elements to the left
        }
        this.counter--;
    }

    public List<Integer> FindAll(Integer x, String condition) {
        List<Integer> result = new List<Integer>(Integer.class);

        if (condition == "==") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m == x) result.insert(Integer.class, i);
            }
        } else if (condition == ">") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m > x) result.insert(Integer.class, i);
            }
        } else if (condition == "<") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m < x) result.insert(Integer.class, i);
            }
        } else if (condition == "<=") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m <= x) result.insert(Integer.class, i);
            }
        } else if (condition == ">=") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m >= x) result.insert(Integer.class, i);
            }
        } else if (condition == "!=") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m != x) result.insert(Integer.class, i);
            }
        } else {
            throw new Error("There is something wrong!");
        }

        return result;
    }

    public void RemoveAll(Integer x, String condition) { //! needs to be fixed
        if (condition == "==") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m == x) this.remove(i);
            }
        } else if (condition == ">") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m > x) this.remove(i);
            }
        } else if (condition == "<") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m < x) this.remove(i);
            }
        } else if (condition == "<=") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m <= x) this.remove(i);
            }
        } else if (condition == ">=") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m >= x) this.remove(i);
            }
        } else if (condition == "!=") {
            for (int i = 0; i < this.counter; i++) {
                Integer m = Integer.valueOf(this.arr[i].toString());
                if (m != x) this.remove(i);
            }
        } else {
            throw new Error("There is something wrong!");
        }
    }

    public List<Integer> FindAll(String x, String condition) {
        List<Integer> result = new List<Integer>(Integer.class);

        if (condition == "==") {
            for (int i = 0; i < this.counter; i++) {
                String m = this.arr[i].toString();
                if (m == x) result.insert(Integer.class, i);
            }
        } else if (condition == "!=") {
            for (int i = 0; i < this.counter; i++) {
                String m = this.arr[i].toString();
                if (m != x) result.insert(Integer.class, i);
            }
        } else {
            throw new Error("There is something wrong!");
        }

        return result;
    }

    public void RemoveAll(String x, String condition) { //! Fix this 
        //List<Integer> result = new List<Integer>(Integer.class);

        if (condition == "==") {
            for (int i = 0; i < this.counter; i++) {
                String m = this.arr[i].toString();
                if (m == x) this.remove(i);
            }
        } else if (condition == "!=") {
            for (int i = 0; i < this.counter; i++) {
                String m = this.arr[i].toString();
                if (m != x) this.remove(i);
            }
        } else {
            throw new Error("There is something wrong!");
        }
    }


}
