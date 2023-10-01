class User(val id: Int, val name: String)

object UserManager {

  private val users = mutableListOf<User>()

  fun addUser(name: String) {
    val id = users.size + 1
    users.add(User(id, name))
  }

  fun listUsers() {
    for(user in users) {
      println("${user.id} - ${user.name}")
    }  
  }
}

fun main() {
  val quantity = readLine()?.toIntOrNull() ?: 0
  
  val users = mutableListOf<User>()
  
  for (i in 1..quantity) {
    val name = readLine() ?: ""
    UserManager.addUser(name)
  }

  UserManager.listUsers()
}