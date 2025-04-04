package laborator6;


public class NewIntCalculator extends ACalculator {

    @Override
    public void init(Object initialState) {
        if (initialState instanceof Integer) {
            this.state = initialState;
        } else {
            throw new IllegalArgumentException("State must be of type Integer.");
        }
    }

    public NewIntCalculator add(Integer value) {
        this.state = (Integer) this.state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        this.state = (Integer) this.state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        this.state = (Integer) this.state * value;
        return this;
    }

    public Integer result() {
        return (Integer) this.state;
    }
}
