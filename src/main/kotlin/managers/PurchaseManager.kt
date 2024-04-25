package managers

import data.User
import repositories.ProductRepository
import repositories.PurchaseRepository

class PurchaseManager {
    private val productRepository = ProductRepository
    fun showOrderPurchasesList(user: User) {
        val purchasesList = getPurchases(user.id)

        if (purchasesList.isEmpty())
            println("Usted aun no ah realizado ninguna compra")
        else {
            println("---- HISTORIAL DE COMPRA ----")
            purchasesList.forEach { purchase ->
                val product = productRepository.getProductById(purchase.productId)!!
                val totalPaid = (purchase.amount * product.price).toInt()
                println("Fecha: ${purchase.createdDate}")
                println("Pedido: ${product.name}, ${purchase.amount} unidad/es")
                println("Total abonado: $$totalPaid")
                println("- - - - - - - - - - - - - - - - -")
            }
        }

    }

    private fun getPurchases(userId: Long) =
        PurchaseRepository.getAllPurchases().filter { it.userId == userId }
}