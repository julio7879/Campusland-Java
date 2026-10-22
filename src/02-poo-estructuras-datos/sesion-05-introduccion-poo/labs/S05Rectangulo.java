public class S05Rectangulo {
    // TO DO 1: Declarar base y altura como campos privados double.
    private double base;
    private double altura;

    public S05Rectangulo(double base, double altura) {
        // TO DO 2: Guardar los dos parametros en los campos usando this.
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        // TO DO 3: Devolver el area calculada con base y altura.
        return this.base * this.altura;
    }

    public double calcularPerimetro() {
        // TO DO 4: Devolver el perimetro calculado con base y altura.
        return 2 * (this.base + this.altura);
    }

    public boolean esCuadrado() {
        // TO DO 5: Devolver si base y altura son iguales.
        return this.base == this.altura;
    }
}
