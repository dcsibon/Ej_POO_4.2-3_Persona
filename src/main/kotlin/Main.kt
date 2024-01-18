/**
 * Programa principal que demuestra el uso de la clase Persona para representar
 * información sobre el peso, altura y nombre de diferentes personas.
 */
fun main() {
    // Crear una instancia de Persona con peso y altura especificados.
    val persona1 = Persona(90.55, 1.93)

    // Modificar el nombre y mostrar la descripción de la persona.
    persona1.nombre = "Diego"
    persona1.mostrarDesc()

    // Modificar el peso y mostrar la descripción de la persona.
    persona1.peso = 88.77
    persona1.mostrarDesc()

    // Modificar la altura y mostrar la descripción de la persona.
    persona1.altura = 91.30
    persona1.mostrarDesc()

    // Crear una instancia de Persona con nombre, peso y altura especificados.
    val persona2 = Persona("Marta", 61.88, 1.69)
    persona2.mostrarDesc()

    // Crear una instancia de Persona con nombre, altura y peso especificados.
    val persona3 = Persona("David", altura = 1.65, peso = 69.50)
    persona3.mostrarDesc()
}

/**
 * Clase que representa a una persona con atributos como peso, altura y nombre.
 * También proporciona métodos para calcular e imprimir el índice de masa corporal (IMC).
 *
 * @property peso Peso de la persona en kilogramos.
 * @property altura Altura de la persona en metros.
 * @property nombre Nombre de la persona.
 * @property imc Índice de Masa Corporal (IMC) de la persona.
 * @constructor Crea una instancia de Persona con peso y altura especificados.
 * @constructor Crea una instancia de Persona con nombre, peso y altura especificados.
 * @param nombre Nombre de la persona.
 * @param peso Peso de la persona en kilogramos.
 * @param altura Altura de la persona en metros.
 */
class Persona(peso: Double, altura: Double) {

    /**
     * Peso de la persona en kilogramos.
     */
    var peso: Double = 0.0
        set(value) {
            require(value > 0) { "El peso no puede ser negativo." }
            field = value
        }

    /**
     * Altura de la persona en metros.
     */
    var altura: Double = 0.0
        set(value) {
            require(value > 0) { "La altura no puede ser negativa." }
            field = value
        }

    /**
     * Nombre de la persona.
     */
    var nombre: String = ""
        get() = field
        set(value) {
            require(value.trim().isNotEmpty()) { "El nombre no puede estar vacío." }
            field = value
        }

    /**
     * Índice de Masa Corporal (IMC) de la persona.
     */
    var imc: String = ""
        get() = obtenerImc()
        private set(value) {
            field = value
        }

    /**
     * Constructor secundario que permite crear una instancia de Persona
     * con nombre, peso y altura especificados.
     *
     * @param nombre Nombre de la persona.
     * @param peso Peso de la persona en kilogramos.
     * @param altura Altura de la persona en metros.
     */
    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura) {
        this.nombre = nombre
    }

    // Métodos privados...

    /**
     * Obtiene el índice de masa corporal (IMC) formateado como una cadena.
     *
     * @return Índice de Masa Corporal (IMC) formateado.
     */
    private fun obtenerImc(): String {
        return "%.2f".format(calcularImc())
    }

    /**
     * Calcula el índice de masa corporal (IMC) de la persona.
     *
     * @return Índice de Masa Corporal (IMC).
     */
    private fun calcularImc() = this.peso / (this.altura * this.altura)

    // Métodos públicos...

    /**
     * Muestra la descripción de la persona, incluyendo nombre, peso, altura
     * y el índice de masa corporal (IMC).
     */
    fun mostrarDesc() {
        println("${this.nombre} con peso ${this.peso}kg y altura ${this.altura}m tiene un IMC de ${this.imc}.")
    }
}
