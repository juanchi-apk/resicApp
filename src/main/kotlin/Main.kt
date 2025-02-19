import managers.PurchaseManager

fun main(args: Array<String>) {

    val purchaseManager = PurchaseManager()

    val userLogged = launchLogin()

    var optionSelected : Int
    do {
        println("---- Menú ----")
        println("1. Comprar")
        println("2. Carrito")
        println("3. Historial de compra")
        println("4. Cerrar Programa")
        print("Ingrese su opción: ")

        optionSelected = readln().toIntOrNull()?:0

        when(optionSelected){
//            1 -> goToShoppingMenu()
//            2 -> showCart()
            3 -> purchaseManager.showOrderPurchasesList(userLogged)
            4 -> break
        }

    } while (true)
}


