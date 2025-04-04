package laborator6;

public class DoubleCalculator extends ACalculator {

    @Override
    public void init(Object initialState) {
        if (initialState instanceof Double) {
            this.state = initialState;
        } else {
            throw new IllegalArgumentException("State must be of type Double.");
        }
    }

    public DoubleCalculator add(Double value) {
        this.state = (Double) this.state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        this.state = (Double) this.state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        this.state = (Double) this.state * value;
        return this;
    }

    public Double result() { // Returnăm rezultatul ca Double
        return (Double) this.state;
    }
}
