import data.User
import repositories.UserRepository.isUserValid

fun launchLogin(): User {
    var nickName: String
    var password: String

        println("---- Login ----")
    do {
        print("Ingrese su nombre de usuario: ")
        nickName = readln()
        print("Ingrese su contraseña: ")
        password = readln()

        val user = isUserValid(nickNameToFind = nickName, passwordToFind = password)

        if (user != null) {
            println("¡Inicio de sesión exitoso! Bienvenido, ${user.nickName}")
            return user
        } else {
            println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.")
            println("----     ----")
        }
    } while (true)
}