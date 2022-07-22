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
    val newList = ArrayList<ItemData>()
    if (inputList == null) return null                  //evaluates if the list is null
    for((index, item) in inputList.withIndex()){
        if (item != null){
            var newInfo = ItemData(
                originalPos = index,
                originalValue = item,
                type = type(item),
                info = info(item))
            newList.add(newInfo) }}
    return newList }

// --- Type function ---
//function that analizes the type of the value
fun type(item: Any):String{
    return when(item){
        is String -> "cadena"
        is Int -> "entero"
        is Boolean -> "booleano"
        else -> "null"
    } }

// --- Info function ---
//function that provides the information about the value
fun info(item: Any):String{
    return when(item){
        is String -> "L" + item.length
        is Int -> multiple(item)
        is Boolean -> if (item) "verdadero" else "falso"
        else -> "null"
    } }

// --- Multiple function ---
//function that evaluates the multiple of an Int
fun multiple (int: Int):String{
    var info: String = "-"
    if (int%10 == 0)info = "M10"
    else if (int%5 == 0)info = "M5"
    else if (int%2 == 0)info = "M2"
    return info
}