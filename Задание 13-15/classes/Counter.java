package classes;

import java.io.IOException;

public class Counter implements AutoCloseable {

    Integer count;
    boolean isOpen;

    public Counter() {
        this.count = 0;
        this.isOpen = false;
    }

    public void add() throws IOException {
        if(!isOpen){
            throw new IOException("Счетчик не открыт");
        }
        this.count++;
    }

    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() throws Exception {
        this.isOpen = false;
    }
}
