fun main() {
  val titulo = readLine() ?: ""
  val autor = readLine() ?: ""
  
  // Aqui usamos a Extension Function "generateSlug()" nas Strings de Entrada.
  val slugTitulo = titulo.generateSlug()
  val slugAutor = autor.generateSlug()
  
  println("Slug gerado para o livro:")
  print(slugTitulo + "_" + slugAutor)
}

fun String.generateSlug(): String {
  return this.replace("\\s".toRegex(), "-").lowercase().replace(".", "")
}