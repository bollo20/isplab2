package laborator6;

public abstract class ACalculator {
    protected Object state; // Câmp comun pentru stocarea stării

    public void clear() {
        state = 0;
    }

    public abstract void init(Object initialState);
}
