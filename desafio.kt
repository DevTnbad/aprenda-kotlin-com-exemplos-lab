enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val id: Int, var usuario: String) {
    override fun toString(): String {
        return usuario
    }
}

data class ConteudoEducacional(val nome: String, val duracaoDias: Int = 60, val nivel: Nivel)


data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    
    //######################################################################
    //
    //Testes
    //
    //######################################################################

    val inscritos = mutableSetOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
    	for (usuario in usuarios) {
        	inscritos.add(usuario)
    	}
	}

    fun desmatricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if (inscritos.remove(usuario)) {
                println("Usuário ${usuario.usuario} foi desmatriculado.")
            } else {
                println("Usuário ${usuario.usuario} não está matriculado nesta formação.")
            }
        }
    }
    
    fun getNivelMajoritario(): Nivel {
        val nivelContagem = mutableMapOf<Nivel, Int>()
        conteudos.forEach { conteudo ->
            nivelContagem[conteudo.nivel] = (nivelContagem[conteudo.nivel] ?: 0) + 1
    	}
        println("########## $nivelContagem")
    	return nivelContagem.maxByOrNull { it.value }?.key ?: Nivel.BASICO
}

}

fun main() {
    val usuario1 = Usuario(1, "Toddy")
    val usuario2 = Usuario(2, "Kiara")
    val usuario3 = Usuario(3, "Fiu-fiu")
    val usuario4 = Usuario(4, "Sansao")
    val usuario5 = Usuario(5, "Nala")

    val conteudo1 = ConteudoEducacional("Introdução à programação", 10, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritmos e Logica", 20, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Estrutura de dados", 15, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("Html", 15, Nivel.BASICO)
    val conteudo5 = ConteudoEducacional("Estatistica", 18, Nivel.AVANCADO)
    val conteudo6 = ConteudoEducacional("CSS", 16, Nivel.BASICO)
    val conteudo7 = ConteudoEducacional("Java Script", 30, Nivel.INTERMEDIARIO)
    val conteudo8 = ConteudoEducacional("Java", 30, Nivel.INTERMEDIARIO)
    val conteudo9 = ConteudoEducacional("Node", 30, Nivel.BASICO)
    val conteudo10 = ConteudoEducacional("Spring Boot Java", 10, Nivel.INTERMEDIARIO)
    val conteudo11 = ConteudoEducacional("React", 10, Nivel.INTERMEDIARIO)
    val conteudo12 = ConteudoEducacional("API RREST", 10, Nivel.INTERMEDIARIO)
    val conteudo13 = ConteudoEducacional("Tratamento de dados - ELT", 10, Nivel.AVANCADO)
    val conteudo14 = ConteudoEducacional("Python", 10, Nivel.AVANCADO)
    val conteudo15 = ConteudoEducacional("Docker", 10, Nivel.INTERMEDIARIO)    

    val formacao1 = Formacao("Front-End", listOf(conteudo1, conteudo4, conteudo6, conteudo7))
    val formacao2 = Formacao("Back-End", listOf(conteudo1, conteudo2, conteudo3, conteudo8, conteudo9))
    val formacao3 = Formacao("Full Stack", listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo6, conteudo7, conteudo8, conteudo9))
    val formacao4 = Formacao("Data Analitics", listOf(conteudo2, conteudo3, conteudo5, conteudo13, conteudo14))
    
    formacao1.matricular(usuario1)
   
    formacao1.matricular(usuario1, usuario2, usuario3, usuario4)
    formacao2.matricular(usuario1, usuario4)
    formacao3.matricular(usuario5)
    formacao4.matricular(usuario2, usuario3, usuario5, usuario1, usuario4)

    println(formacao1.inscritos)

    formacao1.desmatricular(usuario1) // poderia colocar somente o id
    formacao4.desmatricular(usuario3, usuario4)
      
    println("Formacao1:" + formacao1.inscritos)
    println("Formacao2:" + formacao2.inscritos)
    println("Formacao3:" + formacao3.inscritos)
    println("Formacao4:" + formacao4.inscritos)
    println("Nivel da formacao 1: " + formacao1.getNivelMajoritario())
    println("Nivel da formacao 2: " + formacao2.getNivelMajoritario())
    println("Nivel da formacao 3: " + formacao3.getNivelMajoritario())
    println("Nivel da formacao 4: " + formacao4.getNivelMajoritario())
    
}