package com.db1.db1start;

public class Application {

    public Integer sum(Integer number1, Integer number2) {
        return (number1 + number2);
    }

    public Integer sub(Integer number1, Integer number2) {
        return (number1 - number2);
    }

    public Integer mul(Integer number1, Integer number2) {
        return (number1 * number2);
    }

    public Integer div(Integer dividend, Integer divisor) {
        if (divisor != 0) {
            return (dividend / divisor);
        }
        return 0;
    }

    public boolean isEven(Integer number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    public Integer max(Integer number1, Integer number2) {
        if (number1 >= number2) {
            return number1;
        }
        return number2;
    }

    public Integer howMuchOddsTo(Integer number) {
        Integer response = number / 2;
        if (!this.isEven(number)) {
            return (response + 1);
        }
        return response;
    }

}
