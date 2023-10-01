enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(
    val nome: String, 
    val idade: Int, 
    val sexo: String = "h"
)

data class ConteudoEducacional(
    var nome: String, 
    val duracao: Int = 60
)

data class Formacao(
    val nome: String, 
    val nivel: Enum<Nivel>, 
    var conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado com sucesso em ${nome}.")
    }

    fun consultarInscritos(): List<String> {
        val listaInscritos: MutableList<String> = mutableListOf()
        
        for (inscrito in inscritos) {
            listaInscritos.add(inscrito.nome)
        }
        return listaInscritos
    }
    
    fun exibirDetalhes() {
        println()
        println("==================")
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
		for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos)")
        }
        println("Usuários matriculados [${inscritos.size}]: ${consultarInscritos()}")
        println("==================")
    }
}


fun main() {
    // Criando alguns usuários
    val usuario_1 = Usuario("Lucas", 23, "h")
    val usuario_2 = Usuario("Sophia", 21, "m")
    val usuario_3 = Usuario("Andre", 21, "h")
    val usuario_4 = Usuario("Jake", 27, "h")
    val usuario_5 = Usuario("Larissa", 25, "m")
    
    // Criando a formação e definindo seus conteúdos
    val conteudosFormacao = mutableListOf(
        ConteudoEducacional("Introdução à Programação", 12),
        ConteudoEducacional("Java", 88)
    )
    
    val conteudosFormacao2 = mutableListOf(
        ConteudoEducacional("Lógica de Programação", 10), 
        ConteudoEducacional("Funções e Classes", 20),
        ConteudoEducacional("Programação Orientada a Objetos com Python", 40),
    )

	val formacaoJava = Formacao("Bootcamp Java", Nivel.INTERMEDIARIO, conteudosFormacao)
    val formacaoPython= Formacao("Formação Python Developer", Nivel.BASICO, conteudosFormacao2)
	
    // Matriculando usuários na formação
    formacaoJava.matricular(usuario_1)
	formacaoJava.matricular(usuario_4)

    formacaoPython.matricular(usuario_2)
	formacaoPython.matricular(usuario_3)
    formacaoPython.matricular(usuario_5)
    
    // Exibindo todos os detalhes da formação
	formacaoJava.exibirDetalhes()
    formacaoPython.exibirDetalhes()
}