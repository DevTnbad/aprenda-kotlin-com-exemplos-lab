enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val id: Int, var usuario: String) {
    override fun toString(): String {
        return usuario
    }
}

data class ConteudoEducacional(var nome: String, val duracaoDias: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuarios: List<Usuario>) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
        }
    }

    fun desmatricular(idUsuario: Int): Boolean {
    	val usuarioRemovido = inscritos.removeIf { it.id == idUsuario }
    	return if (usuarioRemovido) {
        	println("Usuário com id $idUsuario removido da formação $nome.")
        	true
    	} else {
        	println("Usuário com id $idUsuario não encontrado na formação.")
        	false
    	}
	}

}

fun main() {
    val usuario1 = Usuario(1, "Toddy")
    val usuario2 = Usuario(2, "Kiara")
    val usuario3 = Usuario(3, "Fiu-fiu")
    val usuario4 = Usuario(4, "Sansao")
    val usuario5 = Usuario(5, "Nala")

    val conteudo1 = ConteudoEducacional("Introdução à programação", 10)
    val conteudo2 = ConteudoEducacional("Algoritmos e Logica", 20)
    val conteudo3 = ConteudoEducacional("Estrutura de dados", 15)
    val conteudo4 = ConteudoEducacional("Html", 15)
    val conteudo5 = ConteudoEducacional("Estatistica", 18)
    val conteudo6 = ConteudoEducacional("CSS", 16)
    val conteudo7 = ConteudoEducacional("Java Script", 30)
    val conteudo8 = ConteudoEducacional("Java", 30)
    val conteudo9 = ConteudoEducacional("Node", 30)
    

    val formacao1 = Formacao("Front-End", listOf(conteudo1, conteudo4, conteudo6, conteudo7))
    val formacao2 = Formacao("Back-End", listOf(conteudo1, conteudo2, conteudo3, conteudo8, conteudo9))
    val formacao3 = Formacao("Full Stack", listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo6, conteudo7, conteudo8, conteudo9))
    val formacao4 = Formacao("Data Analitics", listOf(conteudo2, conteudo3, conteudo5))
    
    formacao1.matricular(listOf(usuario1))
   
    formacao1.matricular(listOf(usuario2, usuario3, usuario4))
    formacao2.matricular(listOf(usuario1, usuario4))
    formacao3.matricular(listOf(usuario5))
    formacao4.matricular(listOf(usuario2, usuario3, usuario5, usuario1, usuario4))
  

    println(formacao1.inscritos)

    formacao1.desmatricular(4)
    
    
    println("Formacao1:" + formacao1.inscritos)
    println("Formacao2:" + formacao2.inscritos)
    println("Formacao3:" + formacao3.inscritos)
    println("Formacao4:" + formacao4.inscritos)
}