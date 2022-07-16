/* Universidad Del Valle de Guatemala
 * Programacion de plataformas moviles
 * Emily Elvia Melissa Perez Alarcon, 21385
 * Laboratoio 02
 **/

// --- Data class ---
// Includes basic information for the data
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)

// --- Main function ---
// Executes the main program, prints the list
fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

// --- Process List function ---
// Analizes the types with their information
fun processList(inputList: List<Any?>?): List<ItemData>? {
    var i: Int = 0
    val lista = ArrayList<ItemData>()

    //evaluates if the list is null
    if (inputList == null) return null

    for (element in inputList){

        //define the variables
        var tipo: String? = ""
        var inf: String? = ""
        var p = i
        i = i+1

        if(element != null){
            when (element) {

                //string type
                is String ->{
                    tipo = "cadena"
                    inf = ("L" + element.length)
                }

                //int type
                is Int -> {
                    tipo = "entero"
                    if (element%10 == 0){
                        inf = "M10"
                    }
                    else if (element%5 == 0){
                        inf = "M5"
                    }
                    else if (element%2 == 0){
                        inf = "M2"
                    }
                    else{
                        inf = null
                    }
                }

                //boolean type
                is Boolean ->{
                    tipo = "booleano"
                    if(element == true){
                        inf = "verdadero"
                    }

                    else if(element == false){
                        inf ="falso"
                    }
                    else{
                        inf = null
                    }
                }

                //null type
                else -> {
                    tipo = null
                    inf = null
                }
            }

            //concentrates the information to the main list
            val informacion = ItemData(
                originalPos = p,
                originalValue = element,
                type = tipo,
                info = inf
            )
            lista.add(informacion)
        }
    }
    return lista
}
