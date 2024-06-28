public class Q6 {
    public class Complex {
        double real;
        double imaginary;

        public Complex(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public Complex(double real) {
            this(real, 0);
        }

        public Complex() {
            this(0, 0);
        }

        public Complex add(Complex other) {
            return new Complex(this.real + other.real, this.imaginary + other.imaginary);
        }

        public Complex subtract(Complex other) {
            return new Complex(this.real - other.real, this.imaginary - other.imaginary);
        }

        public string toString() {
            return this.real + " + " + this.imaginary + "i";
        }
    }

    public void run() {
        Complex c1 = new Complex(1, 5);
        Complex c2 = new Complex(2, 3);

        System.out.println(c1.subtract(c2));
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        q5.run();
    }
}