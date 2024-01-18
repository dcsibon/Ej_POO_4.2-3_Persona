
fun main() {
    val persona1 = Persona(90.55, 1.93)

    persona1.nombre = "Diego"
    persona1.mostrarDesc()

    persona1.peso = 88.77
    persona1.mostrarDesc()

    persona1.altura = 91.30
    persona1.mostrarDesc()

    val persona2 = Persona("Marta", 61.88, 1.69)
    persona2.mostrarDesc()

    val persona3 = Persona("David", altura = 1.65, peso = 69.50)
    persona3.mostrarDesc()
}

class Persona(peso: Double, altura: Double) {

    var peso: Double = 0.0
        set(value) {
            require(value > 0) { "El peso no puede ser negativo." }
            field = value
        }

    init {
        this.peso = peso
    }

    var altura: Double = 0.0
        set(value) {
            require(value > 0) { "La altura no puede ser negativa." }
            field = value
        }

    init {
        this.altura = altura
    }

    var nombre: String = ""
        get() = field
        set(value) {
            require(value.trim().isNotEmpty()) { "El nombre no puede estar vacío." }
            field = value
        }

    var imc: String = ""
        get() = obtenerImc()
        private set(value) {
            field = value
        }

    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura) {
        this.nombre = nombre
    }

    //Métodos privados...


    private fun obtenerImc(): String {
        return "%.2f".format(calcularImc())
    }

    private fun calcularImc() = this.peso / (this.altura * this.altura)

    //Métodos públicos...

    fun mostrarDesc() {
        println("${this.nombre} con peso ${this.peso}kg y altura ${this.altura}m tiene un IMC de ${this.imc}.")
    }

}